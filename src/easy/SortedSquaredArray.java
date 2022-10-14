/*
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */

package easy;

import commons.Array;

public class SortedSquaredArray {

    int[] sortedSquaredArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int i = array.length - 1;
        int[] result = new int[array.length];
        while (left < right) {
            if (Math.abs(array[left]) < Math.abs(array[right])) {
                result[i] = array[right] * array[right];
                right--;
            } else {
                result[i] = array[left] * array[left];
                left++;
            }
            i--;
        }
        if (array.length > 0) {
            result[i] = array[left] * array[left];
        }
        return result;
    }

    public static void main(String[] args) {
        SortedSquaredArray sortedSquaredArray = new SortedSquaredArray();
        int[] array = new int[] { -7, -5, -4, -1, 0, 2, 5, 17 };
        int[] result = sortedSquaredArray.sortedSquaredArray(array);
        new Array().print(result);
    }
}
