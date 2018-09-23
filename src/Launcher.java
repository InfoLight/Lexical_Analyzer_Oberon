/**
 * This class is a launcher in lexical analyzer project.
 */
public class Launcher {
    public static void main(String[] args) {

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer("in.txt", "out.txt");
        lexicalAnalyzer.launch();

    }
}
