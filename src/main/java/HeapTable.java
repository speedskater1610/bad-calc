import java.util.HashMap;

public class HeapTable {
    private final HashMap<Integer, Integer> table = new HashMap<>();

    public void insert(int k, int v) {
        table.put(k, v);
    }

    public int select(int k) {
        return table.getOrDefault(k, 0);
    }
}

