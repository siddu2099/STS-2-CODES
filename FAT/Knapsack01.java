import java.util.*;

public class Knapsack01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] profit = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++)
            profit[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            weight[i] = sc.nextInt();

        int capacity = sc.nextInt();

        System.out.println(knapsack(n, profit, weight, capacity));
    }

    static int knapsack(int n, int p[], int w[], int cap) {

        int dp[][] = new int[n + 1][cap + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= cap; j++) {

                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }

                else if (w[i - 1] <= j) {
                    int take = p[i - 1] + dp[i - 1][j - w[i - 1]];
                    int notTake = dp[i - 1][j];

                    dp[i][j] = Math.max(take, notTake);
                }

                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][cap];
    }
}