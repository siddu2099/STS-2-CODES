
import java.util.*;

public class SetExamples {
    public static void main(String[] args) {

        // ===== HashSet Example =====
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Apple");

        System.out.println("HashSet: " + hashSet);


        // ===== LinkedHashSet Example =====
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("Apple");
        linkedSet.add(null);
        linkedSet.add(null);

        System.out.println("LinkedHashSet: " + linkedSet);


        // ===== TreeSet Example =====
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);

        System.out.println("TreeSet (Sorted Order): " + treeSet);
    }
}