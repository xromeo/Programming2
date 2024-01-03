package medium;

import java.util.concurrent.atomic.DoubleAccumulator;

/*
 Given the pointer to the head node of a doubly linked list, reverse the order of the nodes in place. That is, change the next and prev pointers of the nodes so that the direction of the list is reversed. Return a reference to the head node of the reversed list.

Note: The head node might be NULL to indicate that the list is empty.

Function Description

Complete the reverse function in the editor below.

reverse has the following parameter(s):

DoublyLinkedListNode head: a reference to the head of a DoublyLinkedList
Returns
- DoublyLinkedListNode: a reference to the head of the reversed list
 */

class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
}

public class ReverseDoubleLinkedList {

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {

        DoublyLinkedListNode current = llist;
        DoublyLinkedListNode previous = null;
        while (current != null) {
            DoublyLinkedListNode next = current.next;
            current.next = previous;
            current.prev = next;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static void main(String[] args) {
        DoublyLinkedListNode n1 = new DoublyLinkedListNode(1);
        DoublyLinkedListNode n2 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode n3 = new DoublyLinkedListNode(3);
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;

        reverse(n1);

    }

}
