/*
 * An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.

 

Example 1:

Input: nums = [1,2,2,3]
Output: true
Example 2:

Input: nums = [6,5,4,4]
Output: true
Example 3:

Input: nums = [1,3,2]
Output: false


Constraints:

1 <= nums.length <= 105
-105 <= nums[i] <= 105
 */
package medium;

/**
 * MonotonicArray
 */
public class MonotonicArray {


    boolean monotonicArray(int[] array){
        int left = 0;
        int right = 0;

        boolean decreasing = true;
        boolean increasing = true;
        while(left < array.length - 1){
            if(array[left] <= array[left + 1]){
            	left++;
            }
            else{
                increasing = false;
                break;
            }
        }
        while(right < array.length - 1){
			if(array[right] >= array[right + 1]){
				right++;
			}
			else{
				decreasing = false;
				break;
			}
        }
		return decreasing || increasing;
    }

	boolean monotonicArray2(int[] array){
        int i = 0;
		
        boolean decreasing = true;
        boolean increasing = true;
        while(i < array.length - 1){
            if(array[i] < array[i + 1]){
            	decreasing = false;
            }           
			if(array[i] > array[i + 1]){
				increasing = false;       
			}
			i++;
        }
		return decreasing || increasing;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
		int[] nums2 = {6,5,4,4};
		int[] nums3 = {1,3,2};

		
		System.out.println(new MonotonicArray().monotonicArray2(nums));
		System.out.println(new MonotonicArray().monotonicArray2(nums2));
		System.out.println(new MonotonicArray().monotonicArray2(nums3));
	}
}

    
