package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BreadthFirstSearch
 */
public class BreadthFirstSearch {

    public static void breadthFirstSearch(Node root) {
        Node current = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            current = queue.poll();
            result.add(current.data);
            System.out.println(current.data);
            queue.addAll(current.children);
        }
    }

    public static void main(String[] args) {
        Node K = new Node("K");
        Node I = new Node("I");
        Node J = new Node("J");
        Node E = new Node("E");
        Node H = new Node("H");
        Node C = new Node("C");
        Node G = new Node("G");
        G.addChild(K);
        Node F = new Node("F");
        F.addChild(I);
        F.addChild(J);
        Node D = new Node("D");
        D.addChild(G);
        D.addChild(H);
        Node B = new Node("B");
        B.addChild(E);
        B.addChild(F);
        Node A = new Node("A");
        A.addChild(B);
        A.addChild(C);
        A.addChild(D);

        breadthFirstSearch(A);

    }

    static class Node {
        String data;
        List<Node> children;

        public Node(String value) {
            this.data = value;
            this.children = new ArrayList<>();
        }

        public void addChild(Node node) {
            this.children.add(node);
        }

    }
}