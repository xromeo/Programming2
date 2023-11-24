package easy;

/*
 *There will be two arrays of integers. Determine all integers that satisfy the following two conditions:

The elements of the first array are all factors of the integer being considered
The integer being considered is a factor of all elements of the second array
These numbers are referred to as being between the two arrays. Determine how many such numbers exist.

Note Omar: In mathematics, when we say that one number is a factor of another, it means that the first number can be evenly divided into the second number without leaving a remainder.

For example:

3 is a factor of 12 because 12 divided by 3 equals 4 with no remainder (12 ÷ 3 = 4).
5 is a factor of 25 because 25 divided by 5 equals 5 with no remainder (25 ÷ 5 = 5).

Example
a = [2,6]
b=[24,36]

There are two numbers between the arrays: 6 and 12.
6%2=0, 6%6=0, 24%6=0 and 36%6=0 for the first value.
12%2=0, 16%6=0 and 24%12=0, 36%12=0 for the second value. Return 2.

Function Description

Complete the getTotalX function in the editor below. It should return the number of integers that are between the sets.

getTotalX has the following parameter(s):

int a[n]: an array of integers
int b[m]: an array of integers
Returns

int: the number of integers that are between the sets

Sample Input

2 3
2 4
16 32 96
Sample Output

3
Explanation

2 and 4 divide evenly into 4, 8, 12 and 16.
4, 8 and 16 divide evenly into 16, 32, 96.

4, 8 and 16 are the only three numbers for which each element of a is a factor and each is a factor of all elements of b.

 */
import java.util.List;

public class BetweenTwoSets {

   

    public static void main(String[] args) {
        List<Integer> a = List.of(2, 4);
        List<Integer> b = List.of(16, 32, 96);

        int result = getTotalX(a, b);
        System.out.println(result);
    }

    public static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public static int gcdOfArray(List<Integer> arr) {
        int result = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            result = gcd(result, arr.get(i));
        }
        return result;
    }

    public static int lcmOfArray(List<Integer> arr) {
        int result = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            result = lcm(result, arr.get(i));
        }
        return result;
    }

     public static int getTotalX(List<Integer> a, List<Integer> b) {
        int lcmA = lcmOfArray(a);
        int gcdB = gcdOfArray(b);

        int count = 0;
        for (int i = lcmA, j = 2; i <= gcdB; i = lcmA * j, j++) {
            if (gcdB % i == 0) {
                count++;
            }
        }

        return count;
    }
}
