import java.io.*;
import java.util.HashMap;
import java.util.regex.*;

/**
 * This class represents lexical analyzer. It gets input and output file names. It is able to split Oberon code from
 * input file into tokens describing each one and write into output file. If some error appears, it will be written
 * to output file.
 */
public class LexicalAnalyzer {

    private BufferedReader in; // input reader to read each character
    private PrintWriter out; // output writer to file

    private HashMap<String, Integer> symbolsMap = new HashMap<>(); // hash map containing pair of (lexeme-integer value)

    private Token token; // represents one active token

    private boolean isComment = false; // boolean value representing if reading characters are inside of a comment

    // Regular expressions:
    private Pattern commentRegExp = Pattern.compile("^.*?(\\(\\*|\\*\\)|\\(\\*.*\\*\\)).*");

    private Pattern commentEndingRegExp = Pattern.compile("^.*?(\\*\\)).*"); // required to simplify process
    // of determining when comment ends

    private Pattern symbolRegExp = Pattern.compile("^(&|\\^|:=|:|,|\\.\\.|\\.|\\||=|>|>=|\\{|\\[|\\(|<|<=|" +
            "-|#|\\+|}|]|\\)|;|~|/|\\*)");

    private Pattern keywordRegExp = Pattern.compile("^(ARRAY|BEGIN|BY|CASE|CONST|DIV|DO|ELSE|ELSIF|END|EXIT|" +
            "FOR|IF|IMPORT|IN|INCLUDE|IS|LOOP|MOD|MODULE|NIL|OF|OR|POINTER|PROCEDURE|RECORD|REPEAT|RETURN|" +
            "THEN|TO|TYPE|UNTIL|VAR|WITH|WHILE|ABS|ASR|ASSERT|BOOLEAN|BYTE|CHAR|CHR|DEC|EXCL|FALSE|FLOOR|FLT|INC|" +
            "INCL|INTEGER|LEN|LSL|NEW|ODD|ORD|PACK|REAL|ROR|SET|TRUE|UNPK)$");

    /**
     * Constructor.
     *
     * @param inputFileName  input file name
     * @param outputFileName output file name
     */
    public LexicalAnalyzer(String inputFileName, String outputFileName) {
        try {
            in = new BufferedReader(new FileReader(inputFileName));
        } catch (IOException e) {
            out.println(("ERROR: no such input file or problems appeared while opening..."));
        }

        try {
            out = new PrintWriter(new FileWriter(outputFileName));
        } catch (IOException e) {
            out.println("ERROR: problems with writing to output file...");
        }

        symbolsMap = SymbolsNumbers.getSymbolsMap();
    }

    /**
     * Method which is needed to recognize the tokens.
     *
     * @param tokenString string which is needed to recognize
     * @return token
     */
    private Token recognizeToken(String tokenString) {
        token = null;

        Matcher keywordMatcher = keywordRegExp.matcher(tokenString); // matcher for predefined keywords
        Matcher symbolMatcher = symbolRegExp.matcher(tokenString); // matcher for predefined symbols

        if (keywordMatcher.find() || symbolMatcher.find()) {
            // if the string is a predefined keyword:

            if (symbolsMap.containsKey(tokenString)) {
                token = new Token(symbolsMap.get(tokenString), tokenString);
            }
        } else if (tokenString.matches("^([0-9]+[a-fA-F0-9]*[hH]*)$")) {
            // if string is integer literal:

            // check if hexadecimal is incorrect (contains A-F, but does not end with H):
            if (tokenString.matches("^.*?[a-fA-F].*$") && !tokenString.endsWith("H")) {
                out.println("ERROR: hexadecimal is incorrect...");
            }

            token = new Token(SymbolsNumbers.INT_LITERAL, tokenString);

        } else if (tokenString.matches("^([0-9]+[a-fA-F0-9]*[xX]*)$")) {
            // if string is char literal:

            token = new Token(SymbolsNumbers.CHAR_LITERAL, tokenString);

        } else if (tokenString.matches("^[a-zA-Z][a-zA-Z0-9]*$")) {
            // if string is identifier:

            if (tokenString.equals("EOF")) {
                // if it is the end of file:

                token = new Token(SymbolsNumbers.EOF, "EOF");
                return token;
            }

            token = new Token(SymbolsNumbers.IDENTIFIER, tokenString);

        } else if (tokenString.matches("(\"[^\"]*\"|\'[^\']*\')")) {
            // if string is string literal:

            String tempString = tokenString.substring(1, tokenString.length() - 1); // remove left and right quotes

            token = new Token(SymbolsNumbers.STRING_LITERAL, tempString);

        } else {
            // Something that can't be handled:
            if (!tokenString.isEmpty()) {
                out.println("ERROR: cannot process this string: " + tokenString);
            }
        }

        return token;
    }

