package medium;

import java.util.Arrays;
import java.util.List;

public class FormingMagicSquare {

    public static int formingMagicSquare(List<List<Integer>> s) {

        int[][][] possibilities = {
                { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } },
                { { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } },
                { { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } },
                { { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } },
                { { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } },
                { { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } },
                { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } },
                { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } }
        };

        int MAX = 8;

        int best = Integer.MAX_VALUE;
        for (int i = 0; i < MAX; i++) {
            int[][] possibility = possibilities[i];
            int cost = calculateCost(possibility, s);
            if (cost < best) {
                best = cost;
            }
        }
        return best;
    }

    public static int calculateCost(int[][] posibility, List<List<Integer>> s) {
        int cost = 0;
        for (int i = 0; i < posibility.length; i++) {
            for (int j = 0; j < posibility[i].length; j++) {
                if (s.get(i).get(j) != posibility[i][j]) {
                    cost += Math.abs(s.get(i).get(j) - posibility[i][j]);
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        List<List<Integer>> s = Arrays.asList(List.of(5, 3, 4), List.of(1, 5, 8), List.of(6, 4, 2));
        System.out.println(formingMagicSquare(s));
        List<List<Integer>> s2 = Arrays.asList(List.of(4,9,2), List.of(3,5,7), List.of(8,1,5));
        System.out.println(formingMagicSquare(s2));
        List<List<Integer>> s3 = Arrays.asList(List.of(4,8,2), List.of(4,5,7), List.of(6,1,6));
        System.out.println(formingMagicSquare(s3));
    }
}
