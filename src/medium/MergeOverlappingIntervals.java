/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/
package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import commons.Array;

public class MergeOverlappingIntervals {

    List<int[]> mergeOverlappingIntervals(int[][] intervals) {
        List<int[]> merge = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        int[] currentInterval = intervals[0];
        merge.add(currentInterval);
        for(int[] interval : intervals){
            
            int currentIntervalEnd = currentInterval[1];

            int intervalStart = interval[0];
            int intervalEnd = interval[1];

            if(currentIntervalEnd >= intervalStart){
                currentInterval[1] = Math.max(currentIntervalEnd, intervalEnd);
            } else{
                currentInterval = interval;
                merge.add(currentInterval);
            }
            
        }

        return merge;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{4,7},{6,8},{9,10}};
        List<int[]> merge = new MergeOverlappingIntervals().mergeOverlappingIntervals(intervals);
        new Array().printMatrix(merge);


    }

}
