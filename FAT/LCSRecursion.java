import java.util.*;

public class LCSRecursion {

    static int LCS(String a, String b, int i, int j) {
        if (i < 0 || j < 0)
            return 0;

        if (a.charAt(i) == b.charAt(j))
            return 1 + LCS(a, b, i - 1, j - 1);

        return Math.max(LCS(a, b, i - 1, j), LCS(a, b, i, j - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(LCS(s1, s2, s1.length() - 1, s2.length() - 1));
    }
}