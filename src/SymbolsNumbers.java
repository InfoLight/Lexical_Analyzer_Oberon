import java.util.HashMap;

/**
 * This class contains integer values for each lexeme, can create hash map, can return output representation for
 * each lexeme.
 */
public class SymbolsNumbers {

    public static final int ABS = 1;
    public static final int AMPERSAND = 2;
    public static final int ARRAY = 3;
    public static final int ARROW_UP = 4;
    public static final int ASR = 5;
    public static final int ASSERT = 6;
    public static final int ASSIGN = 7;
    public static final int BAR = 8;
    public static final int BEGIN = 9;
    public static final int BOOLEAN = 10;
    public static final int BY = 11;
    public static final int BYTE = 12;
    public static final int CASE = 13;
    public static final int CHAR = 14;
    public static final int CHAR_LITERAL = 15;
    public static final int CHR = 16;
    public static final int COLON = 17;
    public static final int COMMA = 18;
    public static final int CONST = 19;
    public static final int DEC = 20;
    public static final int DIV = 21;
    public static final int DO = 22;
    public static final int DOT = 23;
    public static final int DOUBLE_DOT = 24;
    public static final int ELSE = 25;
    public static final int ELSIF = 26;
    public static final int END = 27;
    public static final int EOF = 28;
    public static final int EQUAL = 29;
    public static final int EXCL = 30;
    public static final int EXIT = 31;
    public static final int FALSE = 32;
    public static final int FLOOR = 33;
    public static final int FLT = 34;
    public static final int FOR = 35;
    public static final int GREATER = 36;
    public static final int GREATER_EQUAL = 37;
    public static final int IDENTIFIER = 38;
    public static final int IF = 39;
    public static final int IMPORT = 40;
    public static final int IN = 41;
    public static final int INC = 42;
    public static final int INCL = 43;
    public static final int INCLUDE = 44;
    public static final int INT_LITERAL = 45;
    public static final int INTEGER = 46;
    public static final int IS = 47;
    public static final int OPEN_BRACE = 48;
    public static final int OPEN_BRACKET = 49;
    public static final int OPEN_PARENTHESIS = 50;
    public static final int LEN = 51;
    public static final int LESS = 52;
    public static final int LESS_EQUAL = 53;
    public static final int LOOP = 54;
    public static final int LSL = 55;
    public static final int MINUS = 56;
    public static final int MOD = 57;
    public static final int MODULE = 58;
    public static final int NEW = 59;
    public static final int NIL = 60;
    public static final int NOT_EQUAL = 61;
    public static final int ODD = 62;
    public static final int OF = 63;
    public static final int OR = 64;
    public static final int ORD = 65;
    public static final int PACK = 66;
    public static final int PLUS = 67;
    public static final int POINTER = 68;
    public static final int PROCEDURE = 69;
    public static final int REAL = 70;
    public static final int REAL_LITERAL = 71;
    public static final int RECORD = 72;
    public static final int REPEAT = 73;
    public static final int RETURN = 74;
    public static final int CLOSE_BRACE = 75;
    public static final int CLOSE_BRACKET = 76;
    public static final int CLOSE_PARENTHESIS = 77;
    public static final int ROR = 78;
    public static final int SEMICOLON = 79;
    public static final int SET = 80;
    public static final int SLASH = 81;
    public static final int STAR = 82;
    public static final int STRING_LITERAL = 83;
    public static final int TILDE = 84;
    public static final int THEN = 85;
    public static final int TO = 86;
    public static final int TRUE = 87;
    public static final int TYPE = 88;
    public static final int UNPK = 89;
    public static final int UNTIL = 90;
    public static final int VAR = 91;
    public static final int WITH = 92;
    public static final int WHILE = 93;

