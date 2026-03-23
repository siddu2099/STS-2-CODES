import java.util.*;

class BFS_Node {

    static ArrayList<ArrayList<Integer>> g; 
    static boolean[] vis;
    static int v,e;

    static void add(int a, int b) {
        g.get(a).add(b);
        g.get(b).add(a);
    }

    static void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();

        vis[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");

            for (int y : g.get(x)) {
                if (!vis[y]) {
                    vis[y] = true;
                    q.add(y);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();

        g = new ArrayList<>();
        vis = new boolean[v];

        // initialize graph
        for (int i = 0; i < v; i++) {
            g.add(new ArrayList<>());
        }

        e = sc.nextInt();

        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            add(x, y);
        }

        int s = sc.nextInt();
        bfs(s);

        sc.close();
    }
}