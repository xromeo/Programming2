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
public class MinimumDistance {

    public static int minimumDistances(List<Integer> a) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < a.size(); i++) {
            int element = a.get(i);
            if (indexMap.containsKey(element)) {
                int prevIndex = indexMap.get(element);
                int distance = i - prevIndex;
                minDistance = Math.min(minDistance, distance);
            }
            indexMap.put(element, i);                                                                                                      
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public static void main(String[] args) {

        System.out.println(minimumDistances(Arrays.asList(7,1,3,4,1,7)));
        System.out.println(minimumDistances(Arrays.asList(3,2,1,2,3)));
    }

}
