package medium;

import java.util.Arrays;
import java.util.List;

/**
 * KadanesAlgorithm
 * 
 * Largest Sum Contiguous Subarray (Kadane’s Algorithm)
 * 
 * Given an array arr[] of size N. The task is to find the sum of the contiguous
 * subarray within a arr[] with the largest sum.
 * 
 * kadane-algorithm
 * 
 * The idea of Kadane’s algorithm is to maintain a variable max_ending_here that
 * stores the maximum sum contiguous subarray ending at current index and a
 * variable max_so_far stores the maximum sum of contiguous subarray found so
 * far, Everytime there is a positive-sum value in max_ending_here compare it
 * with max_so_far and update max_so_far if it is greater than max_so_far.
 */

/*
 *  [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
 *   3, 8, -1, 1, 4, 2, 5, 9, 16, 18, 9,15,18, 19,14,18  <- maxEndingHere
 *   3  8   8  8  8  8  8  9  16  18 18 18 18  19 19 19  <- maxSofar
 */

public class KadanesAlgorithm {

    public static int largestSumContiguousSubarray(List<Integer> array) {

        int maxEndingHere = array.get(0);
        int maxSofar = array.get(0);

        for (int i = 1; i < array.size(); i++) {
            Integer num = array.get(i);
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSofar = Math.max(maxSofar, maxEndingHere);
        }

        return maxSofar;
    }

    public static void main(String[] args) {
        System.out.println(
                largestSumContiguousSubarray(Arrays.asList(3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4)));
    }
}