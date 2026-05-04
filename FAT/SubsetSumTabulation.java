import java.util.*;

public class SubsetSumTabulation {

    static boolean subsetSum(int[] arr, int sum) {
        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        if (subsetSum(arr, sum))
            System.out.println("yes");
        else
            System.out.println("no");
    }
}

// n = 5
// arr = [2, 3, 7, 8, 10]
// sum = 11