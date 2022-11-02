/*Given a sorted array with unique elements, Create a binary search tree with minimal height.

 */
package medium;

import java.util.List;

/**
 * MinHeightBst
 */
public class MinHeightBst {

    static BinarySearchTree minHeightBst(List<Integer> array) {
        return minHeightBst(array, null, 0, array.size() - 1);
    }

    static BinarySearchTree minHeightBst(List<Integer> array, BinarySearchTree bst, int start, int end) {
        if (end < start) {
            return bst;
        }
        int mid = (start + end) / 2;
        int value = array.get(mid);
        if (bst == null) {
            bst = new BinarySearchTree(value);
        } else {
            bst.insert(value);
        }
        minHeightBst(array, bst, start, mid - 1);
        minHeightBst(array, bst, mid + 1, end);
        return bst;
    }

    static BinarySearchTree minHeightBst2(List<Integer> array) {
        return minHeightBst2(array, 0, array.size() - 1);
    }

    static BinarySearchTree minHeightBst2(List<Integer> array, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        int value = array.get(mid);
        
        var bst = new BinarySearchTree(value);
        
        bst.left = minHeightBst(array, bst, start, mid - 1);
        bst.right = minHeightBst(array, bst, mid + 1, end);
        return bst;
    }

    public static void main(String[] args) {
        List<Integer> array = List.of(1, 2, 5, 7, 10, 13, 14, 15, 22);
        var bst = MinHeightBst.minHeightBst(array);
        System.out.println();
    }
}
