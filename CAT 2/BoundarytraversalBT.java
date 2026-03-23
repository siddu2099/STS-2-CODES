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

    static Node root;
    static Scanner sc = new Scanner(System.in);

    // Build Tree (Level Order)
    static void create(int val) {

        if (val == -1) return;

        Queue<Node> q = new LinkedList<>();
        root = new Node(val);
        q.offer(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (!sc.hasNextInt()) break;
            int v = sc.nextInt();
            if (v != -1) {
                temp.left = new Node(v);
                q.offer(temp.left);
            }

            if (!sc.hasNextInt()) break;
            v = sc.nextInt();
            if (v != -1) {
                temp.right = new Node(v);
                q.offer(temp.right);
            }
        }
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

        int rootVal = sc.nextInt();   // first value
        create(rootVal);              // build tree

        ArrayList<Integer> result = boundaryTraversal(root);

        for (int val : result)
            System.out.print(val + " ");
    }
}