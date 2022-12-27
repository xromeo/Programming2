/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * 
 */
package medium;

import java.util.LinkedList;
import java.util.Queue;

import commons.Node;

public class InvertBinaryTree {

    static void invertBinaryTree(Node root) {
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.getLeft() != null){
                queue.add(node.getLeft());                
            }    
            if(node.getRight() != null){
                queue.add(node.getRight());    
            }
            Node aux = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(aux);
        }
    }

    static void invertBinaryTree2(Node root) {
        if(root == null){
            return;
        }    
        Node aux = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(aux);

        invertBinaryTree2(root.getLeft());
        invertBinaryTree2(root.getRight());
    }


    public static void main(String... args){
        Node node = new Node(10);
        node.insert(11);
        node.insert(1);
        node.insert(2);
        node.insert(12);
        node.insert(15);
        node.insert(7);
        node.insert(4);

        //invertBinaryTree(node);

        invertBinaryTree2(node);

        System.out.println();
    }
}
