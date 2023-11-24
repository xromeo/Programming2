package easy;
/*
 * Given two arrays of equal size n and an integer k. The task is to permute both arrays such that sum of their corresponding element is greater than or equal to k i.e a[i] + b[i] >= k. The task is to print “Yes” if any such permutation exists, otherwise print “No”.

Examples : 

Input : a[] = {2, 1, 3}, 
        b[] = { 7, 8, 9 }, 
        k = 10. 
Output : Yes
Permutation  a[] = { 1, 2, 3 } and b[] = { 9, 8, 7 } 
satisfied the condition a[i] + b[i] >= K.

Input : a[] = {1, 2, 2, 1}, 
        b[] = { 3, 3, 3, 4 }, 
        k = 5. 
Output : No
 * 
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import commons.Array;

public class PermutingTwoArrays {
    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {

        A.sort(Comparator.reverseOrder());
        B.sort(Comparator.naturalOrder());

        int n = A.size();
        for (int i = 0; i < n; i++) {
            if (A.get(i) + B.get(i) < k) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {

        Integer[] a = {0,1};
        Integer[] b = {0,2};

        List<Integer> A =  Arrays.asList(a);
        List<Integer> B = Arrays.asList(b);

        System.out.println(twoArrays(1, A, B));

    }
}
