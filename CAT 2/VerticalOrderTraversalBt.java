import java.util.*;

public class VerticalOrderTraversalBt {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
        }
    }

    static class Pair {
        Node node;
        int hd;

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    static Scanner sc = new Scanner(System.in);

    // 🔹 Your Level Order Build (used as-is)
    static Node buildTree() {
        int val = sc.nextInt();
        Node root = new Node(val);

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            int l = sc.nextInt();
            if (l != -1) {
                temp.left = new Node(l);
                q.offer(temp.left);
            }

            int r = sc.nextInt();
            if (r != -1) {
                temp.right = new Node(r);
                q.offer(temp.right);
            }
        }

        return root;
    }

    // 🔹 Vertical Order Traversal
    static List<List<Integer>> verticalOrder(Node root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            map.putIfAbsent(p.hd, new ArrayList<>());
            map.get(p.hd).add(p.node.data);

            if (p.node.left != null)
                q.offer(new Pair(p.node.left, p.hd - 1));

            if (p.node.right != null)
                q.offer(new Pair(p.node.right, p.hd + 1));
        }

        ans.addAll(map.values());
        return ans;
    }

    public static void main(String[] args) {

        Node root = buildTree();

        List<List<Integer>> res = verticalOrder(root);

        for (List<Integer> list : res) {
            for (int val : list)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}