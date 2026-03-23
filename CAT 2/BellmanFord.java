import java.util.*;

public class BellmanFord {

    // Edge class
    static class E {
        int u, v, w;

        E(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    // Bellman-Ford function
    static void bf(int n, ArrayList<E> edges, int src) {

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax edges (n-1 times)
        for (int i = 1; i < n; i++) {

            boolean updated = false; // optimization

            for (E e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE &&
                    dist[e.u] + e.w < dist[e.v]) {

                    dist[e.v] = dist[e.u] + e.w;
                    updated = true;
                }
            }

            // Stop early if no update
            if (!updated) break;
        }

        // Check for negative cycle
        for (E e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE &&
                dist[e.u] + e.w < dist[e.v]) {

                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }

        // Print distances
        System.out.println("\nShortest distances from source:");
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("Vertex " + i + " -> INF");
            else
                System.out.println("Vertex " + i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        ArrayList<E> edges = new ArrayList<>();

        System.out.println("Enter edges (u v w):");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new E(u, v, w));
        }

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        bf(n, edges, src);

        sc.close();
    }
}