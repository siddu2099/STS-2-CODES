import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        int[][] a = new int[n][n];

        System.out.println("Enter acquaintance matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        Stack<Integer> st = new Stack<>();

        // Step 1: push all people
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        // Step 2: eliminate non-celebrities
        while (st.size() > 1) {
            int x = st.pop();
            int y = st.pop();

            if (a[x][y] == 1)
                st.push(y);
            else
                st.push(x);
        }

        // Step 3: verify candidate
        int c = st.pop();
        boolean isCelebrity = true;

        for (int i = 0; i < n; i++) {
            if (i != c && (a[c][i] == 1 || a[i][c] == 0)) {
                isCelebrity = false;
                break;
            }
        }

        // Step 4: output
        if (isCelebrity)
            System.out.println("Celebrity is: " + c);
        else
            System.out.println("No celebrity found");

        sc.close();
    }
}
