import java.util.*;

public class stackPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        System.out.println("Enter input sequence:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Enter output sequence:");
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        int j = 0;

        for (int i = 0; i < n; i++) {
            st.push(a[i]);

            while (!st.isEmpty() && j < n && st.peek() == b[j]) {
                st.pop();
                j++;
            }
        }

        if (st.isEmpty())
            System.out.println("YES");
        else
            System.out.println("NO");

        sc.close();
    }
}
