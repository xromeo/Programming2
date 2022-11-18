/*
 * Given an m x n matrix, return all elements of the matrix in spiral order.

 Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

 */

package medium;

import java.util.ArrayList;
import java.util.List;

import commons.Array;

public class SpiralTraverse {

    List<Integer> spiralTraverse(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        int startRow = 0;
        int endRow = n - 1;
        int startColumn = 0;
        int endColumn = m - 1;

        while (startRow <= endRow && startColumn <= endColumn) {
            for (int j = startColumn; j <= endColumn; j++) {
                result.add(matrix[startRow][j]);
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(matrix[i][endColumn]);
            }
            if (startRow < endRow && startColumn < endColumn) {
                for (int j = endColumn - 1; j >= startColumn; j--) {
                    result.add(matrix[endRow][j]);
                }
                for (int i = endRow - 1; i > startRow; i--) {
                    result.add(matrix[i][startColumn]);
                }
            }
            startRow++;
            endRow--;
            startColumn++;
            endColumn--;
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = { { 1, 2, 3, 4 }, { 10, 11, 12, 5 }, { 9, 8, 7, 6 } };

        var result = new SpiralTraverse().spiralTraverse(matrix);
        new Array().print(result);

    }
}
