package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given an array of integers, where all elements but one occur twice, find the unique element.

Example
a = [1,2,3,4,3,2,1]
The unique element is 4.
 */

public class LonelyInteger {

    public static int lonelyinteger(List<Integer> a) {

        Set<Integer> frequency = new HashSet<>();

        a.forEach(value -> {
            if (frequency.contains(value)) {
                frequency.remove(value);
            } else {
                frequency.add(value);
            }
        });

        
        return frequency.iterator().next();
    }

    public static void main(String[] args) {

        System.out.println(lonelyinteger(Arrays.asList(1,2,3,4,3,2,1)));
    }
}
