import java.util.*;

public class LCSMemoization {

    static int LCS(String a, String b, int i, int j, int dp[][]) {
        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (a.charAt(i) == b.charAt(j))
            return dp[i][j] = 1 + LCS(a, b, i - 1, j - 1, dp);

        return dp[i][j] = Math.max(
                LCS(a, b, i - 1, j, dp),
                LCS(a, b, i, j - 1, dp)
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        int dp[][] = new int[s1.length()][s2.length()];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        System.out.println(LCS(s1, s2, s1.length() - 1, s2.length() - 1, dp));
    }
}