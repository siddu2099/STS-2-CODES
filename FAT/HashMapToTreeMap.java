package FAT;

import java.util.*;

public class HashMapToTreeMap {
    public static void main(String[] args) {
        Map<Integer, String> h = new HashMap<>();

        h.put(3, "Banana");
        h.put(1, "Apple");
        h.put(4, "Date");
        h.put(2, "Cherry");

        TreeMap<Integer, String> treeMap = new TreeMap<>(h);

        System.out.println("TreeMap (sorted by keys):");

        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}