    /**
     * This method returns filled symbols hash map containing pair of word and integer value.
     *
     * @return filled map
     */
    public static HashMap<String, Integer> getSymbolsMap() {
        HashMap<String, Integer> symbolsMap = new HashMap<>();

        symbolsMap.put("ABS", SymbolsNumbers.ABS);
        symbolsMap.put("ARRAY", SymbolsNumbers.ARRAY);
        symbolsMap.put("ASSERT", SymbolsNumbers.ASSERT);
        symbolsMap.put("ASR", SymbolsNumbers.ASR);
        symbolsMap.put("BEGIN", SymbolsNumbers.BEGIN);
        symbolsMap.put("BY", SymbolsNumbers.BY);
        symbolsMap.put("CASE", SymbolsNumbers.CASE);
        symbolsMap.put("CHR", SymbolsNumbers.CHR);
        symbolsMap.put("CONST", SymbolsNumbers.CONST);
        symbolsMap.put("DEC", SymbolsNumbers.DEC);
        symbolsMap.put("DIV", SymbolsNumbers.DIV);
        symbolsMap.put("DO", SymbolsNumbers.DO);
        symbolsMap.put("ELSE", SymbolsNumbers.ELSE);
        symbolsMap.put("ELSIF", SymbolsNumbers.ELSIF);
        symbolsMap.put("END", SymbolsNumbers.END);
        symbolsMap.put("EXCL", SymbolsNumbers.EXCL);
        symbolsMap.put("EXIT", SymbolsNumbers.EXIT);
        symbolsMap.put("FLOOR", SymbolsNumbers.FLOOR);
        symbolsMap.put("FLT", SymbolsNumbers.FLT);
        symbolsMap.put("FOR", SymbolsNumbers.FOR);
        symbolsMap.put("IF", SymbolsNumbers.IF);
        symbolsMap.put("IMPORT", SymbolsNumbers.IMPORT);
        symbolsMap.put("IN", SymbolsNumbers.IN);
        symbolsMap.put("INC", SymbolsNumbers.INC);
        symbolsMap.put("INCL", SymbolsNumbers.INCL);
        symbolsMap.put("INCLUDE", SymbolsNumbers.INCLUDE);
        symbolsMap.put("IS", SymbolsNumbers.IS);
        symbolsMap.put("LEN", SymbolsNumbers.LEN);
        symbolsMap.put("LSL", SymbolsNumbers.LSL);
        symbolsMap.put("LOOP", SymbolsNumbers.LOOP);
        symbolsMap.put("MOD", SymbolsNumbers.MOD);
        symbolsMap.put("MODULE", SymbolsNumbers.MODULE);
        symbolsMap.put("NIL", SymbolsNumbers.NIL);
        symbolsMap.put("ODD", SymbolsNumbers.ODD);
        symbolsMap.put("ORD", SymbolsNumbers.ORD);
        symbolsMap.put("OF", SymbolsNumbers.OF);
        symbolsMap.put("OR", SymbolsNumbers.OR);
        symbolsMap.put("PACK", SymbolsNumbers.PACK);
        symbolsMap.put("POINTER", SymbolsNumbers.POINTER);
        symbolsMap.put("PROCEDURE", SymbolsNumbers.PROCEDURE);
        symbolsMap.put("RECORD", SymbolsNumbers.RECORD);
        symbolsMap.put("REPEAT", SymbolsNumbers.REPEAT);
        symbolsMap.put("RETURN", SymbolsNumbers.RETURN);
        symbolsMap.put("ROR", SymbolsNumbers.ROR);
        symbolsMap.put("SET", SymbolsNumbers.SET);
        symbolsMap.put("THEN", SymbolsNumbers.THEN);
        symbolsMap.put("TO", SymbolsNumbers.TO);
        symbolsMap.put("TYPE", SymbolsNumbers.TYPE);
        symbolsMap.put("UNPK", SymbolsNumbers.UNPK);
        symbolsMap.put("UNTIL", SymbolsNumbers.UNTIL);
        symbolsMap.put("VAR", SymbolsNumbers.VAR);
        symbolsMap.put("WHILE", SymbolsNumbers.WHILE);
        symbolsMap.put("WITH", SymbolsNumbers.WITH);
        symbolsMap.put("&", SymbolsNumbers.AMPERSAND);
        symbolsMap.put("^", SymbolsNumbers.ARROW_UP);
        symbolsMap.put(":=", SymbolsNumbers.ASSIGN);
        symbolsMap.put("|", SymbolsNumbers.BAR);
        symbolsMap.put(":", SymbolsNumbers.COLON);
        symbolsMap.put(",", SymbolsNumbers.COMMA);
        symbolsMap.put("..", SymbolsNumbers.DOUBLE_DOT);
        symbolsMap.put(".", SymbolsNumbers.DOT);
        symbolsMap.put("=", SymbolsNumbers.EQUAL);
        symbolsMap.put(">", SymbolsNumbers.GREATER);
        symbolsMap.put(">=", SymbolsNumbers.GREATER_EQUAL);
        symbolsMap.put("{", SymbolsNumbers.OPEN_BRACE);
        symbolsMap.put("[", SymbolsNumbers.OPEN_BRACKET);
        symbolsMap.put("(", SymbolsNumbers.OPEN_PARENTHESIS);
        symbolsMap.put("<", SymbolsNumbers.LESS);
        symbolsMap.put("<=", SymbolsNumbers.LESS_EQUAL);
        symbolsMap.put("-", SymbolsNumbers.MINUS);
        symbolsMap.put("#", SymbolsNumbers.NOT_EQUAL);
        symbolsMap.put("+", SymbolsNumbers.PLUS);
        symbolsMap.put("}", SymbolsNumbers.CLOSE_BRACE);
        symbolsMap.put("]", SymbolsNumbers.CLOSE_BRACKET);
        symbolsMap.put(")", SymbolsNumbers.CLOSE_PARENTHESIS);
        symbolsMap.put(";", SymbolsNumbers.SEMICOLON);
        symbolsMap.put("~", SymbolsNumbers.TILDE);
        symbolsMap.put("/", SymbolsNumbers.SLASH);
        symbolsMap.put("*", SymbolsNumbers.STAR);
        symbolsMap.put("BOOLEAN", SymbolsNumbers.BOOLEAN);
        symbolsMap.put("BYTE", SymbolsNumbers.BYTE);
        symbolsMap.put("CHAR", SymbolsNumbers.CHAR);
        symbolsMap.put("FALSE", SymbolsNumbers.FALSE);
        symbolsMap.put("INTEGER", SymbolsNumbers.INTEGER);
        symbolsMap.put("NEW", SymbolsNumbers.NEW);
        symbolsMap.put("REAL", SymbolsNumbers.REAL);
        symbolsMap.put("TRUE", SymbolsNumbers.TRUE);

        return symbolsMap;
    }

