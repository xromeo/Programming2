package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * AbsolutePermutation
 */

 /*

An absolute permutation of length N is an arrangement of the integers from 1 to N such that the absolute difference between each element and its index (position in the permutation) is equal to a given positive integer, K.

In other words, for a permutation P of length N to be an absolute permutation, the condition |P[i] - i| = K must hold for all 1 <= i <= N.

For example, let's consider N = 6 and K = 2. One absolute permutation of length 6 and difference K = 2 could be [3, 4, 1, 2, 5, 6], where:

|3 - 1| = 2
|4 - 2| = 2
|1 - 3| = 2
|2 - 4| = 2
|5 - 5| = 0
|6 - 6| = 0

If k is equal to 0, then the permutation is just the sequence of natural numbers from 1 to n.

If n is not divisible by 2k, then there is no absolute permutation possible and the function returns -1.

Otherwise, we can create an absolute permutation by swapping every pair of elements in the list that are separated by a distance of exactly twice the value of k.

We start with a list of numbers from 1 to n.

We loop through the list in steps of 2k.

For each pair of elements that are separated by a distance of exactly twice the value of k, we swap them.

We return the resulting list as the absolute permutation.


  */
public class AbsolutePermutation {

    public static List<Integer> absolutePermutation(int n, int k) {
        List<Integer> result = new ArrayList<>();
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                result.add(i + 1);
            }
        } else if (n % (2 * k) != 0) {
            result.add(-1);
        } else {
            for (int i = 0; i < n; i++) {
                if (i % (2 * k) < k) {
                    result.add(i + 1 + k);
                } else {
                    result.add(i + 1 - k);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(absolutePermutation(8, 2));
        System.out.println(absolutePermutation(6, 2));
        System.out.println(absolutePermutation(12, 3));
        System.out.println(absolutePermutation(24, 3));
    }
}