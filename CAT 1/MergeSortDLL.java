import java.util.*;

public class MergeSortDLL {

    // Node structure
    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    // Insert at end
    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Merge Sort
    Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node second = split(head);

        head = mergeSort(head);
        second = mergeSort(second);

        return merge(head, second);
    }

    // Split DLL into two halves
    Node split(Node head) {
        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = slow.next;
        slow.next = null;

        if (second != null)
            second.prev = null;

        return second;
    }

    // ✅ YOUR RECURSIVE MERGE (UNCHANGED LOGIC)
    static Node merge(Node first, Node second) {
        if (first == null)
            return second;
        if (second == null)
            return first;

        if (first.data <= second.data) {
            first.next = merge(first.next, second);
            if (first.next != null)
                first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            if (second.next != null)
                second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    // Display
    void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // MAIN METHOD (Scanner)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeSortDLL list = new MergeSortDLL();

        int n = sc.nextInt();     // number of nodes
        for (int i = 0; i < n; i++) {
            list.insert(sc.nextInt());
        }

        list.head = list.mergeSort(list.head);
        list.display(list.head);

        sc.close();
    }
}
