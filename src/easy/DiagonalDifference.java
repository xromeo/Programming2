package easy;

import java.util.Arrays;
import java.util.List;

/*
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix arr is shown below:

1 2 3
4 5 6
9 8 9  
The left-to-right diagonal = 1 + 5 + 9 = 15. The right to left diagonal = 3 + 5 + 9 = 17. Their absolute difference is |15 - 17| = 2.

Function description

Complete the diagonalDifference function in the editor below.

diagonalDifference takes the following parameter:

int arr[n][m]: an array of integers
Return

int: the absolute diagonal difference
 * 
 */
public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < n; i++) {
            sumLeft += arr.get(i).get(i);
            sumRight += arr.get(i).get(n - i - 1);
        }

        return Math.abs(sumRight - sumLeft);

    }

    public static void main(String[] args) {
        System.out.println(diagonalDifference(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(9, 9, 9))));

    }
}
