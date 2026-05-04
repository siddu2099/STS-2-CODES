//brute force

// import java.util.*;

// class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number of people: ");
//         int n = sc.nextInt();

//         int[][] a = new int[n][n];

//         System.out.println("Enter acquaintance matrix:");
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 a[i][j] = sc.nextInt();
//             }
//         }

//         List<Integer> celebrities = new ArrayList<>();

//         // Check each person
//         for (int c = 0; c < n; c++) {
//             boolean isCelebrity = true;

//             for (int i = 0; i < n; i++) {
//                 if (i != c && (a[c][i] == 1 || a[i][c] == 0)) {
//                     isCelebrity = false;
//                     break;
//                 }
//             }

//             if (isCelebrity) {
//                 celebrities.add(c);
//             }
//         }

//         // Output
//         if (celebrities.isEmpty()) {
//             System.out.println("No celebrity found");
//         } else {
//             System.out.println("Celebrities are: " + celebrities);
//         }

//         sc.close();
//     }
// }



//stack approach
import java.util.*;

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
            int a1 = st.pop();
            int a2 = st.pop();

            if (a[a1][a2] == 1) {
                // a1 knows a2 → a1 is not celebrity
                st.push(a2);
            } else {
                // a1 does not know a2 → a2 is not celebrity
                st.push(a1);
            }
        }

        // Step 3: potential candidate
        int candidate = st.pop();

        // Step 4: verify candidate
        boolean isCelebrity = true;

        for (int i = 0; i < n; i++) {
            if (i != candidate &&
               (a[candidate][i] == 1 || a[i][candidate] == 0)) {
                isCelebrity = false;
                break;
            }
        }

        // Output
        if (isCelebrity) {
            System.out.println("Celebrity is: " + candidate);
        } else {
            System.out.println("No celebrity found");
        }

        sc.close();
    }
}