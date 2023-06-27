package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Given an array of integers, determine whether the array can be sorted in ascending order using only one of the following operations one time.

Swap two elements.
Reverse one sub-segment.
Determine whether one, both or neither of the operations will complete the task. Output is as follows.

If the array is already sorted, output yes on the first line. You do not need to output anything else.

If you can sort this array using one single operation (from the two permitted operations) then output yes on the first line and then:

If elements can only be swapped, d[l] and d[r], output swap l r in the second line. l and r are the indices of the elements to be swapped, assuming that the array is indexed from 1 to n.
If elements can only be reversed, for the segment d[l...r], output reverse l r in the second line. l and r are the indices of the first and last elements of the subarray to be reversed, assuming that the array is indexed from 1 to n. Here d[l...r] represents the subarray that begins at index l and ends at index r, both inclusive.
If an array can be sorted both ways, by using either swap or reverse, choose swap.

If the array cannot be sorted either way, output no on the first line.
 * 
 */

public class AlmostStored {

    public static void almostSorted(List<Integer> arr) {

        int n = arr.size();
        List<Integer> sortedArr = new ArrayList<>(arr);
        Collections.sort(sortedArr);

        // Find differences
        List<Integer> differences = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != sortedArr.get(i)) {
                differences.add(i);
            }
        }

        if (differences.size() == 2) {
            System.out.println("yes");
            System.out.println("swap " + (differences.get(0) + 1) + " " + (differences.get(1) + 1));
            return;
        }

        if (differences.size() > 2) {
            int start = differences.get(0);
            int end = differences.get(differences.size() - 1);

            // Reverse the sub list
            reverseSubList(arr, start, end);
            if (arr.equals(sortedArr)) {
                System.out.println("yes");
                System.out.println("reverse " + (start + 1) + " " + (end + 1));
                return;
            }

        }

        System.out.println("no");

    }

    private static void reverseSubList(List<Integer> arr, int start, int end) {
        while (start < end) {
            int aux = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, aux);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 8, 5, 6, 7);
        almostSorted(list);
        List<Integer> list2 = Arrays.asList(1, 2, 8, 4, 6, 5);
        almostSorted(list2);
        List<Integer> list3 = Arrays.asList(1, 7, 5, 6, 3, 10);
        almostSorted(list3);
        List<Integer> list4 = Arrays.asList(3, 2, 1);
        almostSorted(list4);
        List<Integer> list5 = Arrays.asList(1, 5, 4, 3, 2, 6);
        almostSorted(list5);
        List<Integer> list6 = Arrays.asList(3, 1, 2);
        almostSorted(list6);
    }
}
