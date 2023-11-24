package medium;

import java.util.Arrays;
import java.util.Stack;

/*
Remove-Islands
Medium Google Coding - Remove Islands

Description
Given a matrix n*n:

1 -> black color

0 -> white color

Removing all black pixels that are not connected with the black-pixel in the border

Input
Input is a

E.g.

  matrix = [
     [1, 0, 0, 0, 0, 0],
     [0, 1, 0, 1, 1, 1],
     [0, 0, 1, 0, 1, 0],
     [1, 1, 0, 0, 1, 0],
     [1, 0, 1, 1, 0, 0],
     [1, 0, 0, 0, 0, 1],
 ]
Output
  matrix = [
     [1, 0, 0, 0, 0, 0],
     [0, 0, 0, 1, 1, 1],
     [0, 0, 0, 0, 1, 0],
     [1, 1, 0, 0, 1, 0],
     [1, 0, 0, 0, 0, 0],
     [1, 0, 0, 0, 0, 1],
 ]
 */
public class RemoveIslands {

    public static void removeIslands(int[][] matrix) {
        boolean[][] marked = new boolean[matrix.length][matrix[0].length];

        int n = matrix.length;
        int m = matrix[0].length;
        for (int j = 0; j < m; j++) {
            if (!marked[0][j] && matrix[0][j] == 1) {
                markIslandWithBorder(0, j, matrix, marked);
            }
        }

        for (int j = 0; j < m; j++) {
            if (!marked[n - 1][j] && matrix[n - 1][j] == 1) {
                markIslandWithBorder(n - 1, j, matrix, marked);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!marked[i][0] && matrix[i][0] == 1) {
                markIslandWithBorder(i, 0, matrix, marked);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!marked[i][m - 1] && matrix[i][m - 1] == 1) {
                markIslandWithBorder(i, m - 1, matrix, marked);
            }
        }

        System.out.println(Arrays.deepToString(marked));

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (matrix[i][j] == 1 && !marked[i][j]) {
                    matrix[i][j] = 0;
                }
            }

        }

    }

    private static void markIslandWithBorder(int i, int j, int[][] matrix, boolean[][] marked) {
        int n = matrix.length;
        int m = matrix[0].length;
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[] { i, j });
        while (!stack.isEmpty()) {
            Integer[] current = stack.pop();
            i = current[0];
            j = current[1];

            if (i < 0 || i >= n || j < 0 || j >= m || marked[i][j] || matrix[i][j] == 0) {
                continue;
            }

            marked[i][j] = true;

            int[][] neighbors = {
                    { i - 1, j },
                    { i + 1, j },
                    { i, j - 1 },
                    { i, j + 1 },
            };
            for (int[] neighbor : neighbors) {
                stack.push(new Integer[] { neighbor[0], neighbor[1] });
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 1, 1 },
                { 0, 0, 1, 0, 1, 0 },
                { 1, 1, 0, 0, 1, 0 },
                { 1, 0, 1, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 1 } };
        removeIslands(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

}
