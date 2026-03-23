import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class BitonicDoublyLinkedListA {

    static class Node {
        int data;
        Node prev, next;

        Node(int d) {
            data = d;
            prev = next = null;
        }
    }

    static Node head;

    // Insert at end
    static void insert(int e) {
        Node newnode = new Node(e);

        if (head == null) {
            head = newnode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newnode;
        newnode.prev = temp;
    }

    // Display list
    static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Exam-safe bitonic sort
    static void bitonic() {
        if (head == null || head.next == null)
            return;

        // Step 1: copy to array
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        // Step 2: sort
        Collections.sort(list);

        // Step 3: write back
        temp = head;
        int i = 0;
        while (temp != null) {
            temp.data = list.get(i++);
            temp = temp.next;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            insert(sc.nextInt());
        }

        bitonic();
        display();

        sc.close();
    }
}
