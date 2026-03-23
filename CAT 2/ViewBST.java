import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
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

public class ViewBST {

    // Insert into BST
    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    // Left View
    static void leftView(Node root, List<Integer> res, int level) {
        if (root == null) return;

        if (level == res.size())
            res.add(root.data);

        leftView(root.left, res, level + 1);
        leftView(root.right, res, level + 1);
    }

    // Right View
    static void rightView(Node root, List<Integer> res, int level) {
        if (root == null) return;

        if (level == res.size())
            res.add(root.data);

        rightView(root.right, res, level + 1);
        rightView(root.left, res, level + 1);
    }

    // Top View
    static List<Integer> topView(Node root) {
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

        return new ArrayList<>(map.values());
    }

    // Bottom View
    static List<Integer> bottomView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            map.put(p.hd, p.node.data);

            if (p.node.left != null)
                q.offer(new Pair(p.node.left, p.hd - 1));

            if (p.node.right != null)
                q.offer(new Pair(p.node.right, p.hd + 1));
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Node root = null;

        int n = sc.nextInt();   // number of nodes

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            root = insert(root, val);
        }

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

        sc.close();
    }
}