    /**
     * This method returns string describing lexeme given as parameter (used for output).
     *
     * @param numberInMap integer value of lexeme relation in map
     * @return output string
     */
    public static String lexemeType(int numberInMap) {
        switch (numberInMap) {
            case SymbolsNumbers.ARRAY:
                return "keyword 'ARRAY'";
            case SymbolsNumbers.BEGIN:
                return "keyword 'BEGIN'";
            case SymbolsNumbers.BY:
                return "keyword 'BY'";
            case SymbolsNumbers.CASE:
                return "keyword 'CASE'";
            case SymbolsNumbers.CONST:
                return "keyword 'CONST'";
            case SymbolsNumbers.DIV:
                return "keyword 'DIV'";
            case SymbolsNumbers.DO:
                return "keyword 'DO'";
            case SymbolsNumbers.ELSE:
                return "keyword 'ELSE'";
            case SymbolsNumbers.ELSIF:
                return "keyword 'ELSIF'";
            case SymbolsNumbers.END:
                return "keyword 'END'";
            case SymbolsNumbers.EXIT:
                return "keyword 'EXIT'";
            case SymbolsNumbers.FOR:
                return "keyword 'FOR'";
            case SymbolsNumbers.IF:
                return "keyword 'IF'";
            case SymbolsNumbers.IMPORT:
                return "keyword 'IMPORT'";
            case SymbolsNumbers.IN:
                return "keyword 'IN'";
            case SymbolsNumbers.INCLUDE:
                return "keyword 'INCLUDE'";
            case SymbolsNumbers.IS:
                return "keyword 'IS'";
            case SymbolsNumbers.LOOP:
                return "keyword 'LOOP'";
            case SymbolsNumbers.MOD:
                return "keyword 'MOD'";
            case SymbolsNumbers.MODULE:
                return "keyword 'MODULE'";
            case SymbolsNumbers.NIL:
                return "keyword 'NIL'";
            case SymbolsNumbers.OF:
                return "keyword 'OF'";
            case SymbolsNumbers.OR:
                return "keyword 'OR'";
            case SymbolsNumbers.POINTER:
                return "keyword 'POINTER'";
            case SymbolsNumbers.PROCEDURE:
                return "keyword 'PROCEDURE'";
            case SymbolsNumbers.RECORD:
                return "keyword 'RECORD'";
            case SymbolsNumbers.REPEAT:
                return "keyword 'REPEAT'";
            case SymbolsNumbers.RETURN:
                return "keyword 'RETURN'";
            case SymbolsNumbers.THEN:
                return "keyword 'THEN'";
            case SymbolsNumbers.TO:
                return "keyword 'TO'";
            case SymbolsNumbers.TYPE:
                return "keyword 'TYPE'";
            case SymbolsNumbers.UNTIL:
                return "keyword 'UNTIL'";
            case SymbolsNumbers.VAR:
                return "keyword 'VAR'";
            case SymbolsNumbers.WITH:
                return "keyword 'WITH'";
            case SymbolsNumbers.WHILE:
                return "keyword 'WHILE'";
            case SymbolsNumbers.ABS:
                return "predefined identifier 'ABS'";
            case SymbolsNumbers.ASR:
                return "predefined identifier 'ASR'";
            case SymbolsNumbers.ASSERT:
                return "predefined identifier 'ASSERT'";
            case SymbolsNumbers.BOOLEAN:
                return "predefined identifier 'BOOLEAN'";
            case SymbolsNumbers.BYTE:
                return "predefined identifier 'BYTE'";
            case SymbolsNumbers.CHAR:
                return "predefined identifier 'CHAR'";
            case SymbolsNumbers.CHR:
                return "predefined identifier 'CHR'";
            case SymbolsNumbers.DEC:
                return "predefined identifier 'DEC'";
            case SymbolsNumbers.EXCL:
                return "predefined identifier 'EXCL'";
            case SymbolsNumbers.FALSE:
                return "predefined identifier 'FALSE'";
            case SymbolsNumbers.FLOOR:
                return "predefined identifier 'FLOOR'";
            case SymbolsNumbers.FLT:
                return "predefined identifier 'FLT'";
            case SymbolsNumbers.INC:
                return "predefined identifier 'INC'";
            case SymbolsNumbers.INCL:
                return "predefined identifier 'INCL'";
            case SymbolsNumbers.INTEGER:
                return "predefined identifier 'INTEGER";
            case SymbolsNumbers.LEN:
                return "predefined identifier 'LEN'";
            case SymbolsNumbers.LSL:
                return "predefined identifier 'LSL'";
            case SymbolsNumbers.NEW:
                return "predefined identifier 'NEW'";
            case SymbolsNumbers.ODD:
                return "predefined identifier 'ODD'";
            case SymbolsNumbers.ORD:
                return "predefined identifier 'ORD'";
            case SymbolsNumbers.PACK:
                return "predefined identifier 'PACK'";
            case SymbolsNumbers.REAL:
                return "predefined identifier 'REAL'";
            case SymbolsNumbers.ROR:
                return "predefined identifier 'ROR'";
            case SymbolsNumbers.SET:
                return "predefined identifier 'SET'";
            case SymbolsNumbers.TRUE:
                return "predefined identifier 'TRUE'";
            case SymbolsNumbers.UNPK:
                return "predefined identifier 'UNPK'";
            case SymbolsNumbers.AMPERSAND:
                return "punctuation symbol ampersand";
            case SymbolsNumbers.ARROW_UP:
                return "punctuation symbol arrow up";
            case SymbolsNumbers.ASSIGN:
                return "punctuation symbol assign";
            case SymbolsNumbers.BAR:
                return "punctuation symbol bar";
            case SymbolsNumbers.COLON:
                return "punctuation symbol colon";
            case SymbolsNumbers.COMMA:
                return "punctuation symbol comma";
            case SymbolsNumbers.DOUBLE_DOT:
                return "punctuation symbol double dot";
            case SymbolsNumbers.DOT:
                return "punctuation symbol dot";
            case SymbolsNumbers.EQUAL:
                return "punctuation symbol equal";
            case SymbolsNumbers.GREATER:
                return "punctuation symbol greater";
            case SymbolsNumbers.GREATER_EQUAL:
                return "punctuation symbol greater or equal";
            case SymbolsNumbers.OPEN_BRACE:
                return "punctuation symbol open brace";
            case SymbolsNumbers.OPEN_BRACKET:
                return "punctuation symbol open bracket";
            case SymbolsNumbers.OPEN_PARENTHESIS:
                return "punctuation symbol open parenthesis";
            case SymbolsNumbers.LESS:
                return "punctuation symbol less";
            case SymbolsNumbers.LESS_EQUAL:
                return "punctuation symbol less or equal";
            case SymbolsNumbers.MINUS:
                return "punctuation symbol minus";
            case SymbolsNumbers.NOT_EQUAL:
                return "punctuation symbol not equal";
            case SymbolsNumbers.PLUS:
                return "punctuation symbol plus";
            case SymbolsNumbers.CLOSE_BRACE:
                return "punctuation symbol close brace";
            case SymbolsNumbers.CLOSE_BRACKET:
                return "punctuation symbol close bracket";
            case SymbolsNumbers.CLOSE_PARENTHESIS:
                return "punctuation symbol close parenthesis";
            case SymbolsNumbers.SEMICOLON:
                return "punctuation symbol semicolon";
            case SymbolsNumbers.SLASH:
                return "punctuation symbol slash";
            case SymbolsNumbers.STAR:
                return "punctuation symbol star";
            case SymbolsNumbers.TILDE:
                return "punctuation symbol tilde";
            case SymbolsNumbers.IDENTIFIER:
                return "identifier";
            case SymbolsNumbers.INT_LITERAL:
                return "integer literal";
            case SymbolsNumbers.STRING_LITERAL:
                return "string literal";
            case SymbolsNumbers.REAL_LITERAL:
                return "real literal";
            case SymbolsNumbers.CHAR_LITERAL:
                return "character literal";
        }
        return "";
    }
}

