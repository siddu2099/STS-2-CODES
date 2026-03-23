import java.util.*;

public class VerticalOrderTraversalBt {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static Node root;
    static Scanner sc = new Scanner(System.in);

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

    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        Queue<Node> qNode = new LinkedList<>();
        Queue<Integer> qHd = new LinkedList<>();

        qNode.add(root);
        qHd.add(0);

        while (!qNode.isEmpty()) {

            Node curr = qNode.poll();
            int hd = qHd.poll();

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(curr.data);

            if (curr.left != null) {
                qNode.add(curr.left);
                qHd.add(hd - 1);
            }

            if (curr.right != null) {
                qNode.add(curr.right);
                qHd.add(hd + 1);
            }
        }

        for (ArrayList<Integer> list : map.values()) {
            ans.add(list);
        }

        return ans;
    }

    public static void main(String[] args) {

        int rootVal = sc.nextInt();   // first input
        create(rootVal);

        ArrayList<ArrayList<Integer>> res = verticalOrder(root);

        for (ArrayList<Integer> list : res) {
            for (int val : list)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}