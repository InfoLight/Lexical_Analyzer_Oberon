/**
 * This class represents token, which contains number pointing to map and exact lexeme.
 */
public class Token {

    private String lexeme; // lexeme itself
    private int numberInMap; // integer value of which lexeme in map


    public Token(int numberInMap, String lexeme) {
        this.numberInMap = numberInMap;
        this.lexeme = lexeme;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public int getNumberInMap() {
        return numberInMap;
    }

    public void setNumberInMap(int numberInMap) {
        this.numberInMap = numberInMap;
    }
}

