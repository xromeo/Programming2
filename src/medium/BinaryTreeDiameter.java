/**
 * Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
Example 1.
        1
       / \
      2   3
     / \ 
    4   5

Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
            1
             \
              2

Output: 1
 
Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
 */
package medium;

import commons.Node;

public class BinaryTreeDiameter {


    public int binaryTreeDiameter(Node node){
        return getNodeInfo(node).diameter;
    }

    public NodeInfo getNodeInfo(Node node){
        if(node == null){
            return new NodeInfo(0, 0);
        }

        NodeInfo leftNodeInfo = getNodeInfo(node.getLeft());
        NodeInfo rightNodeInfo = getNodeInfo(node.getRight());

        int longestPathTroughRoot = leftNodeInfo.height + rightNodeInfo.height;
        int maxDiameterSoFar = Math.max(leftNodeInfo.diameter, rightNodeInfo.diameter);
        int currentDiameter = Math.max(longestPathTroughRoot, maxDiameterSoFar);
        int currentHeight = 1 + Math.max(leftNodeInfo.height, rightNodeInfo.height);

        return new NodeInfo(currentDiameter, currentHeight);

    }

    class NodeInfo {
        int diameter;
        int height;

        public NodeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }

    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.insert(4);
        node.insert(3);
        node.insert(2);
        node.insert(1);
        node.insert(7);
        node.insert(8);
        node.insert(9);
        node.insert(11);
                

        System.out.println(new BinaryTreeDiameter().binaryTreeDiameter(node));

    }

}