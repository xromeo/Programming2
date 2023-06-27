package medium;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LegoBlocks {

    public static int legoBlocks(int n, int m) {
        BigInteger MOD = BigInteger.valueOf(1_000_000_007);

        // Step 1: O(W)
        // The number of combinations to build a single row
        // As only four kinds of sizes, so
        // base case:
        // if width is 0, combination is 1
        // if width is 1, combination is 1
        // if width is 2, combination is 2
        // if width is 3, combination is 4
        List<BigInteger> rowCombinations = new ArrayList<>(
            Arrays.asList(
                BigInteger.valueOf(1L),
                BigInteger.valueOf(1L),
                BigInteger.valueOf(2L),
                BigInteger.valueOf(4L))
                );

        // Build row combinations up to current wall's width
        while (rowCombinations.size() <= m) {
            BigInteger newCombination = (rowCombinations.get(rowCombinations.size() - 1)
            .add(rowCombinations.get(rowCombinations.size() - 2))
            .add(rowCombinations.get(rowCombinations.size() - 3))
            .add(rowCombinations.get(rowCombinations.size() - 4)))
            .mod(MOD);
            rowCombinations.add(newCombination);
        }

        System.out.println(rowCombinations.get(m - 1));
        System.out.println(rowCombinations.get(m));
        System.out.println();

        // row_combination
        // 936170984
        // 307700176
        
        // Step 2: O(W)
        // Compute total combinations
        // for constructing a wall of height N of varying widths
        List<BigInteger> total = new ArrayList<>();
        BigInteger nbi = BigInteger.valueOf(n);
        for (BigInteger c : rowCombinations) {
            total.add(c.modPow(nbi, MOD));
        }

        System.out.println("total");
        System.out.println(total.get(0));
        System.out.println(total.get(m - 1));
        System.out.println(total.get(m));
        System.out.println();
        // 255979104
        // 828919229

        // Step 3: O(W^2)
        // Find the number of unstable wall configurations
        // for a wall of height N of varying widths
        List<BigInteger> unstable = new ArrayList<>();
        unstable.add(BigInteger.valueOf(0L));
        unstable.add(BigInteger.valueOf(0L));

        for (int i = 2; i <= m; i++) {
            // i: current total width
            // j: left width
            // i - j: right width
            // f: (left part - previous vertical violation)*right part
            BigInteger result = BigInteger.ZERO ;
            for (int j = 1; j < i; j++) {
                // f: (left part - previous vertical violation)*right part

                BigInteger left = total.get(j);
                BigInteger previousVerticalViolation = unstable.get(j);
                BigInteger right = total.get(i - j);


                //long f = (total.get(j) - unstable.get(j)) * total.get(i - j);
                result = result.add(left.subtract(previousVerticalViolation).multiply(right));
            }
            unstable.add(result.mod(MOD));
        }

        System.out.println(unstable.get(m));

        // Print the number of stable wall combinations
        BigInteger r = total.get(m).subtract(unstable.get(m)).mod(MOD);
        return  r.intValue();

    }

    public static void main(String[] args) {
        //System.out.println(legoBlocks(924, 604)); // #//382238489
        System.out.println(legoBlocks(694, 335)); // #//30314890
    }

}
