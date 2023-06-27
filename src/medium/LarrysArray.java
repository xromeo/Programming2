package medium;

import java.util.Arrays;
import java.util.List;

/*
 * Larry's array is a problem on HackerRank that asks you to determine whether an array of numbers can be sorted using the following operation any number of times: Choose any consecutive indices and rotate their elements in such a way that ABC -> BCA -> CAB -> ABC.

The solution to this problem is to count the number of inversions in the array. An inversion is a pair of elements in the array where the first element is greater than the second element. If the number of inversions is even, then the array can be sorted using rotations. If the number of inversions is odd, then the array cannot be sorted using rotations.
 */
public class LarrysArray {
    public static String larrysArray(List<Integer> A) {

        int n = A.size();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A.get(i) > A.get(j)) {
                    count++;
                }
            }
        }
        System.out.println(count);
        if (count % 2 == 0) {
            return "YES";
        }
        return "NO";

    }

    public static void main(String[] args) {
        List<Integer> case1 = Arrays.asList(1, 6, 5, 2, 4, 3);
        System.out.println(larrysArray(case1));
        List<Integer> case2 = Arrays.asList(3, 1, 2);
        System.out.println(larrysArray(case2));
        List<Integer> case3 = Arrays.asList(1,2,3, 5,4);
        System.out.println(larrysArray(case3));
    }
}
