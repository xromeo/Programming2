package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
The distance between two array values is the number of indices between them. Given a, find the minimum distance between any pair of equal elements in the array. If no such value exists, return -1.

Example

a = [3,2,1,2,3]

There are two matching pairs of values: 3 and 2. The indices of the 3's are i=0 and j=4, so their distance is d[i,j] = |j-i| = 4. The indices of the 2's are i=1 and j=3, so their distance is d[i,j] = |j-i| = 2. The minimum distance is 2.
*/
public class MinimumDistance2 {

    public static int minimumDistances(List<Integer> a) {

        Map<Integer, List<Integer>> valueIndexes = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            if (!valueIndexes.containsKey(a.get(i))) {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                valueIndexes.put(a.get(i), indexes);
            } else {
                List<Integer> indexes = valueIndexes.get(a.get(i));
                indexes.add(i);
            }
        }

        int min = Integer.MAX_VALUE;
        for (Entry<Integer, List<Integer>> entry : valueIndexes.entrySet()) {

            List<Integer> indexes = entry.getValue();
            if (indexes.size() % 2 == 0) {
                int m = indexes.size() / 2;
                int dif = Math.abs(indexes.get(m) - indexes.get(m - 1));
                min = Math.min(dif, min);
            } else if (indexes.size() > 1) {
                int m = indexes.size() / 2;
                int dif = Math.abs(indexes.get(m - 1) - indexes.get(m));
                min = Math.min(min, dif);
                dif = Math.abs(indexes.get(m + 1) - indexes.get(m));
                min = Math.min(min, dif);
            }
        }

        if(min == Integer.MAX_VALUE){
            return -1;
        }

        return min;

    }

    public static void main(String[] args) {

        System.out.println(minimumDistances(Arrays.asList(7,1,3,4,1,7)));
        System.out.println(minimumDistances(Arrays.asList(3,2,1,2,3)));
    }

}
