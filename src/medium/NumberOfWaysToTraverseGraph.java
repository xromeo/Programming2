package medium;

/*
 * Given a two-dimensional matrix, in how way can someone traverse it from top-left to bottom-right? 
Condition- At any particular cell the possible moves are either down or right, no other steps possible.
Stop when the end is reached.

 S0 . . .
 . . . .
  . . . F

Example 1: 

Input : 5 5
Output : 70

Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

If we look closely, we will find that the number of ways a cell can be reached is = Number of ways it can reach the cell above it + number of ways it can reach the cell which is left of it. 
 */

public class NumberOfWaysToTraverseGraph {

    // Recursive O(2^(n+m)) time | O(n+m) space
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        if (width == 1 || height == 1) {
            return 1;
        }

        return numberOfWaysToTraverseGraph(width - 1, height) + numberOfWaysToTraverseGraph(width, height - 1);
    }

    // Dynamic Programming O(n+m) time | O(n*m) space
    public static int numberOfWaysToTraverseGraph2(int width, int height) {
        int[][] numberOfWays = new int[height + 1][width + 1];
        for (int withIdx = 1; withIdx < width + 1; withIdx++) {
            for (int heightIdx = 1; heightIdx < height + 1; heightIdx++) {
                if (withIdx == 1 || heightIdx == 1) {
                    numberOfWays[heightIdx][withIdx] = 1;
                } else {
                    int waysLeft = numberOfWays[heightIdx][withIdx - 1];
                    int waysUp = numberOfWays[heightIdx - 1][withIdx];
                    numberOfWays[heightIdx][withIdx] = waysLeft + waysUp;
                }
            }
        }
        return numberOfWays[height][width];
    }

    // Math Combinatory O(n+m) time | O(1) space
    public static int numberOfWaysToTraverseGraph3(int width, int height) {
        int xDistanceToCorner = width - 1;
        int yDistanceToCorner = height - 1;
        int numerator = factorial(xDistanceToCorner + yDistanceToCorner);
        int denominator = factorial(xDistanceToCorner) * factorial(yDistanceToCorner);
        return numerator / denominator;
    }

    private static int factorial(int number) {
        int result = 1;
        for (int n = 2; n < number + 1; n++) {
            result *= n;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToTraverseGraph(3, 2));
        System.out.println(numberOfWaysToTraverseGraph2(3, 2));
        System.out.println(numberOfWaysToTraverseGraph3(3, 2));
    }
}
