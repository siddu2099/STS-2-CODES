import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
    }
}

class Pair {
    Node node;
    int hd;

    Pair(Node n, int h) {
        node = n;
        hd = h;
    }
}

public class Views {

    static Scanner sc = new Scanner(System.in);

    // 🔹 Simplest Level Order Build
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

    // 🔹 Left View
    static void leftView(Node root, List<Integer> res, int level) {
        if (root == null) return;

        if (level == res.size())
            res.add(root.data);

        leftView(root.left, res, level + 1);
        leftView(root.right, res, level + 1);
    }

    // 🔹 Right View
    static void rightView(Node root, List<Integer> res, int level) {
        if (root == null) return;

        if (level == res.size())
            res.add(root.data);

        rightView(root.right, res, level + 1);
        rightView(root.left, res, level + 1);
    }

    // 🔹 Top View
    static List<Integer> topView(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            map.putIfAbsent(p.hd, p.node.data);

            if (p.node.left != null)
                q.offer(new Pair(p.node.left, p.hd - 1));

            if (p.node.right != null)
                q.offer(new Pair(p.node.right, p.hd + 1));
        }

        res.addAll(map.values());
        return res;
    }

    // 🔹 Bottom View
    static List<Integer> bottomView(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            map.put(p.hd, p.node.data); // overwrite

            if (p.node.left != null)
                q.offer(new Pair(p.node.left, p.hd - 1));

            if (p.node.right != null)
                q.offer(new Pair(p.node.right, p.hd + 1));
        }

        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {

        Node root = buildTree();

        // Left View
        List<Integer> left = new ArrayList<>();
        leftView(root, left, 0);
        for (int x : left) System.out.print(x + " ");
        System.out.println();

        // Right View
        List<Integer> right = new ArrayList<>();
        rightView(root, right, 0);
        for (int x : right) System.out.print(x + " ");
        System.out.println();

        // Top View
        for (int x : topView(root)) System.out.print(x + " ");
        System.out.println();

        // Bottom View
        for (int x : bottomView(root)) System.out.print(x + " ");
    }
}