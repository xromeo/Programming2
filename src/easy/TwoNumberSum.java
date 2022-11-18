/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
*/

package easy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {



    int[] twoNumberSum1(int[] array, int expected) {
        Map<Integer, Boolean> map = new HashMap<>();
        int i = 0;
        while (i < array.length) {
            int x = array[i];
            int y = expected - x;
            if (map.containsKey(y)) {
                return new int[] { x, y };
            } else {
                map.put(x, Boolean.TRUE);
            }
            i++;
        }

        return new int[] { 0, 0 };
    }

    int[] twoNumberSum2(int[] array, int expected) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == expected) {
                return new int[] { array[left], array[right] };
            }
            else if (sum < expected) {
                left++;
            }
           else if (sum > expected) {
                right--;
            }
        }

        return new int[] { 0, 0 };
    }

    void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    public static void main(String[] args) {
        TwoNumberSum twoNumberSum = new TwoNumberSum();
        var array = new int[] { -5, 4, -6, -8, 7, -1, -7, -4, -2, 5 };

        int expected = 12;
        var r1 = twoNumberSum.twoNumberSum1(array, expected);
        twoNumberSum.print(r1);
        var r2 = twoNumberSum.twoNumberSum2(array, expected);
        twoNumberSum.print(r2);

    }
}
