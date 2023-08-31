package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/*
 * 
 
please solve this problem using a Set to track bombs
Bomberman lives in a rectangular grid. Each cell in the grid either contains a bomb or nothing at all.

Each bomb can be planted in any cell of the grid but once planted, it will detonate after exactly 3 seconds. Once a bomb detonates, it's destroyed — along with anything in its four neighboring cells. This means that if a bomb detonates in cell i,j, any valid cells (i+1, j), (i-1, j) and (i,j+1),(i+j-1) are cleared. If there is a bomb in a neighboring cell, the neighboring bomb is destroyed without detonating, so there's no chain reaction.

Bomberman is immune to bombs, so he can move freely throughout the grid. Here's what he does:

Initially, Bomberman arbitrarily plants bombs in some of the cells, the initial state.
After one second, Bomberman does nothing.
After one more second, Bomberman plants bombs in all cells without bombs, thus filling the whole grid with bombs. No bombs detonate at this point.
After one more second, any bombs planted exactly three seconds ago will detonate. Here, Bomberman stands back and observes.
Bomberman then repeats steps 3 and 4 indefinitely.
Note that during every second Bomberman plants bombs, the bombs are planted simultaneously (i.e., at the exact same moment), and any bombs planted at the same time will detonate at the same time.

Given the initial configuration of the grid with the locations of Bomberman's first batch of planted bombs, determine the state of the grid after N seconds.

For example, if the initial grid looks like:

...
.O.
...
it looks the same after the first second. After the second second, Bomberman has placed all his charges:

OOO
OOO
OOO
At the third second, the bomb in the middle blows up, emptying all surrounding cells:

O.O
...
O.O
 * 
 */

public class TheBombermanGame1 {

    public static List<String> bomberMan(int n, List<String> grid) {

        int r = grid.size();
        int c = grid.get(0).length();

        char[][] matrix = new char[r][c];

        if (n == 1) {
            return grid;
        }
        if (n == 2) {

            List<String> result = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                String s = "";
                for (int j = 0; j < c; j++) {
                    s += "O";
                }
                result.add(s);
            }
            return result;

        }

        int t = 0;
        Set<Integer> bombs = getMatrix(grid, c, matrix);

        if (n % 4 == 1) {
            n = 5;
        } else {
            n = 3;
        }

        System.out.println(n);

        t = t + 1;

        System.out.println(t);
        printMatrix(matrix);

        Set<Integer> nextBombs = new HashSet<>();

        while (t < n) {

            fillBombs(c, matrix, nextBombs);

            t = t + 1;
            System.out.println(t);
            printMatrix(matrix);

            if (t < n) {

                // Detonate
                detonateBombs(r, c, matrix, bombs, nextBombs);

                t = t + 1;
                System.out.println(t);
                printMatrix(matrix);

                bombs = nextBombs;
                nextBombs = new HashSet<>();

            }

        }

        return getResult(r, c, matrix);
    }

    private static Set<Integer> getMatrix(List<String> grid, int c, char[][] matrix) {
        Set<Integer> bombs = new HashSet<>();

        ListIterator<String> listIterator = grid.listIterator();
        while (listIterator.hasNext()) {
            int i = listIterator.nextIndex();
            String row = listIterator.next();

            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == 'O') {

                    bombs.add(i * c + j);
                }
                matrix[i][j] = row.charAt(j);
            }
        }
        return bombs;
    }

    private static void detonateBombs(int r, int c, char[][] matrix, Set<Integer> bombs, Set<Integer> nextBombs) {
        for (Integer bomb : bombs) {

            int i = bomb / c;
            int j = bomb % c;
            nextBombs.remove(i * c + j);
            matrix[i][j] = '.';
            if (i > 0) {

                nextBombs.remove((i - 1) * c + j);
                matrix[i - 1][j] = '.';
            }
            if (i < r - 1) {
                nextBombs.remove((i + 1) * c + j);
                matrix[i + 1][j] = '.';
            }
            if (j > 0) {
                nextBombs.remove(i * c + j - 1);
                matrix[i][j - 1] = '.';
            }
            if (j < c - 1) {
                nextBombs.remove(i * c + j + 1);
                matrix[i][j + 1] = '.';
            }
        }
    }

    private static void fillBombs(int c, char[][] matrix, Set<Integer> nextBombs) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '.') {

                    nextBombs.add(i * c + j);
                    matrix[i][j] = 'O';
                }
            }
        }
    }

    private static List<String> getResult(int r, int c, char[][] matrix) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            String s = "";
            for (int j = 0; j < c; j++) {

                s += matrix[i][j];
            }
            result.add(s);
        }
        return result;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void main(String[] args) {
        List<String> grid = Arrays.asList(
                ".......",
                "...O.O.",
                "....O..",
                "..O....",
                "OO...OO",
                "OO.O...");
        bomberMan(5, grid);

    }
}
