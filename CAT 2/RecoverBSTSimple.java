import java.util.*;

public class RecoverBSTSimple {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
        }
    }

    static Node root;
    static Node first = null, second = null, prev = null;
    static Scanner sc = new Scanner(System.in);

    // 🌳 Build Tree (Level Order with -1)
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
    static void recoverTree(Node root) {
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

        root = buildTree();   // ✅ use new function

        recoverTree(root);    // fix BST

        display(root);        // inorder (sorted output)
    }
}