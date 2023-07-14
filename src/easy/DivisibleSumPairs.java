package easy;

import java.util.Arrays;
import java.util.List;

public class DivisibleSumPairs {

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {

        int[] frequency = new int[k]; // Array to store the frequency of remainders

        int count = 0; // Variable to count the number of valid pairs

        // Count the frequency of remainders when each element is divided by k
        for (int i = 0; i < n; i++) {
            int remainder = ar.get(i) % k;
            count += frequency[(k - remainder) % k]; // Count pairs with complement remainder
            frequency[remainder]++;
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(divisibleSumPairs(5, 3, Arrays.asList(9, 3, 2, 6, 1)));

        System.out.println(divisibleSumPairs(6, 5, Arrays.asList(1, 2, 3, 4, 5, 6)));
        System.out.println(divisibleSumPairs(6, 3, Arrays.asList(1, 3, 2, 6, 1, 2)));

    }
}
