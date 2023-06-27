package tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    public List<Node<T>> children;
    public T data;
    public Node(T data) {
        this.children = new ArrayList<>();
        this.data = data;
    }

    public void addChild(T data){
        this.children.add(new Node<T>(data));
    }

    public void addChild(Node<T> node){
        this.children.add(node);
    }
}
