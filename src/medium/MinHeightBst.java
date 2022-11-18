package medium;

import java.util.List;

/**
 * MinHeightBst
 */
public class MinHeightBst {

    static BinarySearchTree buildMinHeightBst(List<Integer> array) {

        return buildMinHeightBst(array, 0, array.size() - 1);
    }

    static BinarySearchTree buildMinHeightBst(List<Integer> array, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        BinarySearchTree bst = new BinarySearchTree(array.get(mid));
        bst.left = buildMinHeightBst(array, start, mid - 1);
        bst.right = buildMinHeightBst(array, mid + 1, end);

        return bst;

    }

    public static void main(String[] args) {
        List<Integer> array = List.of(5, 7, 9, 1, 10, 12);
        var bst = buildMinHeightBst(array);
        //BinarySearchTraversal bstt = new BinarySearchTraversal();
        BinarySearchTraversal.preOrderTraverse(bst);

    }
}