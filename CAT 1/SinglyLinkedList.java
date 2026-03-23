// 1. Node Class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// 2. LinkedList Class
public class SinglyLinkedList {
    Node head;

    // --- Insertion Methods ---
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted " + data + " at beginning");
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Inserted " + data + " at end");
    }

    public void insertAfter(int prevData, int newData) {
        Node current = head;
        while (current != null && current.data != prevData) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Node " + prevData + " not found");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Inserted " + newData + " after " + prevData);
    }

    // --- Deletion Methods ---
    public void deleteFirst() {
        if (head == null) return;
        System.out.println("Deleted " + head.data + " from beginning");
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) return;
        if (head.next == null) {
            System.out.println("Deleted " + head.data + " from end");
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        System.out.println("Deleted " + current.next.data + " from end");
        current.next = null;
    }

    public void delete(int key) {
        if (head == null) return;
        if (head.data == key) {
            System.out.println("Deleted " + key);
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != key) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Deleted " + key);
        } else {
            System.out.println("Element " + key + " not found");
        }
    }

    // --- Reverse Linked List ---
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next; // save next
            current.next = prev;     // reverse link
            prev = current;          // move prev
            current = nextNode;      // move current
        }
        head = prev;
        System.out.println("Linked list reversed");
    }

    // --- Display Method ---
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Build the list
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.display(); // 10 -> 20 -> 30 -> null

        // Insert operations
        list.insertAtBeginning(5);
        list.insertAfter(20, 25);
        list.display(); // 5 -> 10 -> 20 -> 25 -> 30 -> null

        // Delete operations
        list.deleteFirst(); // removes 5
        list.deleteLast();  // removes 30
        list.delete(20);    // removes 20

        // Reverse the list
        list.reverse();

        // Final state
        System.out.print("Final ");
        list.display(); // 25 -> 10 -> null
    }
}

