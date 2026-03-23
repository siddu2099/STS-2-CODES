import java.util.*;

public class SegregateList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    // Even-Odd Segregation
    public void segregateEvenOdd() {
        if (head == null || head.next == null) return;

        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;

        Node current = head;

        while (current != null) {
            if (current.data % 2 == 0) {   // EVEN
                if (evenStart == null) {
                    evenStart = current;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else {                       // ODD
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }

        // Merge
        if (evenStart == null) {
            head = oddStart;
        } else {
            head = evenStart;
            evenEnd.next = oddStart;
        }

        if (oddEnd != null)
            oddEnd.next = null;
    }

    // Display
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // MAIN METHOD with Scanner
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SegregateList list = new SegregateList();
        
        System.out.print("Enter number of nodes: ");

        int n = sc.nextInt();   // number of nodes

        System.out.println("Enter node values:");

        for (int i = 0; i < n; i++) {
            list.insert(sc.nextInt());
        }

        list.segregateEvenOdd();
        list.display();

        sc.close();
    }
}
