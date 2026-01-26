public class Token {
    public enum Kind { NUM, PLUS, EOF }
    public final Kind kind;
    public final String text;

    public Token(Kind kind, String text) {
        this.kind = kind;
        this.text = text;
    }
}

