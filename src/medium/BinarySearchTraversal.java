package medium;

public class BinarySearchTraversal {

    static void inOrderTraverse(BinarySearchTree bst){        
        if(bst != null){
            inOrderTraverse(bst.left);
            System.out.println(bst.value);
            inOrderTraverse(bst.right);
        }
        return;
    }
    static void preOrderTraverse(BinarySearchTree bst){        
        if(bst != null){
            System.out.println(bst.value);
            preOrderTraverse(bst.left);            
            preOrderTraverse(bst.right);
        }
        return;
    }
    static void postOrderTraverse(BinarySearchTree bst){        
        if(bst != null){
            postOrderTraverse(bst.left);     
            postOrderTraverse(bst.right);
            System.out.println(bst.value);
        }
        return;
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(10);
        bst.insert(15);
        bst.insert(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(12);

        BinarySearchTraversal.inOrderTraverse(bst);
        System.out.println();
        BinarySearchTraversal.preOrderTraverse(bst);
        System.out.println();
        BinarySearchTraversal.postOrderTraverse(bst);
    }
}
