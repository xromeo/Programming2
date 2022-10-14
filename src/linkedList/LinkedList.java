package linkedList;

import java.util.Objects;

public class LinkedList<T> {
    private Node<T> head;

    public Node<T> getHead() {
		return head;
	}

	public LinkedList() {
        this.head = null;
    }

    public void insertFirst(T data) {
        Node<T> node = new Node<T>(data, this.head);
        this.head = node;
    }

    public void insertLast(T data) {
        Node<T> node = new Node<T>(data, null);
        if (Objects.isNull(head)) {
            this.head = node;
            return;
        }
        Node<T> last = head;
        while (Objects.nonNull(last.getNext())) {
            last = last.getNext();
        }
        last.setNext(node);

    }

    public int size() {
        int c = 0;
        Node<T> node = head;
        while (Objects.nonNull(node)) {
            c++;
            node = node.getNext();
        }
        return c;
    }

    public Node<T> getFirst() {
        return this.head;
    }

    public void print() {
        Node<T> node = head;
        while(Objects.nonNull(node)){
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertFirst("Hola");
        linkedList.insertFirst("Zoe");
        linkedList.insertLast("Rivera");
        linkedList.insertLast("Rivera");
        linkedList.print();

        System.out.println("s1:" + linkedList.size());
        LinkedList<String> linkedList2 = new LinkedList<>();
        linkedList2.insertLast("Rivera");
        System.out.println("s2:" + linkedList2.size());
        linkedList2.print();

    }
}
