public class BrainfuckStack {
    private final int[] tape = new int[30000];
    private int ptr = 0;

    public void run(String code, int i) {
        if (i >= code.length()) return;

        switch (code.charAt(i)) {
            case '>': ptr++; break;
            case '<': ptr--; break;
            case '+': tape[ptr]++; break;
            case '-': tape[ptr]--; break;
        }
        run(code, i + 1);
    }

    public int read() {
        return tape[ptr];
    }
}

