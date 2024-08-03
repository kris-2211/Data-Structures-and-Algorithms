import java.util.ArrayList;

class Graph {
    ArrayList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int n) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int x, int y) {
        adj[x].add(y);
        adj[y].add(x);
    }
}

public class Graphs {
    public static void main(String[] args) {

    }
}
