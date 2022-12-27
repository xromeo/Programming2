package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary search tree, task is to find Kth largest element in the binary search tree.

Example: 

Input :  k = 3
         Root of following BST
            10
          /    \
         4      20
        /      /   \
       2     15     40
Output : 15
 * 
 */

public class FindKthLargestValueInBst {
    
    static int findKthLargestValueInBst(BinarySearchTree bst, int k){
        List<Integer> sortedNodeValues = new ArrayList<>();
        inOrderTraverse(bst, sortedNodeValues);
        return sortedNodeValues.get(sortedNodeValues.size() - k);

    }
    

    private static void inOrderTraverse(BinarySearchTree bst, List<Integer> sortedNodeValues) {
        if(bst == null){
            return;
        }
        inOrderTraverse(bst.left, sortedNodeValues);
        sortedNodeValues.add(bst.value);
        inOrderTraverse(bst.right, sortedNodeValues);
    }

    /************************************************************************ */

    class NodeInfo{
        int count;
        int value;
        public NodeInfo() {
            this.count = 0;
            this.value = -1;
        }
    }

    int findKthLargestValueInBst2(BinarySearchTree bst, int k){
        
        NodeInfo nodeInfo = new NodeInfo();
        reverseInOrderTraverse(bst, k, nodeInfo);
        return nodeInfo.value;

    }
    

    private static void reverseInOrderTraverse(BinarySearchTree bst, int k , NodeInfo nodeInfo) {
        if(bst == null || nodeInfo.count >= k){
            return;
        }
        reverseInOrderTraverse(bst.right, k, nodeInfo);
        if(nodeInfo.count < k){
            nodeInfo.count +=1;
            nodeInfo.value = bst.value;
            reverseInOrderTraverse(bst.left, k, nodeInfo);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree(10);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);
        bst.insert(12);
        bst.insert(20);
        bst.insert(10);
        bst.insert(15);
        bst.insert(3);

        System.out.println(findKthLargestValueInBst(bst, 3));

        System.out.println(new FindKthLargestValueInBst().findKthLargestValueInBst2(bst, 3));

    }
}
