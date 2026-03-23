import java.util.*;

public class HeapSortPQ {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        // input
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Max Heap (just for demonstration)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : list) {
            pq.add(x);
        }

        // Move back to list
        list.clear();
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }

        // Now sort using Collections.sort (descending)
        Collections.sort(list, Collections.reverseOrder());

        // output
        for (int x : list) {
            System.out.print(x + " ");
        }
                sc.close();

    }
}