package medium;

import java.util.List;

/*



 Sean invented a game involving a 2n * 2n matrix where each cell of the matrix contains an integer. He can reverse any of its rows or columns any number of times. The goal of the game is to maximize the sum of the elements in the n *n submatrix located in the upper-left quadrant of the matrix.

Given the initial configurations for q matrices, help Sean reverse the rows and columns of each matrix in the best possible way so that the sum of the elements in the matrix's upper-left quadrant is maximal. 

Input :

matrix = [[1, 2], [3, 4]]

Output :

4

Input :

matrix = [[112, 42, 83, 119], [56, 125, 56, 49], [15, 78, 101, 43], [62, 98, 114, 108]]

Output :

119 + 114 + 56 + 125 = 414 

| a b c c b a |
| d e f f e d |
| g h i i h g |
| g h i i h g |
| d e f f e d |
| a b c c b a |

 */

public class FlippingMatrix {

    public static int flippingMatrix2(List<List<Integer>> matrix) {
        int sum = 0;
        int size = matrix.size();
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size / 2; j++) {
                sum += Math.max(matrix.get(i).get(j),
                        Math.max(matrix.get(i).get(size - 1 - j),
                                Math.max(matrix.get(size - 1 - i).get(j),
                                        matrix.get(size - 1 - i).get(size - 1 - j))));
            }
        }
        return sum;
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int sum = 0;
        int size = matrix.size();
        int halfSize = size / 2;

        for (int i = 0; i < halfSize; i++) {
            for (int j = 0; j < halfSize; j++) {
                int top_left = matrix.get(i).get(j);
                int top_right = matrix.get(i).get(size - 1 - j);
                int bottom_left = matrix.get(size - 1 - i).get(j);
                int bottom_right = matrix.get(size - 1 - i).get(size - 1 - j);

                int maxOfFour = Math.max(Math.max(top_left, top_right), Math.max(bottom_left, bottom_right));
                sum += maxOfFour;
            }
        }

        return sum;
    }

    // Test the method with an example matrix
    public static void main(String[] args) {
        // int result = flippingMatrix(List.of(List.of(1, 2), List.of(3, 4)));
        // System.out.println("The optimal sum is " + result);

        int result = flippingMatrix(List.of(
                List.of(112, 42, 83, 119),
                List.of(56, 125, 56, 49),
                List.of(15, 78, 101, 43),
                List.of(62, 98, 114, 108)));
        System.out.println("The optimal sum is " + result);
    }
}
