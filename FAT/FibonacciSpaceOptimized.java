import java.util.*;

public class FibonacciSpaceOptimized {

    static int fib(int n) {
        if (n <= 1)
            return n;

        int prev1 = 0;
        int prev2 = 1;
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(fib(n));
    }
}