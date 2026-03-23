import java.util.*;

public class MinStack {

    private static Stack<Integer> mainStack = new Stack<>();
    private static Stack<Integer> minStack  = new Stack<>();

    public static void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public static void pop() {
        if (mainStack.isEmpty()) return;

        int poppedValue = mainStack.pop();
        if (!minStack.isEmpty() && poppedValue == minStack.peek()) {
            minStack.pop();
        }
    }

    public static int top() {
        if (mainStack.isEmpty()) return -1;
        return mainStack.peek();
    }

    public static int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }

    // MAIN METHOD
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
        /*
         Operations:
         1 x -> push x
         2   -> pop
         3   -> getMin
         0   -> exit
        */

        int op = sc.nextInt();

        if (op == 0) {          // EXIT CONDITION
            break;
        }
        else if (op == 1) {     // push
            int x = sc.nextInt();
            push(x);
        }
        else if (op == 2) {     // pop
            pop();
        }
        else if (op == 3) {     // getMin
            System.out.println(getMin());
        }
    }

    sc.close();
}

}
