package easy;
import java.util.Objects;

import binarytree.Node;

public class ClosestValueInBinaryTree {

    int findClosestValue(Node node, int target, int closest) {
        if (Objects.isNull(node)) {
            return closest;
        }
        if (Math.abs(target - closest) > Math.abs(target - node.getData())) {
            closest = node.getData();
        }
        if (target < node.getData()) {
            return findClosestValue(node.getLeft(), target, closest);
        } else if (target > node.getData()) {
            return findClosestValue(node.getRight(), target, closest);
        } else {
            return closest;
        }
    }

    int findClosestValue2(Node node, int target, int closest) {
        Node current = node;
        while (Objects.nonNull(current)) {            
            if (Math.abs(target - closest) > Math.abs(target - current.getData())) {
                closest = current.getData();
            }
            if (target < current.getData()) {
                current = current.getLeft();
            } else if (target > current.getData()) {
                current = current.getRight();
            } else {
                break;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.insert(5);
        node.insert(15);
        node.insert(4);
        node.insert(13);
        node.insert(12);
        node.insert(2);
        node.insert(7);
        node.insert(5);

        var closest = new ClosestValueInBinaryTree().findClosestValue(node, 14, Integer.MAX_VALUE);
        System.out.println(closest);
        var closest2 = new ClosestValueInBinaryTree().findClosestValue2(node, 14, Integer.MAX_VALUE);
        System.out.println(closest2);
    }
}
