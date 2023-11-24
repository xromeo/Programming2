package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.

Example

arr = [1,3,5,7,9]

The minimum sum is 1 + 3 + 5 + 7 = 16  and the maximum sum is 3 + 5 + 7 + 9 = 24. The function prints

16 24
 */
public class MinMax {

    public static void miniMaxSum(List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());

        long min = 0;
        long max = 0;
        for (int i = 0; i < 5; i++) {
            if (i != 0) {
                max += arr.get(i);
            }
            if (i != 4) {
                min += arr.get(i);
            }
        }

        System.out.println(min + " " + max);
    }

    public static void main(String[] args) {
        miniMaxSum(Arrays.asList(1, 3, 5, 7, 9));
        miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));
    }
}
