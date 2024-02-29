package medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/*

You are given Q queries. Each query consists of a single number N. You can perform any of the 2 operations on N in each move:

1: If we take 2 integers a and b where N = a x b (a != 1, b != 1), then we can change N = max(a,b) 

2: Decrease the value of N by 1.

Determine the minimum number of moves required to reduce the value of N to 0.

Input Format

The first line contains the integer Q.
The next Q lines each contain an integer, N.

Constraints
1<= Q <= 10³
1<= N <= 10⁶

Output Format

Output Q lines. Each line containing the minimum number of moves required to reduce the value of N to 0.

Sample Input

2
3
4
Sample Output

3
3
Explanation

For test case 1, We only have one option that gives the minimum number of moves.
Follow  3 -> 3 -> 1 -> 0. Hence, 3 moves.

For the case 2, we can either go 4 -> 3 -> 2 -> 1 -> 0 or 4 -> 2 -> 1 -> 0. The 2nd option is more optimal. Hence, 3 moves.

 */
public class DownToZero {

    static final int LIMIT = 21;
    static int[] solutions = buildSolutions();

    private static int[] buildSolutions() {
        int[] solutions = new int[LIMIT + 1];
        for (int i = 1; i < solutions.length; i++) {
            solutions[i] = solutions[i - 1] + 1;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    solutions[i] = Math.min(solutions[i], solutions[i / j] + 1);
                }
            }
        }

        return solutions;
    }

    public static int downToZero(int N) {
        return solutions[N];
    }

    public static int downToZero2(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;

            //Efficiency: When checking for divisors, you don't need to check beyond the square root of the number. If j * j is greater than i, then j must be greater than the square root of i
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[i / j] + 1);
                }
            }
        }

        return dp[n];
    }

    // public static void main(String[] args) throws IOException {
    // BufferedReader bufferedReader = new BufferedReader(new
    // InputStreamReader(System.in));

    // int q = Integer.parseInt(bufferedReader.readLine().trim());

    // IntStream.range(0, q).forEach(qItr -> {
    // try {
    // int n = Integer.parseInt(bufferedReader.readLine().trim());

    // int result = downToZero(n);

    // System.out.println(result);
    // } catch (IOException ex) {
    // throw new RuntimeException(ex);
    // }
    // });

    // bufferedReader.close();
    // }

    public static void main(String[] args) {

        System.out.println(downToZero2(21));

        System.out.println(downToZero(21));
        System.out.println(downToZero2(21));

        System.out.println(downToZero(20));
        System.out.println(downToZero2(20));

        System.out.println(downToZero(1));
        System.out.println(downToZero2(1));

        System.out.println(downToZero(2));
        System.out.println(downToZero2(2));

        System.out.println(downToZero(3));
        System.out.println(downToZero2(3));

        System.out.println(downToZero(4));
        System.out.println(downToZero2(4));
    }
}
