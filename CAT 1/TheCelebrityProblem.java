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

        List<Integer> celebrities = new ArrayList<>();

        // Check each person
        for (int c = 0; c < n; c++) {
            boolean isCelebrity = true;

            for (int i = 0; i < n; i++) {
                if (i != c && (a[c][i] == 1 || a[i][c] == 0)) {
                    isCelebrity = false;
                    break;
                }
            }

            if (isCelebrity) {
                celebrities.add(c);
            }
        }

        // Output
        if (celebrities.isEmpty()) {
            System.out.println("No celebrity found");
        } else {
            System.out.println("Celebrities are: " + celebrities);
        }

        sc.close();
    }
}