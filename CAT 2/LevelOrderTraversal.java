import java.util.*;

public class LevelOrderTraversal {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Scanner sc = new Scanner(System.in);

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

    static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                level.add(curr.val);

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = buildTree();
        List<List<Integer>> ans = levelOrder(root);

        for (List<Integer> level : ans) {
            for (int val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}