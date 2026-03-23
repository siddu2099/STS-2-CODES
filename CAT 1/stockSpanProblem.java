import java.util.*;

public class stockSpanProblem {

    static void stockspan(int n, int a[], int s[]) {
        Stack<Integer> st = new Stack<>();

        // First day
        st.push(0);
        s[0] = 1;

        // Remaining days
        for (int i = 1; i < n; i++) {

            // Remove smaller or equal prices
            while (!st.isEmpty() && a[st.peek()] <= a[i]) {
                st.pop();
            }

            // Calculate span
            if (st.isEmpty())
                s[i] = i + 1;
            else
                s[i] = i - st.peek();

            // Push current index
            st.push(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] s = new int[n];
        stockspan(n, a, s);

        System.out.print("Stock Span: ");
        for (int i = 0; i < n; i++) {
            System.out.print(s[i] + " ");
        }

        sc.close();
    }
}
