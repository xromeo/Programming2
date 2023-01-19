/**
 * Find the maximum sum of a subsequence with no adjacent elements
Google Translate Icon
Given an integer array, find the maximum sum of subsequence where the subsequence contains no element at adjacent positions.

Please note that the problem specifically targets subsequences that need not be contiguous, i.e., subsequences are not required to occupy consecutive positions within the original sequences.

 
For example,

Input:  { 1, 2, 9, 4, 5, 0, 4, 11, 6 }
Output: The maximum sum is 26
 
The maximum sum is formed by subsequence { 1, 9, 5, 11 }

*/
  
 
package medium;


import java.util.List;

public class MaxSubsetSumNoAdjacent {

    public int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) {
        return 0;
        } else if (array.length == 1) {
        return array[0];
        }
        int[] maxSums = array.clone();
        maxSums[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
        maxSums[i] = Math.max(maxSums[i - 1], maxSums[i - 2] + array[i]);
        }
        return maxSums[array.length - 1];
    }

    public Integer maxSubsetSumNoAdjacent(List<Integer> array){
        if(array.size() == 0){
            return 0;
        }
        else if (array.size() == 1){
            return array.get(0);
        }
        Integer second = array.get(0);
        Integer first = Math.max(array.get(0), array.get(1));
        for (int i = 2; i < array.size(); i++) {
            Integer current = Math.max(first, second + array.get(i));
            second = first;
            first = current;
        }
        return first;
    }

    public static void main(String[] args) {
        List<Integer> array = List.of(1, 2, 9, 4, 5, 0, 4, 11, 6);
        System.out.println(new MaxSubsetSumNoAdjacent().maxSubsetSumNoAdjacent(array));

        int[] arrayInt = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
        System.out.println(new MaxSubsetSumNoAdjacent().maxSubsetSumNoAdjacent(arrayInt));
    }
}
