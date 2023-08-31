package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MigratorBirds {

    public static int migratoryBirds(List<Integer> arr) {

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            int key = arr.get(i);
            if (!frequencies.containsKey(key)) {
                frequencies.put(key, 1);
            } else {
                int value = frequencies.get(key);
                frequencies.put(key, value + 1);
            }
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                min = entry.getKey();
            }
            if (entry.getValue() == max) {
                min = Math.min(min, entry.getKey());
            }
        }

        return min;

    }

    public static void main(String[] args) {

        System.out.println(migratoryBirds(List.of(1, 4, 4, 4, 5, 3)));
        System.out.println(migratoryBirds(List.of(1, 1, 2, 2, 3)));
        System.out.println(migratoryBirds(List.of(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
    }
}
