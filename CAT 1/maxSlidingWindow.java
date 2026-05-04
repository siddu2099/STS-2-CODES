import java.util.*;

public class maxSlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input window size
        System.out.print("Enter window size (k): ");
        int k = sc.nextInt();

        // Edge case without return
        if (nums == null || nums.length == 0 || k <= 0 || k > n) {
            System.out.println("[]");
        } else {

            int[] result = new int[n - k + 1];
            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {

                // 1. Remove indices outside window
                if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                    dq.pollFirst();
                }

                // 2. Remove smaller elements
                while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                    dq.pollLast();
                }

                // 3. Add current index
                dq.offerLast(i);

                // 4. Store result
                if (i >= k - 1) {
                    result[i - k + 1] = nums[dq.peekFirst()];
                }
            }

            // Output
            System.out.println("Sliding Window Maximums: " + Arrays.toString(result));
        }

        sc.close();
    }
}