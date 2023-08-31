package medium;
/*
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmasSupercomputer1 {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static boolean checkOverlap(int i0, int j0, int cnt0, int i1, int j1, int cnt1) {
        int result;
        int a = Math.abs(i0 - i1);
        int b = Math.abs(j0 - j1);
        if (cnt1 >= a && cnt1 >= b || cnt0 >= a && cnt1 >= b || cnt0 >= b && cnt1 >= a || b == 0 && a <= cnt0 + cnt1
                || a == 0 && b <= cnt0 + cnt1) {
            result = 1;
        } else {
            result = 0;
        }
        return result == 1;
    }

    public static int twoPluses(List<String> grid) {
        int row = grid.size();
        int col = grid.get(0).length();
        int count_up, count_down, count_left, count_right;
        int count = 0;
        List<Pair> z = new ArrayList<>();
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                count_up = count_down = count_left = count_right = 0;
                // Skip element B
                if (grid.get(i).charAt(j) == 'B') {
                    continue;
                }
                // Process when reach element G
                for (int k = 1; k <= i; k++) {
                    if (grid.get(i - k).charAt(j) == 'G') {
                        count_up++;
                    } else {
                        break;
                    }
                }
                for (int k = 1; k <= row - 1 - i; k++) {
                    if (grid.get(i + k).charAt(j) == 'G') {
                        count_down++;
                    } else {
                        break;
                    }
                }
                for (int h = 1; h <= j; h++) {
                    if (grid.get(i).charAt(j - h) == 'G') {
                        count_left++;
                    } else {
                        break;
                    }
                }
                for (int h = 1; h <= col - 1 - j; h++) {
                    if (grid.get(i).charAt(j + h) == 'G') {
                        count_right++;
                    } else {
                        break;
                    }
                }
                int v1 = Math.min(count_up, count_down);
                int v2 = Math.min(count_right, count_left);
                int v = Math.min(v1, v2);
                if (v != 0) {
                    z.add(new Pair(v, i * col + j));
                    count++;
                }
            }
        }
        Collections.sort(z, (a, b) -> b.first - a.first);
        if (count == 0) {
            return 1;
        }
        if (count == 1) {
            return z.get(0).first * 4 + 1;
        }

        int max = 0;
        if (z.size() > 1) {
            for (int i = 0; i < z.size(); i++) {
                int i0 = z.get(i).second / col;
                int j0 = z.get(i).second % col;
                int cnt0 = z.get(i).first;
                for (int l = 1; l <= cnt0; l++) {
                    for (int j = i + 1; j < z.size(); j++) {
                        int ii = z.get(j).second / col;
                        int ji = z.get(j).second % col;
                        int cnti = z.get(j).first;
                        for (int t = 1; t <= cnti; t++) {
                            int result = l * 4 + 1;
                            if (checkOverlap(i0, j0, l, ii, ji, t)) {
                                if (result >= max) {
                                    max = result;
                                }
                                continue;
                            } else {
                                result = result * (t * 4 + 1);
                            }
                            if (result >= max) {
                                max = result;
                            }
                        } // end loop cnti
                    } // end loop j
                } // end loop cnt0
            } // end loop i
        }
        return max;
    }

    public static void main(String[] args) {
        List<String> grid = List.of(
                "GGBGB",
                "GGGGB",
                "BGBGG",
                "GGGGG",
                "GBBGB");
        int result = twoPluses(grid);
        System.out.println(result); 
    }
}
