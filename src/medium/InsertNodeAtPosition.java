package medium;
/*
 Given the pointer to the head node of a linked list and an integer to insert at a certain position, create a new node with the given integer as its data attribute, insert this node at the desired position and return the head node.

A position of 0 indicates head, a position of 1 indicates one node away from the head and so on. The head pointer given may be null meaning that the initial list is empty.

Example
 head refers to the first node in the list 1 -> 2 -> 3
 data = 4
 position = 2

Insert a node at position 2 with data = 4. The new list is 1 -> 2 -> 4 -> 3

Function Description Complete the function insertNodeAtPosition in the editor below. It must return a reference to the head node of your finished list.

insertNodeAtPosition has the following parameters:

head: a SinglyLinkedListNode pointer to the head of the list
data: an integer value to insert as data in your new node
position: an integer position to insert the new node, zero based indexing

Returns

SinglyLinkedListNode pointer: a reference to the head of the revised list


 */



public class InsertNodeAtPosition {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {

        SinglyLinkedListNode h = llist;
        int c = 1;
        while (c < position) {
            h = h.next;
            c++;
        }

        SinglyLinkedListNode d = new SinglyLinkedListNode(data);
        d.next = h.next;
        h.next = d;
        return llist;
    }

    public static void main(String[] args) {
       SinglyLinkedListNode n1 = new SinglyLinkedListNode(1);
       SinglyLinkedListNode n2 = new SinglyLinkedListNode(2);
       SinglyLinkedListNode n3 = new SinglyLinkedListNode(3);
       n1.next = n2;
       n2.next = n3;

       insertNodeAtPosition(n1, 4, 2);
       
       
    }
}
