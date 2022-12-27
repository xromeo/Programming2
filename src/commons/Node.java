package commons;

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

    public Integer getData() {
		return data;
	}
    public Node getLeft() {
		return left;
	}
    public Node getRight() {
		return right;
	}
    
    public void setData(Integer data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
