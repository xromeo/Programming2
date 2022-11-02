/*
 * You're given an array of integers and an integer. Write a function that moves all instances of that integer in the array to the end of the array and returns the array. The function should perform this IN-PLACE and doesn't need to maintain the order of the other integers.

For example:

array = [2,1,2,2,2,3,4,2]
toMove = 2

Expected = [1,3,4,2,2,2,2,2] 
           (the numbers 1,3,4 could be ordered differently)
 */
package medium;

import commons.Array;

public class MoveElementToEnd {

    void moveElementToEnd(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int valueLeft = array[left];
            int valueRight = array[right];
            if (valueRight == target) {
                right--;
            } else if (valueLeft == target) {
                array[left] = valueRight;
                array[right] = valueLeft;
                right--;
                left++;

            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {

        int[] array = { 1, 2, 1, 2, 3, 2, 2, 3, 4, 2,7 };
        int toMove = 2;
        new MoveElementToEnd().moveElementToEnd(array, toMove);

        new Array().print(array);

    }

}
