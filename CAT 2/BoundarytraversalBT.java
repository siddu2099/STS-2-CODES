import java.util.*;

public class BoundarytraversalBT {

    static class Node {
        int data;
        Node left, right;

        Node(int n) {
            data = n;
            left = right = null;
        }
    }

    static Scanner sc = new Scanner(System.in);

    // 🔹 YOUR buildTree (used here)
    static Node buildTree() {
        int val = sc.nextInt();
        if (val == -1) return null;

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

    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    static void addLeftBoundary(Node node, ArrayList<Integer> res) {
        Node curr = node.left;

        while (curr != null) {
            if (!isLeaf(curr))
                res.add(curr.data);

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    static void addRightBoundary(Node node, ArrayList<Integer> res) {
        Node curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();

        while (curr != null) {
            if (!isLeaf(curr))
                temp.add(curr.data);

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        // reverse
        for (int i = temp.size() - 1; i >= 0; i--)
            res.add(temp.get(i));
    }

    static void addLeaves(Node node, ArrayList<Integer> res) {
        if (node == null) return;

        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }

        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) return res;

        if (!isLeaf(root))
            res.add(root.data);

        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

    public static void main(String[] args) {

        Node root = buildTree();   // ✅ use this instead

        ArrayList<Integer> result = boundaryTraversal(root);

        for (int val : result)
            System.out.print(val + " ");
    }
}