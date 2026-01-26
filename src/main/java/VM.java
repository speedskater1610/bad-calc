import java.util.List;

public class VM {
    private final HeapTable heap = new HeapTable();
    private final BrainfuckStack stack = new BrainfuckStack();

    // Run returns the final stack value
    public int run(List<Bytecode> code, int ip) {
        if (ip >= code.size()) return stack.read();

        Bytecode bc = code.get(ip);
        switch (bc.op) {
            case BF:
                stack.run("+++++", 0);
                break;
            case HEAP:
                heap.insert(0, stack.read());
                break;
            case XFER:
                heap.insert(1, heap.select(0));
                break;
        }
        return run(code, ip + 1);
    }
}

