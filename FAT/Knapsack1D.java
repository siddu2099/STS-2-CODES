import java.util.*;

public class Knapsack1D {

    static int knapsack(int[] wt, int[] val, int W) {
        int[] dp = new int[W + 1];

        for (int i = 0; i < wt.length; i++) {
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }

        return dp[W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();          // number of items
        int[] wt = new int[n];
        int[] val = new int[n];

        // input weights
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        // input values
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        int W = sc.nextInt();          // capacity

        int result = knapsack(wt, val, W);
        System.out.println(result);

        sc.close();
    }
}