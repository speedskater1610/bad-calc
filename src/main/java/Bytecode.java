public class Bytecode {
    public enum Op {
        PUSH_NUM,
        BF,      // ()
        HEAP,    // []
        XFER     // {}
    }

    public final Op op;
    public final int arg;

    public Bytecode(Op op, int arg) {
        this.op = op;
        this.arg = arg;
    }
}

