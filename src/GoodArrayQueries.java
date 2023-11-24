import java.util.*;

/*
 * 
 For a number N a goodArray is the smallest possible array that consists of only power of two 
(2⁰,2¹ ... 2^k) such that the sum of all the numbers in the array is equal to N
For each query that consists of three l, r, and m, find out the product of elements goodArray[l] through goodArray[r] modulo m when goodArray is sorted in non-decreasing order
Example N=26, queries = [[1,2,1009],[3, 3, 5]] 
goodArray when is sorted is [2,8,16].

For query l = 1, r= 2, m =1009, ans = goodArray[1] * goodArray[2] = (2*8) modulo 1009 = 16.
the answer is [16]
please solve in Java with the best time and space complexity
 */

public class GoodArrayQueries {

    public static int[] solveQueries(int N, int[][] queries) {
        // Find the set bits in binary representation of N
        List<Integer> setBits = new ArrayList<>();
        int index = 0;
        while (N > 0) {
            if ((N & 1) == 1) {
                setBits.add(index);
            }
            N >>= 1;
            index++;
        }

        // Create a sorted list of goodArray
        List<Long> goodArray = new ArrayList<>();
        for (int bit : setBits) {
            goodArray.add((long) Math.pow(2, bit));
        }
        Collections.sort(goodArray);

        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0] - 1; // Adjust for 0-based indexing
            int r = queries[i][1] - 1; // Adjust for 0-based indexing
            int m = queries[i][2];
            
            long product = 1;
            for (int j = l; j <= r; j++) {
                product = (product * goodArray.get(j)) % m;
            }
            results[i] = (int) product;
        }
        return results;
    }

    public static void main(String[] args) {
        int N = 26;
        int[][] queries = {{1, 2, 1009}, {3, 3, 5}};
        int[] results = solveQueries(N, queries);

        for (int result : results) {
            System.out.println(result);
        }
    }
}
