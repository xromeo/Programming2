package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * You are given a square grid with some cells open (.) and some blocked (X). Your playing piece can move along any row or column until it reaches the edge of the grid or a blocked cell. Given a grid, a start and a goal, determine the minimum number of moves to get to the goal.

Example.

grid = ['...','.X.','...']
startX = 0
startY = 0
goalX = 1
goalY = 2


The grid is shown below:

...
.X.
...

The starting position (startX, startY) = (0,0) so start in the top left corner. The goal is (goalX, goalY) = (1,2). The path is (0,0)->(0,2)->(1,2). It takes 2 moves to reach the goal.

Function Description
Complete the minimumMoves function in the editor.

minimumMoves has the following parameter(s):

string grid[n]: an array of strings that represent the rows of the grid
int startX: starting X coordinate
int startY: starting Y coordinate
int goalX: ending X coordinate
int goalY: ending Y coordinate

Returns

int: the minimum moves to reach the goal


Constraints

1 ≤ n ≤ 100

0 ≤ startX, startX, goalX, goalY < n

 */

public class CastleOnTheGrid {

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {

        if (startX == goalX && startY == goalY) {
            return 0;
        }

        int n = grid.size();
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String row = grid.get(i);
            for (int j = 0; j < n; j++) {
                matrix[i][j] = row.charAt(j);
            }
        }

        int[][] step = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n * startX + startY);

        visited[startX][startY] = true;

        List<int[]> move = List.of(new int[] { -1, 0 }, new int[] { 0, 1 }, new int[] { 1, 0 }, new int[] { 0, -1 });

        while (!queue.isEmpty()) {
            Integer value = queue.poll();
            int x = value / n;
            int y = value % n;

            for (int i = 0; i < move.size(); i++) {
                int delta = 1;

                int xNext = x + move.get(i)[0] * delta;
                int yNext = y + move.get(i)[1] * delta;

                while (xNext < n
                        && yNext < n
                        && xNext >= 0
                        && yNext >= 0
                        && matrix[xNext][yNext] == '.'
                        && !visited[xNext][yNext]) {
                    
                    queue.add(n * xNext + yNext);
                    step[xNext][yNext] = step[x][y] + 1;
                    visited[xNext][yNext] = true;
                    if (xNext == goalX && yNext == goalY) {
                        return step[xNext][yNext];
                    }
                    delta++;
                    xNext = x + move.get(i)[0] * delta;
                    yNext = y + move.get(i)[1] * delta;
                }

            }

        }

        return -1;

    }

    public static int minimumMoves2(List<String> grid, int startX, int startY, int goalX, int goalY) {
        // Write your code here
        // This can be solved by BSF or DP
        if (grid == null || grid.size() < 1)
            return -1;
        int n = grid.size();
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = grid.get(i).charAt(j);
            }
        }

        // Use queue for BFS
        // a single queue can be replaced by two queues below
        // LinkedList<Integer> queueX = new LinkedList<>();
        // LinkedList<Integer> queueY = new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<>();
        int[][] step = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int curX = node.x;
            int curY = node.y;
            // Move in 4 directions
            for (int i = 0; i < 4; i++) {
                int index = 1;
                // check one step at a time
                while (isSafe(n, curX + xMove[i] * index, curY + yMove[i] * index, matrix)
                        && !visited[curX + xMove[i] * index][curY + yMove[i] * index]) {
                    int nextX = curX + xMove[i] * index;
                    int nextY = curY + yMove[i] * index;
                    visited[nextX][nextY] = true;
                    queue.add(new Node(nextX, nextY));
                    step[nextX][nextY] = step[curX][curY] + 1;
                    // reach the goal
                    if (nextX == goalX && nextY == goalY) {
                        return step[nextX][nextY];
                    }
                    index++;
                }
            }
        }

        return -1;
    }

    static int[] xMove = { -1, 0, 1, 0 };
    static int[] yMove = { 0, 1, 0, -1 };

    private static boolean isSafe(int n, int x, int y, char[][] matrix) {
        return (x >= 0 &&
                y >= 0 &&
                x < n &&
                y < n &&
                matrix[x][y] == '.');
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        List<String> grid = List.of(
                "....",
                "...x",
                "x...",
                "....");

                List<String> grid2 = List.of(
                "..x.",
                "x..x",
                "xx..",
                "....");
                List<String> grid3 = List.of(
                ".X..XX...X",
                "X.........",
                ".X.......X",
                "..........",
                "........X.",
                ".X...XXX..",
                ".....X..XX",
                ".....X.X..",
                "..........",
                ".....X..XX");


        System.out.println(minimumMoves(grid, 0, 0, 3, 3));
        System.out.println(minimumMoves2(grid, 0, 0, 3, 3));

        System.out.println(minimumMoves(grid2, 0, 0, 3, 3));
        System.out.println(minimumMoves2(grid2, 0, 0, 3, 3));

        System.out.println(minimumMoves(grid3, 9, 1, 9, 6));
        System.out.println(minimumMoves2(grid3, 9, 1, 9, 6));
    }

}
