/*
 * 
 * Given preorder traversal of a binary search tree, construct the BST.

For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be the root of the following tree.

     10
   /   \
  5     40
 /  \      \
1    7      50
 */
package medium;

import java.util.List;

/**
 * ReconstructBst
 */
public class ReconstructBst {

    static BinarySearchTree reconstructBst(List<Integer> array) {
        if (array.size() > 0) {
            BinarySearchTree bst = new BinarySearchTree(array.get(0));

            for (int i = 1; i < array.size(); i++) {
                int value = array.get(i);
                    insert(bst, value);
            }
            return bst;

        }
        return null;
    }

    static void insert(BinarySearchTree bst, int value) {
        if (bst == null) {
            return;
        }
        if (value < bst.value && bst.left != null) {
            insert(bst.left, value);
        } else if (value < bst.value) {
            bst.left = new BinarySearchTree(value);
        } else if (value > bst.value && bst.right != null) {
            insert(bst.right, value);
        } else if (value > bst.value) {
            bst.right = new BinarySearchTree(value);
        }
    }

    public static void main(String[] args) {
        List<Integer> array = List.of(10,4,2,1,5,17,19,18);
        var bst = reconstructBst(array);
        BinarySearchTraversal.postOrderTraverse(bst);

    }
}