    /**
     * Method, which returns next token from input file. When file ends, it returns special EOF token.
     *
     * @return next token
     */
    public Token getNextToken() {
        try {
            StringBuilder currentString = new StringBuilder(""); // current active chars collection which is not
            // turned into token yet
            StringBuilder commentInternals = new StringBuilder(""); // needed to know if comment ends

            int currentCharIntegerRepresentation; // integer value representing current read character
            while ((currentCharIntegerRepresentation = in.read()) != -1) {
                // while not the end of file:

                char currentChar = (char) currentCharIntegerRepresentation; // cast read value to character

                //If file ends, but comment is not ended:
                if (lookAtNextCharacter() == -1 && this.isComment) {
                    out.println("ERROR: comment is not ended...");
                }

                if (Character.isWhitespace(currentChar)) {
                    // if character is whitespace:

                    if (currentString.toString().matches("(\"[^\"]*(?!\")|\'[^\']*(?!\'))")) {
                        // when whitespace inside of string literal:

                        if (currentChar == ' ') {
                            currentString.append(currentChar); // just append
                        }

                        if (currentChar == '\r' || currentChar == '\n' || lookAtNextCharacter() == -1) {
                            // if line or file ends and string literal is not closed, then output error:

                            out.println("ERROR: String literal is not finished...");
                            currentString = new StringBuilder("");
                        }
                        continue;
                    }


                    // To skip whitespaces in code:
                    if (recognizeToken(currentString.toString()) != null) {
                        // if space is end of something, then return token:

                        return this.token;
                    } else {
                        // if not, then reset active string:
                        currentString = new StringBuilder("");
                        continue;
                    }
                }

                if (this.isComment) {
                    // if currently in comment:

                    commentInternals.append(currentChar); // append currently read char to comment string

                    if (currentChar == ')' && commentEndingRegExp.matcher(commentInternals).matches()) {
                        // if comment seems to end:

                        if (isCommentEnded(commentInternals.toString())) {
                            // if comment is ended:

                            this.isComment = false;
                            commentInternals = new StringBuilder("");
                        }
                    }

                } else {
                    // if current character is not inside of a comment:

                    currentString.append(currentChar); // append next char to current active string

                    if (currentString.toString().matches("^[a-zA-Z0-9]+$") ||
                            currentString.toString().matches("(\"[^\"]*\"|\'[^\']*\')")) {
                        // if lexeme satisfies for identifier or string:

                        if (isNextCharIsPunctuation(Character.MIN_VALUE)) {
                            // If current plus next are predefined punctuation symbols:

                            // Check if string ends (e.g some symbol):
                            if (recognizeToken(currentString.toString()) != null) {
                                return this.token;
                            } else {
                                currentString = new StringBuilder("");
                            }
                        }
                    }

                    if (!currentString.toString().matches("^.*?([\'\"])+.*$")
                            && currentChar == '*' && commentRegExp.matcher(currentString).matches()) {
                        // if comment starts:

                        currentString = new StringBuilder(currentString.substring(0,
                                currentString.indexOf("(*"))); // remove (* from current string
                        this.isComment = true;
                        commentInternals.append("(*"); // start filling comment
                        continue;
                    }

                    Matcher symbolMatcher = symbolRegExp.matcher(currentString);
                    if (symbolMatcher.matches()) {
                        // if current lexeme is punctuation:

                        if (!isNextCharIsPunctuation(currentChar)) {
                            // if current lexeme is symbol, but current + next together is not
                            // predefined punctuation, then process current symbol:

                            return recognizeToken(currentString.toString());
                        }
                    }
                }
            }
        } catch (IOException e) {
            // if some exception appears with file reading:

            out.println("ERROR: problems with reading input file...");
        }

        // After every symbol is read from file, return EOF:
        return (new Token(SymbolsNumbers.EOF, "EOF"));
    }

    /**
     * Method which is used to determine if comment inside of a provided string is ended.
     *
     * @param comment string to check
     * @return boolean value of ended
     */
    private boolean isCommentEnded(String comment) {
        // comments may be nested, so we need to handle it:

        int commentBeginsCount = 0; // number of (*
        int commentEndsCount = 0; // number of *)
        int lastFound = 0; // index where last seen

        while (lastFound != -1) {
            // until (* not found:

            lastFound = comment.indexOf("(*", lastFound);
            if (lastFound != -1) {
                // if (* is found, increase count and in next iteration start searching after found symbols' position:

                commentBeginsCount++;
                lastFound += 2; // skip (*
            }
        }

        lastFound = 0; // reset

        while (lastFound != -1) {
            // until *) not found:

            lastFound = comment.indexOf("*)", lastFound);
            if (lastFound != -1) {
                // if *) is found, increase count and in next iteration start searching after found symbols' position:

                commentEndsCount++;
                lastFound += 2; // skip *)
            }
        }

        // If opened number equals to closed, then comment is ended:
        return commentBeginsCount == commentEndsCount;
    }

    /**
     * Check if next character in file after current + current is predefined punctuation:
     *
     * @param currentSymbol current character
     * @return boolean value
     */
    private boolean isNextCharIsPunctuation(char currentSymbol) {
        char nextCharAfterCurrent = (char) lookAtNextCharacter(); // check the next character

        String tempString = Character.toString(currentSymbol) + Character.toString(nextCharAfterCurrent); // create
        // string of current and next
        Matcher symbolMatcher = symbolRegExp.matcher(Character.toString(nextCharAfterCurrent)); // matcher to find
        // symbols

        // return true if the char we read is punctuation and string we got is a predefined punctuation
        return symbolMatcher.find() && (tempString.equals("(*") || symbolsMap.containsKey(tempString.trim()));
    }

    /**
     * This method reads next character after current in file and resets position of reader back as if it was not read.
     *
     * @return integer value of character
     */
    private int lookAtNextCharacter() {
        try {
            in.mark(1); // remember position
            int currentChar = in.read();
            in.reset(); // reset position

            return currentChar;
        } catch (IOException e) {
            out.println("ERROR: problems with reading input file...");
            return -1;
        }
    }

    /**
     * This method launches the process of lexical analysis of input file.
     */
    public void launch() {

        Token currentToken; // token which is now processing

        while (true) {
            currentToken = getNextToken();

            if (currentToken.getNumberInMap() == SymbolsNumbers.EOF) {
                try {
                    in.close();
                } catch (IOException e) {
                    out.println("Problem with closing input file...");
                }
                out.close();
                break;
            }

            out.println(currentToken.getLexeme() + "       " + SymbolsNumbers.lexemeType(currentToken.getNumberInMap()));

        }
    }
}
