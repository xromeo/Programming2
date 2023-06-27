package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * In this HackerRank Non-Divisible Subset problem you have Given a set of distinct integers, print the size of a maximal subset of S where the sum of any 2 numbers in S' is not evenly divisible by k.
 * 
 * Constraints :- 1≤ K ≤ 100 , 1 ≤S[i] ≤ 10⁹ , 1≤ n ≤ 10⁵

Example:
Given S = [ 1, 2, 3, 4, 5, 6 ] and k = 3 .

Here,we can form a maximal subset of S as S`= [ 3 , 1, 4 ]. To verify we can take all possible pairs of elements from S` and check if the sum of any two elements is evenly divisible by k=3 or not.

Here 3 + 1 = 4 which is not evenly divisible by 3. Also 3 + 4 = 7 is also not evenly divisible by 3. And another possible pair we can check is 1+4 =5 which too is not evenly divisible by 3. So it satisfies the condition !
*/

public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {

        int[] counts = new int[k];

        for (int i = 0; i < s.size(); i++) {
            int remainder = s.get(i) % k;
            counts[remainder]++;
        }

        int left = 1;
        int right = k - 1;

        int result = Math.min(1, counts[0]);
        while (left < right) {
            result = result + Math.max(counts[left], counts[right]);
            left++;
            right--;
        }
        if (left == right) {
            result += Math.min(1, counts[left]);
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(nonDivisibleSubset(6, Arrays.asList(12, 6, 1, 9, 13, 15, 10, 21, 14, 32, 5, 8, 23, 19)));
        System.out.println(nonDivisibleSubset(4, Arrays.asList(19, 10, 12, 10, 24, 25, 22)));
    }

}
