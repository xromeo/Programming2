
/*
 * Smallest Difference
Understanding the problem
We are given two arrays of integers. Both of them contain at least one element. We are asked to write a function that is going to find two numbers, one in each array, with the smallest absolute difference, and return them in an array. In the resultant array, the number from the first array should come first.

Example:

Input:
arrayOne = [-1, 5, 10, 20, 28, 3]
arrayTwo = [26, 134, 135, 15, 17]

Output: [28, 26]
 */
package medium;

import java.util.Arrays;

import commons.Array;

public class SmallesDifference {

    int[] smallestDiference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int x = 0;
        int y = 0;
        int[] result = new int[2];
        int smallest = Integer.MAX_VALUE;

        while (x < a.length && y < b.length) {
            int current = Math.abs(a[x] - b[y]);
            if (current < smallest) {
                smallest = current;
                result = new int[] { a[x], b[y] };
            } else if (a[x] < b[y]) {
                x++;
            } else if (a[x] > b[y]) {
                y++;
            } else {
                return new int[] { a[x], b[y] };
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arrayOne = { -1, 5, 10, 20, 28, 3 };
        int[] arrayTwo = { 28, 134, 135, 15, 17 };

        int[] result = new SmallesDifference().smallestDiference(arrayOne, arrayTwo);
        new Array().print(result);

    }

}
