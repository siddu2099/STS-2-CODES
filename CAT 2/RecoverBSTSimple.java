import java.util.*;

public class RecoverBSTSimple {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static Node root;
    static Node first = null, second = null, prev = null;
    static Scanner sc = new Scanner(System.in);

    // 🌳 Build Tree (Level Order with -1)
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

    // 🔍 Inorder traversal to detect swapped nodes
    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);

        // 🚨 Violation detection
        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
            }
            second = root; // always update
        }

        prev = root;

        inorder(root.right);
    }

    // 🔄 Recover BST
    static void recoverTree() {
        inorder(root);

        if (first != null && second != null) {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
    }

    // 🖨 Inorder display
    static void display(Node root) {
        if (root == null) return;

        display(root.left);
        System.out.print(root.data + " ");
        display(root.right);
    }

    // 🚀 Main
    public static void main(String[] args) {

        int rootVal = sc.nextInt();  // first value
        create(rootVal);             // build tree

        recoverTree();               // fix BST

        display(root);               // print inorder (should be sorted)
    }
}