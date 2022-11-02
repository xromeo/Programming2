package binaryTree;

import java.util.Objects;

public class Node {
    Integer data;  
	Node left;
	Node right;
 
	public Node(Integer data) {
        this.data = data;
    }

    public void insert(Integer data) {
        if (data < this.data && Objects.nonNull(this.left)) {
            this.left.insert(data);
        } else if (data < this.data) {
            this.left = new Node(data);
        } else if (data > this.data && Objects.nonNull(this.right)) {
            this.right.insert(data);
        } else if (data > this.data) {
            this.right = new Node(data);
        }

    }

    Node contain(Integer data) {
        if (this.data==data) {
            return this;
        }
        if (this.data < data && Objects.nonNull(this.right)) {
            return this.right.contain(data);
        }
        if (this.data > data && Objects.nonNull(this.left)) {
            return this.left.contain(data);
        }
        return null;
    }

    boolean validate(Node node, Node min, Node max){
        if(Objects.nonNull(max) && node.data > max.data){
            return false;
        }
        if(Objects.nonNull(min) && node.data < min.data){
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

    public Integer getData() {
		return data;
	}
    public Node getLeft() {
		return left;
	}
    public Node getRight() {
		return right;
	}
    
    public static void main(String[] args) {
        Node root = new Node(7);
        root.insert(5);
        root.insert(4);
        root.insert(6);
        root.insert(2);
        root.insert(10);
        root.insert(-1);
        root.insert(0);
        root.insert(11);

        var node = root.contain(11);
        if (Objects.nonNull(node)) {
            System.out.println(node.data);
        }

       
            System.out.println("result:" + root.validate(root, null, null));
        
    }
}
