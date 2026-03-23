import java.util.Scanner;

public class RecursiveHanoi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        // A = Source, B = Auxiliary, C = Destination
        solve(n, 'A', 'B', 'C');

        sc.close();
    }

    // Recursive function to solve Tower of Hanoi
    public static void solve(int n, char src, char aux, char dest) {

        // Base case
        if (n == 1) {
            System.out.println("Move disk 1 from " + src + " to " + dest);
            return;
        }

        // Move n-1 disks from source to auxiliary
        solve(n - 1, src, dest, aux);

        // Move nth disk from source to destination
        System.out.println("Move disk " + n + " from " + src + " to " + dest);

        // Move n-1 disks from auxiliary to destination
        solve(n - 1, aux, src, dest);
    }
}
