import java.util.Scanner;

// Sort the BitonicDoublyLinkedList
public class BitonicDoublyLinkedList {

    static class Node {
        int data;
        Node prev, next;

        Node(int d) {
            data = d;
            prev = next = null;
        }
    }

    static Node head;

    static void insert(int e) {
        Node newnode = new Node(e);
        if (head == null) {
            head = newnode;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newnode;
        newnode.prev = temp;
    }

    static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Sort bitonic DLL (exam-safe version)
    static void bitonic() {
        if (head == null || head.next == null)
            return;

        Node front = head;
        Node last = head;

        while (last.next != null)
            last = last.next;

        Node result = null, tail = null;

        while (front != null && last != null && front != last && front.prev != last) {
            Node newnode;
            if (front.data <= last.data) {
                newnode = new Node(front.data);
                front = front.next;
            } else {
                newnode = new Node(last.data);
                last = last.prev;
            }

            if (result == null) {
                result = tail = newnode;
            } else {
                tail.next = newnode;
                newnode.prev = tail;
                tail = newnode;
            }
        }

        while (front != null && front != last.next) {
            Node newnode = new Node(front.data);
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
            front = front.next;
        }

        head = result;
    }

    // MAIN with Scanner
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
