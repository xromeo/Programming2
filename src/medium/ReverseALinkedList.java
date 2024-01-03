package medium;

import medium.MergeTwoSortedLinkedList.SinglyLinkedList;

/*
 * Given the pointer to the head node of a linked list, change the next pointers of the nodes so that their order is reversed. The head pointer given may be null meaning that the initial list is empty.

Example
 head references the list  1 -> 2 -> 3 -> null

Manipulate the next pointers of each node in place and return head, now referencing the head of the list 3 -> 2 -> 1 -> null.

Function Description

Complete the reverse function in the editor below.

reverse has the following parameter:

SinglyLinkedListNode pointer head: a reference to the head of a list
Returns

SinglyLinkedListNode pointer: a reference to the head of the reversed list
 */

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

public class ReverseALinkedList {
    public static SinglyLinkedListNode reverse2(SinglyLinkedListNode llist) {

        SinglyLinkedListNode head = llist;
        SinglyLinkedListNode previous = null;

        while (llist != null) {

            head = new SinglyLinkedListNode(llist.data);
            head.next = previous;
            previous = head;
            llist = llist.next;

        }
        return head;

    }


    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode previous = null;
        SinglyLinkedListNode current = llist;
        
        while (current != null) {
            SinglyLinkedListNode next = current.next;
            current.next = previous;
            previous = current;            
            current = next;
        }        
        
        return previous;
    
    }

    public static void main(String[] args) {
        SinglyLinkedListNode n1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode n2 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode n3 = new SinglyLinkedListNode(3);
        n1.next = n2;
        n2.next = n3;

        reverse(n1);
    }
}
