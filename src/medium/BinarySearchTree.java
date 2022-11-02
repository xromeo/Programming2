package medium;

/**
 * BinarySearchTree
 */
public class BinarySearchTree {

    public int value;
    BinarySearchTree left;
    BinarySearchTree right;

    public BinarySearchTree(int value) {
        this.value = value;
    }

    public BinarySearchTree insert(int value) {
        BinarySearchTree current = this;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = new BinarySearchTree(value);
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new BinarySearchTree(value);
                    break;
                } else {
                    current = current.right;
                }
            }
        }
        return this;
    }

    public boolean contains(int value) {
        BinarySearchTree current = this;
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

    public BinarySearchTree remove(int value) {
        remove(value, null);
        return this;
    }

    public void remove(int value, BinarySearchTree parent) {
        BinarySearchTree current = this;
        while (current != null) {
            if (value < current.value) {
                parent = current;
                current = current.left;
            } else if (value > current.value) {
                parent = current;
                current = current.right;
            } else {
                if (current.left != null && current.right != null) {
                    current.value = current.right.getMinValue();
                    current.right.remove(current.value, current);
                } else if (parent == null) {
                    if (current.left != null) {
                        current.value = current.left.value;
                        current.right = current.left.right;
                        current.left = current.left.left;
                    } else if (current.right != null) {
                        current.value = current.right.value;
                        current.left = current.right.left;
                        current.right = current.right.right;
                    } else {
                        // This is a single-node tree; do nothing.
                    }
                } else if (parent.left == current) {
                    parent.left = current.left != null ? current.left : current;
                } else if (parent.right == current) {
                    parent.right = current.left != null ? current.left : current;
                }
                break;
            }
        }
    }

    public int getMinValue() {
        if (left == null) {
            return value;
        } else {
            return left.getMinValue();
        }
    }

    public static void main(String[] args) {
        var tree = new BinarySearchTree(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(15);
        tree.insert(14);
        tree.insert(13);

        tree.remove(10);
    }

}