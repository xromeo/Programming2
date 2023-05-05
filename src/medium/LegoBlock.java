package medium;
/*
 * You have an infinite number of 4 types of lego blocks of sizes given as (depth x height x width):

d	h	w
1	1	1
1	1	2
1	1	3
1	1	4
Using these blocks, you want to make a wall of height n and width m. Features of the wall are:

- The wall should not have any holes in it.
- The wall you build should be one solid structure, so there should not be a straight vertical break across all rows of bricks.
- The bricks must be laid (puesto) horizontally.

How many ways can the wall be built?

Function Description

Complete the legoBlocks function in the editor below.

legoBlocks has the following parameter(s):

int n: the height of the wall
int m: the width of the wall
Returns
- int: the number of valid wall formations modulo (10^9 + 7)
Input Format

The first line contains the number of test cases t.

Each of the next  lines contains two space-separated integers n and m.

Constraints

1 <= t < 100
1 <= n,m < 1000

Sample Input

STDIN   Function
-----   --------
4       t = 4
2 2     n = 2, m = 2
3 2     n = 3, m = 2
2 3     n = 2, m = 3
4 4     n = 4, m = 4
Sample Output

3  
7  
9  
3375


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import commons.Array;

public class LegoBlock {
    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER m
     */
    private static final int MOD = 1000000007;

    public static int legoBlocks(int n, int m) {

        List<Integer> all = tetranacci(m).stream().map(v -> Math.pow(v, n) % MOD)
                .mapToInt(d -> Double.valueOf(d).intValue()).boxed().collect(Collectors.toList());

        new Array().print(all);

        List<Integer> solid = new ArrayList<>();
        solid.add(1);

        IntStream.range(1, all.size()).forEach(i -> {

            List<Integer> reverse = new ArrayList<>(solid);
            Collections.reverse(reverse);

            System.out.println();
            new Array().print(all.subList(0, i));
            new Array().print(reverse);

            System.out.println();

            // List<Integer> allSlice = all.subList(0, i);
            int sum = IntStream.range(0, i).map(k -> all.get(k) * reverse.get(k)).sum();
            solid.add((all.get(i) - sum) % MOD);

        });
        new Array().print(solid);
        return solid.get(solid.size() - 1);
    }

    public static List<Integer> tetranacci(int n) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 4, 8));
        if (n <= 4) {
            return array.subList(0, n);
        }
        for (int i = 4; i < n; i++) {
            Integer value = IntStream.range(i - 4, i).map(k -> array.get(k)).sum() % MOD;
            array.add(value);
        }
        return array;
    }

    public static void main(String[] args) {

        new Array().print(LegoBlock.tetranacci(6));

        System.out.println(legoBlocks(3, 5));

    }

    /*
     * 21
     * 
     * 
     * First, let's see how many M*N walls can we build if we neglect the need to
     * keep them connected:
     * 
     * We can treat each row separately, and then multiply the counts since they are
     * independent.
     * 
     * There is only one way to tile a 0*1 or a 1*1 wall, and the number of ways to
     * tile an n*1 is the total of the number of ways to tile
     * {n-1}*1...{n-4}*1-sized walls, the reason being these walls can be obtained
     * by removing the last tile of the n*1 wall.
     * 
     * This gives rise to a tetranacci sequence, OEIS A000078. The number of all W*H
     * walls is a(w,h)=T(w)^h.
     * 
     * Now, to count the number of solid walls. MBo's answer already contains the
     * basic premise:
     * 
     * Branch on the leftmost place where the wall is not connected. The number of
     * All W*H walls is the number of Solid X*H walls times the number of All
     * {W-X}*H walls, summed across all possible values of X, plus the number of
     * Solid W*H walls:
     * 
     * A(W,H) = sum{X=1..{W-1}}(S(X,H)*A(W-X,H)) + S(W,H)
     * As a last step, we separate S(M,H) term, which is the value we want to
     * calculate, and repeat the previous formulas:
     * 
     * S(W,H) = A(W,H) - sum_x( S(X,H)*A(W-X,H) ) //implicitly, S(1,H)=1
     * 
     * A(W,H) = T(W)^H
     * 
     * T(X) = X > 0: T(X-1)+T(X-2)+T(X-3)+T(X-4)
     * X = 0: 1
     * X < 0: 0
     * (proving MBo's formula correct).
     * 
     * This also provides an O(W^2) algorithm to compute S (assuming proper
     * memoization and constant-time arithmetic operations)
     */

}
