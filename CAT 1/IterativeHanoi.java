import java.util.Scanner;
import java.util.Stack;

public class IterativeHanoi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        // Create stacks for rods
        Stack<Integer> src = new Stack<>();
        Stack<Integer> aux = new Stack<>();
        Stack<Integer> dest = new Stack<>();

        // Push disks into source rod (largest at bottom)
        for (int i = n; i >= 1; i--) {
            src.push(i);
        }

        int totalMoves = (int) Math.pow(2, n) - 1;

        // If number of disks is even, swap destination and auxiliary
        if (n % 2 == 0) {
            Stack<Integer> temp = dest;
            dest = aux;
            aux = temp;
        }

        // Perform moves
        for (int i = 1; i <= totalMoves; i++) {
            if (i % 3 == 1)
                moveDisk(src, dest, 'A', 'C');
            else if (i % 3 == 2)
                moveDisk(src, aux, 'A', 'B');
            else
                moveDisk(aux, dest, 'B', 'C');
        }

        sc.close();
    }

    // Helper function to move disk between two rods
    public static void moveDisk(Stack<Integer> from, Stack<Integer> to,
                                char fromRod, char toRod) {

        if (from.isEmpty()) {
            from.push(to.pop());
            System.out.println("Move disk " + from.peek() +
                               " from " + toRod + " to " + fromRod);
        }
        else if (to.isEmpty()) {
            to.push(from.pop());
            System.out.println("Move disk " + to.peek() +
                               " from " + fromRod + " to " + toRod);
        }
        else if (from.peek() < to.peek()) {
            to.push(from.pop());
            System.out.println("Move disk " + to.peek() +
                               " from " + fromRod + " to " + toRod);
        }
        else {
            from.push(to.pop());
            System.out.println("Move disk " + from.peek() +
                               " from " + toRod + " to " + fromRod);
        }
    }
}
