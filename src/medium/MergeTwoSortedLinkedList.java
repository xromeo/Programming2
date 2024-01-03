package medium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 Given pointers to the heads of two sorted linked lists, merge them into a single, sorted linked list. Either head pointer may be null meaning that the corresponding list is empty.

Example
 head A refers to 1 -> 3 -> 7 -> null
 head B refers to 1 -> 2 -> null

The new list is 1 -> 1 -> 2 -> 3 -> 7 -> null

Function Description

Complete the mergeLists function in the editor below.

mergeLists has the following parameters:

SinglyLinkedListNode pointer headA: a reference to the head of a list
SinglyLinkedListNode pointer headB: a reference to the head of a list
Returns

SinglyLinkedListNode pointer: a reference to the head of the merged list
Input Format

The first line contains an integer t, the number of test cases.

The format for each test case is as follows:

The first line contains an integer n, the length of the first linked list.
The next n lines contain an integer each, the elements of the linked list.
The next line contains an integer m, the length of the second linked list.
The next m lines contain an integer each, the elements of the second linked list.
 */
public class MergeTwoSortedLinkedList {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
            throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     * int data;
     * SinglyLinkedListNode next;
     * }
     *
     */

    static SinglyLinkedListNode mergeLists2(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedList result = new SinglyLinkedList();

        while (head1 != null && head2 != null) {
            if (head1.data > head2.data) {
                result.insertNode(head2.data);
                head2 = head2.next;
            } else {
                result.insertNode(head1.data);
                head1 = head1.next;
            }
        }
        while (head1 != null) {
            result.insertNode(head1.data);
            head1 = head1.next;     
        }
        while (head2 != null) {
            result.insertNode(head2.data);
            head2 = head2.next;
        }
        return result.head;
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode merged = new SinglyLinkedListNode(0);
        SinglyLinkedListNode h1 = head1;
        SinglyLinkedListNode h2 = head2;
        SinglyLinkedListNode m = merged;
        
        while(h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                m.next = h1;
                h1 = h1.next;
            } else {
                m.next = h2;
                h2 = h2.next;
            }
            m = m.next;
        }
                
        if (h1 != null) m.next = h1;        
        if (h2 != null) m.next = h2;
        
        return merged.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        SinglyLinkedList llist1 = new SinglyLinkedList();
        llist1.insertNode(1);
        llist1.insertNode(2);
        llist1.insertNode(3);
        
        SinglyLinkedList llist2 = new SinglyLinkedList();
        llist2.insertNode(3);
        llist2.insertNode(4);
        
        SinglyLinkedListNode merged = mergeLists(llist1.head, llist2.head);


        printSinglyLinkedList(merged, " ", bufferedWriter);

        bufferedWriter.close();
    }
}
