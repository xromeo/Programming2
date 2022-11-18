
/*
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
 */
package medium;

import commons.Array;

public class ArrayOfProducts {

    int[] arrayOfProducts(int[] array) {
        int[] result = new int[array.length];

        int leftProduct = 1;
        for (int i = 0; i < array.length; i++) {
            result[i] = leftProduct;
            leftProduct *= array[i];
        }
        int rightProduct = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= array[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {5,1,4,2};

        var result = new ArrayOfProducts().arrayOfProducts(array);
        new Array().print(result);
    }
}
