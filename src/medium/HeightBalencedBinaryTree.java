/**
* A height-balanced binary tree is defined as a binary tree in which the height of the left and the right subtree of any node differ by not more than 1.
 AVL tree, red-black tree are examples of height-balanced trees.
                    1
                   / \
                  2   3
                 / \   \
                4   5   6
                   / \
                  7   8

Conditions for Height-Balanced Binary Tree:
Following are the conditions for a height-balanced binary tree:

The difference between the heights of the left and the right subtree for any node is not more than one.
The left subtree is balanced.
The right subtree is balanced.
Note: An empty tree is also height-balanced.

*/

package medium;

// Structure of a BST node
class Node {
    int value;
    Node left = null;
    Node right = null;

    Node(int value) {
        this.value = value;
    }

    Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class NodeInfo {
    boolean isBalanced;
    int height;

    public NodeInfo(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}

// O(n) time | O(h) space
class HeightBalancedBinaryTree {
    // Recursive function to insert a key into a BST
    public boolean isHeightBalanced(Node node) {
        NodeInfo nodeInfo = getNodeInfo(node);
        return nodeInfo.isBalanced;
    }

    public NodeInfo getNodeInfo(Node node){
        if(node == null){
            return new NodeInfo(true, -1);
        }
        
        NodeInfo leftNodeInfo = getNodeInfo(node.left);
        NodeInfo rightNodeInfo = getNodeInfo(node.right);

        boolean isBalanced = leftNodeInfo.isBalanced && rightNodeInfo.isBalanced && Math.abs(leftNodeInfo.height - rightNodeInfo.height) <= 1;
        int height = Math.max(leftNodeInfo.height, rightNodeInfo.height) + 1;
        
        return new NodeInfo(isBalanced, height);
    }


    /* Driver Code */
    public static void main(String[] args) {

        Node node1 = new Node(1);
        node1.left  = new Node(2);
        node1.right = new Node(3);

        System.out.println(new HeightBalancedBinaryTree().isHeightBalanced(node1));

    }
}
