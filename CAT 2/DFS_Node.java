import java.util.*;

public class DFS_Node {

    static int v, e;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    // add edge function
    static void add(int u, int w) {
        graph.get(u).add(w);
        graph.get(w).add(u); // undirected graph
    }

    // DFS function
    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt(); // vertices
        e = sc.nextInt(); // edges

        graph = new ArrayList<>();
        visited = new boolean[v];

        // initialize graph
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        // input edges using add function
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            add(u, w);
        }

        int start = sc.nextInt();

        System.out.println("DFS Traversal:");
        dfs(start);

        sc.close();
    }
}