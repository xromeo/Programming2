package tree;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    public List<String> depthFirstSearch(Node<String> node, List<String> array) {
        array.add(node.data);
        for (Node<String> child : node.children) {
            depthFirstSearch(child, array);
        }

        return array;
    }

    public static void main(String[] args) {
        Node<String> root = new Node<String>("A");

        Node<String> node1 = new Node<String>("B");
        Node<String> node2 = new Node<String>("C");
        Node<String> node3 = new Node<String>("D");
        root.addChild(node1);
        root.addChild(node2);
        root.addChild(node3);

        Node<String> node4 = new Node<String>("E");
        Node<String> node5 = new Node<String>("F");
        node1.addChild(node4);
        node1.addChild(node5);

        Node<String> node6 = new Node<String>("G");
        Node<String> node7 = new Node<String>("H");
        node3.addChild(node6);
        node3.addChild(node7);

        Node<String> node8 = new Node<String>("I");
        Node<String> node9 = new Node<String>("J");
        node5.addChild(node8);
        node5.addChild(node9);

        Node<String> node10 = new Node<String>("K");
        node6.addChild(node10);

        List<String> array = new ArrayList<>();

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.depthFirstSearch(root, array).stream().forEach(System.out::print);
    }
}
