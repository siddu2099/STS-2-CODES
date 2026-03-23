import java.util.Scanner;

public class PriorityQueueUsingDoublyLinkedList {

    // Node class
    static class Node {
        int data;
        int priority;
        Node next, prev;

        Node(int data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private static Node head = null;

    // Insert based on priority (higher value = higher priority)
    public static void push(int data, int priority) {
        Node newNode = new Node(data, priority);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp != null && temp.priority >= priority) {
            temp = temp.next;
        }

        // Insert at beginning
        if (temp == head) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        // Insert at end
        else if (temp == null) {
            Node last = head;
            while (last.next != null)
                last = last.next;

            last.next = newNode;
            newNode.prev = last;
        }
        // Insert in middle
        else {
            newNode.next = temp;
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.prev = newNode;
        }
    }

    // Peek highest priority element
    public static int peek() {
        if (head != null)
            return head.data;
        return -1;
    }

    // Remove highest priority element
    public static int pop() {
        if (head != null) {
            int val = head.data;
            head = head.next;
            if (head != null)
                head.prev = null;
            return val;
        }
        return -1;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter data and priority:");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            int priority = sc.nextInt();
            push(data, priority);
        }

        System.out.println("Highest priority element (peek): " + peek());

        System.out.print("Enter number of deletions: ");
        int d = sc.nextInt();

        for (int i = 0; i < d; i++) {
            System.out.println("Popped element: " + pop());
        }

        System.out.println("New highest priority element (peek): " + peek());

        sc.close();
    }
}
