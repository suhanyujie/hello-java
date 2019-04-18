package parse;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LexAndAnalysis {
    private State state;
    private  final LinkedList<Token> tokenBuffer = new LinkedList<>();
    private  StringBuilder readBuffer = null;

    private boolean transferredMeaningSign;

    private static final HashMap<Character,Character> StringTMMap = new HashMap<>();

    private static enum State {
        Normal,
        Identifier,Sign,Annotation,
        String,RegEx,Space;
    }

    private static final char[] IdentifierRearSign = new char[]{'?','!'};

    static {
        StringTMMap.put('\"', '\"');
        StringTMMap.put('\'', '\'');
        StringTMMap.put('\\', '\\');
        StringTMMap.put('b', '\b');
        StringTMMap.put('f', '\f');
        StringTMMap.put('t', '\t');
        StringTMMap.put('r', '\r');
        StringTMMap.put('n', '\n');
    }

    private Token endToken = null;
    private Reader reader;

    public void LexicalAnalysis(Reader reader){
        this.reader = reader;
        this.state = State.Normal;
    }

    public Token read() throws IOException,LexicalAnalysisException {
        if (endToken != null) {
            return endToken;
        }
        while (tokenBuffer.isEmpty()) {
            int read = reader.read();
            char c = (read == -1 ? '\0' : (char) read);
            while(!readChar(c)) {}
        }
        Token token = tokenBuffer.removeLast();
        if (token.type == Token.Type.EndSymbol) {
            endToken = token;
        }

        return token;
    }

    private void refreshBuffer(char c){
        readBuffer = new StringBuilder();
        readBuffer.append(c);
    }

    private void createToken(Token.Type type){
        Token token = new Token(type, readBuffer.toString());
        tokenBuffer.addFirst(token);
        readBuffer = null;
    }

    private void createToken(Token.Type type,String value){
        Token token = new Token(type, value);
        tokenBuffer.addFirst(token);
        readBuffer = null;
    }

    private boolean readChar(char c) throws LexicalAnalysisException {
        boolean moveCursor = true;
        Token.Type createType = null;
        if (!include(FilterChar, c)) {
            if (state == State.Normal) {
                if (inIdentifierSetButNotRear(c)) {
                    state = State.Identifier;
                } else if (SignParser.inCharSet(c)) {
                    state = State.Sign;
                } else if (c == '#') {
                    state = State.Sign;
                } else if (c == '\"' | c == '\'') {
                    state = State.String;
                    transferredMeaningSign = false;
                } else if (c == '`') {
                    state = State.RegEx;
                    transferredMeaningSign = false;
                } else if (include(Space,c)) {
                    state = State.Space;
                } else if (c == '\n') {
                    createType = Token.Type.NewLine;
                } else if (c == '\0') {
                    createType = Token.Type.EndSymbol;
                } else {
                    throw new LexicalAnalysisException(c);
                }
                refreshBuffer(c);
            } else if(state == State.Identifier) {
                if(inIdentifierSetButNotRear(c)){
                    readBuffer.append(c);
                } else if (include(IdentifierRearSign, c)) {
                    createType = Token.Type.Identifier;
                    readBuffer.append(c);
                    state = State.Normal;
                } else {
                    createType = Token.Type.Identifier;
                    state = State.Normal;
                    moveCursor = false;
                }

            } else if(state == State.Sign) {
                if (SignParser.inCharSet(c)) {
                    readBuffer.append(c);
                } else {
                    List<String> list = SignParser.parse(readBuffer.toString());
                    for (String signStr:list) {
                        createToken(Token.Type.Sign, signStr);
                    }
                }
            } else if(state == State.Annotation) {
                if (c != '\n' & c != '\0') {
                    readBuffer.append(c);
                } else {
                    createType = Token.Type.Annotation;
                    state = State.Normal;
                    moveCursor = false;
                }
            } else if(state == State.String) {
                if (c == '\n') {
                    throw new LexicalAnalysisException(c);
                } else if (c == '\0') {
                    throw new LexicalAnalysisException(c);
                } else if (transferredMeaningSign) {
                    Character tms = StringTMMap.get(c);
                    if (tms == null) {
                        throw new LexicalAnalysisException(c);
                    }
                    readBuffer.append(tms);
                    transferredMeaningSign = false;
                } else if (c == '\\') {
                    transferredMeaningSign = false;
                } else {
                    readBuffer.append(c);
                    char firstChar = readBuffer.charAt(0);
                    if (firstChar == c) {
                        createType = Token.Type.String;
                        state = State.Normal;
                    }
                }
            } else if(state == State.RegEx) {
                if (transferredMeaningSign) {
                    if (c == '`') {
                        throw new LexicalAnalysisException(c);
                    }
                    readBuffer.append(c);
                    transferredMeaningSign = false;
                } else if (c == '\\') {
                    transferredMeaningSign = true;
                } else if (c == '\0') {
                    throw new LexicalAnalysisException(c);
                } else if (c == '`') {
                    readBuffer.append(c);
                    createType = Token.Type.RegEx;
                    state = State.Normal;
                } else {
                    readBuffer.append(c);
                }
            } else if(state == State.Space) {
                if (include(Space, c)) {
                    readBuffer.append(c);
                } else {
                    createType = Token.Type.Space;
                    state = State.Normal;
                    moveCursor = false;
                }
            }
        }

        if (createType != null) {
            createToken(createType);
        }

        return true;
    }

    private static final char[] Space = new char[] {
            '\b','\f','\r'
    };

    private boolean inIdentifierSetButNotRear(char c){
        return (c>='a' & c<='z') |
                (c>='A' & c<='Z') |
                (c>='0' & c<='9') ||
                (c  == '_');
    }

    private boolean include(char[] range,char c){
        boolean include = false;
        for (int i=0;i<range.length;i++) {
            if (range[i] == c) {
                include = true;
                break;
            }
        }

        return include;
    }
}
