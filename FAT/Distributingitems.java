import java.util.*;

public class Distributingitems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] st = sc.nextLine().split(" ");
        int k = sc.nextInt();

        Map<Integer, Integer> freq = new HashMap<>();

        for (String s : st) {
            int type = Integer.parseInt(s);
            freq.put(type, freq.getOrDefault(type, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count > 2 * k) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}