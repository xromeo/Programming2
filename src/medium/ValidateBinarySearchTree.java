package medium;

import java.util.Objects;

/**
 * ValidateBinarySearchTree
 */
public class ValidateBinarySearchTree {

boolean validate(BinarySearchTree node){
    return validate(node, null, null);
}

    boolean validate(BinarySearchTree node, BinarySearchTree min, BinarySearchTree max){
        if(Objects.nonNull(max) && max.value < node.value){
            return false;
        }
        if(Objects.nonNull(min) && min.value > node.value){
            return false;
        }
        if(Objects.nonNull(node.left) && !validate(node.left, min, node)){
            return false;
        }
        if(Objects.nonNull(node.right) && !validate(node.right, node, max)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        BinarySearchTree bts = new BinarySearchTree(10);
        bts.insert(5);
        bts.insert(15);
        bts.insert(12);
        bts.insert(3);
        bts.insert(20);
        bts.insert(21);

        System.out.println( new ValidateBinarySearchTree().validate(bts));
        
    }


}