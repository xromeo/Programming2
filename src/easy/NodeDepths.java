package easy;
import java.util.Objects;
import java.util.Stack;

import binaryTree.Level;
import binaryTree.Node;

public class NodeDepths {

    int nodeDepth(Node root) {
        int sum = 0;
        Stack<Level> stack = new Stack<>();
        stack.add(new Level(root, 0));
        while (stack.size() > 0) {
            Level top = stack.pop();
            Node node = top.node;
            int depth = top.depth;

            if (Objects.isNull(node)) {
                continue;
            }
            sum+=depth;
            stack.add(new Level(node.getLeft(), depth + 1));
            stack.add(new Level(node.getRight(), depth + 1));
        }
        return sum;
    }

    int nodeDepth(Node node, int depth) {
        if (Objects.isNull(node)) {
            return 0;
        }

        return depth + nodeDepth(node.getLeft(), depth + 1) + nodeDepth(node.getRight(), depth + 1);
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

        NodeDepths depths = new NodeDepths();

        System.out.println(depths.nodeDepth(node, 0));
        System.out.println(depths.nodeDepth(node));

    }

}
