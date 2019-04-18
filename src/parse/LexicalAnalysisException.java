package parse;

public class LexicalAnalysisException extends Exception {
    public LexicalAnalysisException(char c) {
        super("LexicalAnalysisException error.");
    }

    public LexicalAnalysisException(String str) {
        super("LexicalAnalysisException error:"+str);
    }
}
