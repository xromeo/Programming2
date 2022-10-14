package medium;

import java.util.Arrays;

/**
 * MergeSort
 */
public class MergeSort {

    int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        return merge(mergeSort(left), mergeSort(right));

    }

    int[] merge(int[] arrayLeft, int[] arrayRight) {
        int n = arrayLeft.length + arrayRight.length;
        int[] result = new int[n];
        int l = 0;
        int r = 0;
        int i = 0;
        while (l < arrayLeft.length && r < arrayRight.length) {
            int valueLeft = arrayLeft[l];
            int valueRight = arrayRight[r];
            if (valueLeft > valueRight) {
                result[i] = valueRight;
                r++;
            } else {
                result[i] = valueLeft;
                l++;
            }
            i++;
        }

        while (l < arrayLeft.length) {
            result[i] = arrayLeft[l];
            l++;
            i++;
        }
        while (r < arrayRight.length) {
            result[i] = arrayRight[r];
            i++;
            r++;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] array = { 4, 2, 3, 7 };
        int[] result = new MergeSort().mergeSort(array);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
    }
}