package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 

 Ema built a quantum computer! Help her test its capabilities by solving the problem below.

Given a grid of size n*m, each cell in the grid is either good or bad.

A valid plus is defined here as the crossing of two segments (horizontal and vertical) of equal lengths. These lengths must be odd, and the middle cell of its horizontal segment must cross the middle cell of its vertical segment.

Find the two largest valid pluses that can be drawn on good cells in the grid, and return an integer denoting the maximum product of their areas. In the above diagrams, our largest pluses have areas of 5 and 9. The product of their areas is 5*9=45.

Note: The two pluses cannot overlap, and the product of their areas should be maximal.

Function Description

Complete the twoPluses function in the editor below. It should return an integer that represents the area of the two largest pluses.

twoPluses has the following parameter(s):

grid: an array of strings where each string represents a row and each character of the string represents a column of that row

Input Format

The first line contains two space-separated integers,n and m.
Each of the next n lines contains a string of m characters where each character is either G (good) or B (bad). These strings represent the rows of the grid. If the yth character in the line is G, then (x,y) is a goo cell. Otherwise it’s a bad cell.

Output Format

Find 2 pluses that can be drawn on good cells of the grid, and return an integer denoting the maximum product of their areas.

Sample Input 0

5 6
GGGGGG
GBBBgB
GgGggg
GGBBgB
GGGGG
Sample Output 0

5
Sample Input 1

6 6
BgBBGB
gggGGG
BgBBgB
GGGggg
BGBBgB
BGBBGB
Sample Output 1

25  
 */

public class EmasSupercomputer {

    static class Plus {
        int i;
        int j;
        int size;

        public Plus(int i, int j, int size) {
            this.i = i;
            this.j = j;
            this.size = size;
        }

        @Override
        public String toString() {
            return "Plus [i=" + i + ", j=" + j + ", size=" + size + "]";
        }

    }

    public static int twoPluses(List<String> grid) {
        int row = grid.size();
        int col = grid.get(0).length();
        List<Plus> pluses = new ArrayList<>();

        // Find all valid pluses in the grid
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid.get(i).toUpperCase().charAt(j) == 'G') {
                    int size = 0;
                    while (isValidPlus(i, j, size, row, col, grid)) {
                        pluses.add(new Plus(i, j, size));
                        size++;
                    }
                }
            }
        }

        // Calculate the maximum product of two non-overlapping pluses
        int maxProduct = 0;
        for (int i = 0; i < pluses.size(); i++) {
            for (int j = i + 1; j < pluses.size(); j++) {
                if (!isOverlapping(pluses.get(i), pluses.get(j))) {
                    int product = (4 * pluses.get(i).size + 1) * (4 * pluses.get(j).size + 1);
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }

        return maxProduct;
    }

    // Check if a plus at (i, j) with a given size is valid in the grid
    private static boolean isValidPlus(int i, int j, int size, int row, int col, List<String> grid) {
        int top = i - size;
        int bottom = i + size;
        int left = j - size;
        int right = j + size;

        return top >= 0 && bottom < row && left >= 0 && right < col &&
                grid.get(i).toUpperCase().charAt(left) == 'G' && grid.get(i).toUpperCase().charAt(right) == 'G' &&
                grid.get(top).toUpperCase().charAt(j) == 'G' && grid.get(bottom).toUpperCase().charAt(j) == 'G';
    }

    public static boolean isOverlapping(Plus p1, Plus p2) {
        Set<String> plusCells = new HashSet<>();

        plusCells.add(p1.i + "-" + p1.j);
        for (int s = 1; s < p1.size + 1; s++) {
            plusCells.add((p1.i + s) + "-" + p1.j);
            plusCells.add((p1.i - s) + "-" + p1.j);
            plusCells.add(p1.i + "-" + (p1.j + s));
            plusCells.add(p1.i + "-" + (p1.j - s));
        }

        if (plusCells.contains(p2.i + "-" + p2.j)) {
            return true;
        }

        for (int s = 1; s < p2.size + 1; s++) {

            if (plusCells.contains((p2.i + s) + "-" + p2.j)) {
                return true;
            }
            if (plusCells.contains((p2.i - s) + "-" + p2.j)) {
                return true;
            }
            if (plusCells.contains(p2.i + "-" + (p2.j + s))) {
                return true;
            }
            if (plusCells.contains(p2.i + "-" + (p2.j - s))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<String> grid = List.of(

                "BBGGBBGBBGBBG",
                "BBGGBBGBBGBBG",
                "GGGGGGGGGGGGG",
                "BBGGBBGBBGBBG",
                "GGGGGGgGGGGGG",
                "BBGGBBGBBGBBG",
                "BBGGBBGBBGBBG",
                "GGGgGGGGGGGGG",
                "BBGGBBGBBGBBG",
                "GGGGGGGGGGGGG",
                "BBGGBBGBBGBBG");

        int result = twoPluses(grid);
        System.out.println(result); // 169

        List<String> grid1 = List.of(
                "GGBGB",
                "GGGGB",
                "BGBGG",
                "GGGGG",
                "GBBGB");
        System.out.println(twoPluses(grid1)); // 25

        List<String> grid2 = List.of(
                "GGGGGGGG",
                "GBGBGGBG",
                "GBGBGGBG",
                "GGGGGGGG",
                "GBGBGGBG",
                "GGGGGGGG",
                "GBGBGGBG",
                "GGGGGGGG");
        System.out.println(twoPluses(grid2)); // 81

        List<String> grid3 = List.of(

                "BBBBBGGBGG",
                "GGGGGGGGGG",
                "GGGGGGGGGG",
                "BBBBBGGBGG",
                "BBBBBGGBGG",
                "GGGGGgGGgG",
                "BBBBBGGBGG",
                "GGGGGGGGGG",
                "BBBBBGGBGG",
                "GGGGGGGGGG");
        System.out.println(twoPluses(grid3)); // 85


        List<String> grid4 = List.of(
                "GGGGGGGGGGGG",
                "GGGGGGGGGGGG",
                "BGBGGGBGBGBG",
                "BGBGGGBGBGBG",
                "GGGGGGGGGGGG",
                "GGGGGGGGGGGG",
                "GGGGGGGGGGGG",
                "GGGGGGGGGGGG",
                "BGBGGGBGBGBG",
                "BGBGGGBGBGBG",
                "BGBGGGBGBGBG",
                "BGBGGGBGBGBG",
                "GGGGGGGGGGGG",
                "GGGGGGGGGGGG");
        System.out.println(twoPluses(grid4)); // 189

    }
}
