import java.util.*;

public class TopologicalSort {

    static int nVertices, nEdges;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        nVertices = sc.nextInt();
        nEdges = sc.nextInt();

        graph = new ArrayList<>();
        visited = new boolean[nVertices];

        // Initialize adjacency list
        for (int i = 0; i < nVertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Directed graph
        for (int i = 0; i < nEdges; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph.get(src).add(dest);
        }

        // Topological sort
        for (int i = 0; i < nVertices; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        // Print result
        System.out.println("Topological Sort:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        sc.close();
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }

        stack.push(node);


    }
    
}