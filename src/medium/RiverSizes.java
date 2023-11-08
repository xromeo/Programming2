package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * You are given a two-dimensional array (matrix) of potentially unequal height and width containing only 0s and 1s. Each 0 represents land, and each 1 represents part of a river. A river consists of any number of 1s that are either horizontally or vertically adjacent (but not diagonally adjacent). The number of adjacent 1s forming a river determine its size.
 * 
 * Note that the rives can twist. In other words, it doesn't have to be a straight vertical lien or a straight horizontal line; it can be L-shaped, for example
 * 
 * Write a function that returns an array of the sizes of all rivers represented in the input matrix. Note that these sizes do not need to be in any particular order.

Sample input: [ 
    [1, 0, 0, 1, 0], 
    [1, 0, 1, 0, 0], 
    [0, 0, 1, 0, 1], 
    [1, 0, 1, 0, 1], 
    [1, 0, 1, 1, 0], 
    ]

Sample output: [1, 2, 2, 2, 5]
 * 
 */

public class RiverSizes {

    public static List<Integer> riverSizes(int[][] matrix) {

        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    int currentRiverSize = traverseRiver(i, j, matrix, visited);
                    sizes.add(currentRiverSize);
                }
            }
        }
        return sizes;
    }

    private static int traverseRiver(int i, int j, int[][] matrix, boolean[][] visited) {

        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int currentRiverSize = 0;
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[] { i, j });

        while (!stack.isEmpty()) {
            Integer[] currentNode = stack.pop();
            i = currentNode[0];
            j = currentNode[1];

            if (i < 0 || i >= numRows || j < 0 || j >= numCols || visited[i][j] || matrix[i][j] == 0) {
                continue;
            }

            visited[i][j] = true;
            currentRiverSize++;

            int[][] neighbors = { { i - 1, j }, { i + 1, j }, { i, j - 1 }, { i, j + 1 } };
            for (int[] neighbor : neighbors) {
                stack.push(new Integer[] { neighbor[0], neighbor[1] });
            }
        }

        return currentRiverSize;
    }

    public static void main(String[] args) {
        int[][] matrix = {{}};
        System.out.println(riverSizes(matrix));

    }
}
