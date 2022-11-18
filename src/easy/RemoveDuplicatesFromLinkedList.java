package easy;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import linkedList.LinkedList;
import linkedList.Node;

public class RemoveDuplicatesFromLinkedList {

    void removeDuplicates(Node<Integer> head) {
        Set<Integer> set = new HashSet<>();
        if (Objects.isNull(head)) {
            return;
        }
        Node<Integer> node = head;
        set.add(node.getData());
        Node<Integer> next = head.getNext();
        while (Objects.nonNull(next)) {
            if (set.contains(next.getData())) {
                node.setNext(next.getNext());
                next = next.getNext();
            } else {
                set.add(next.getData());
                node = next;
                next = next.getNext();
            }
        }
    }

    // for an ascending ordered list
    void removeDuplicates2(Node<Integer> head) {

        Node<Integer> currentNode = head;
        while (Objects.nonNull(currentNode)) {
            Node<Integer> nextDistinctNode = currentNode.getNext();
            while (Objects.nonNull(nextDistinctNode) && nextDistinctNode.getData().equals(head.getData())) {
               nextDistinctNode = nextDistinctNode.getNext();
            }
            currentNode.setNext(nextDistinctNode);
            currentNode = nextDistinctNode;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertLast(2);
        linkedList.insertLast(3);
        linkedList.print();

        System.out.println("s1:" + linkedList.size());
        var remove = new RemoveDuplicatesFromLinkedList();
        remove.removeDuplicates(linkedList.getHead());
        linkedList.print();

        System.out.println("s1:" + linkedList.size());

        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.insertFirst(1);
        linkedList2.insertFirst(3);
        
        linkedList2.insertFirst(2);
        linkedList2.insertFirst(3);
        
        linkedList2.insertLast(2);
        linkedList2.insertLast(3);
        System.out.println("s2:" + linkedList2.size());
        linkedList2.print();
        remove.removeDuplicates2(linkedList2.getHead());
        System.out.println("s2:" + linkedList2.size());
        linkedList2.print();

    }
}
