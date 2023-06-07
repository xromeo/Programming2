public class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
        this.value = value;
    }

    public BST insert(int value) {
        BST current = this;
        while (true) {

            if (value < current.value) {
                if (current.left == null) {
                    current.left = new BST(value);
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new BST(value);
                    break;
                } else {
                    current = current.right;
                }
            }
        }

        return this;
    }

    public boolean contains(int value) {
        BST current = this;
        while (current != null) {
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void preOrderTraverse(BST bst){        
        if(bst != null){
            System.out.println(bst.value);
            preOrderTraverse(bst.left);            
            preOrderTraverse(bst.right);
        }
        return;
    }

    static void postOrderTraverse(BST bst){        
        if(bst != null){
            postOrderTraverse(bst.left);     
            postOrderTraverse(bst.right);
            System.out.println(bst.value);
        }
        return;
    }

    static void inOrderTraverse(BST bst){
        if(bst != null){
            inOrderTraverse(bst.left);
            System.out.println(bst.value);
            inOrderTraverse(bst.right);
        }
    }

    public static void main(String[] args) {
        var bst = new BST(10);
        bst.insert(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        bst.insert(15);
        bst.insert(14);
        bst.insert(13);

        inOrderTraverse(bst);
        System.out.println();
        preOrderTraverse(bst);
        System.out.println();
        postOrderTraverse(bst);
    }
}
