/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
package medium;


import java.util.Arrays;
import java.util.HashSet;

import java.util.Set;

import commons.Array;

public class ThreeNumberSum {

    Set<Integer[]> threeNumberSum(int[] array, int target) {
        Set<Integer[]> triplets = new HashSet<>();
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == target) {
                    Integer[] triplet = { array[i], array[left], array[right] };
                    triplets.add(triplet);
                    left++;
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                }
            }

        }
        return triplets;
    }

    public static void main(String[] args) {

        int[] nums = { -1, 0, 1, 2, -1, -4 };

        Set<Integer[]> output = new ThreeNumberSum().threeNumberSum(nums, 0);
        for (Integer[] triplet : output) {
            new Array().print(triplet);
        }
    }
}
