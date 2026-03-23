import java.util.*;

public class QueueSort {

    // Method to sort the queue
    static void sortQueue(Queue<Integer> q) {
        int n = q.size();

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            // Find minimum element index in unsorted part
            for (int j = 0; j < n; j++) {
                int x = q.poll();

                if (x < min && j < n - i) {
                    min = x;
                    minIndex = j;
                }
                q.add(x);
            }

            // Remove the minimum element
            for (int j = 0; j < n; j++) {
                int x = q.poll();
                if (j != minIndex)
                    q.add(x);
            }

            // Insert minimum at rear
            q.add(min);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter queue elements:");
        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }

        sortQueue(q);

        System.out.println("Sorted Queue:");
        System.out.println(q);

        sc.close();
    }
}
