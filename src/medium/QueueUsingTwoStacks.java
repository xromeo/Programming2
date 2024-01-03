package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest) is always the first one to be removed.

A basic queue has the following operations:

Enqueue: add a new element to the end of the queue.
Dequeue: remove the element from the front of the queue and return it.
In this challenge, you must first implement a queue using two stacks. Then process q queries, where each query is one of the following 3 types:

1 x: Enqueue element x into the end of the queue.
2: Dequeue the element at the front of the queue.
3: Print the element at the front of the queue.
 */
public class QueueUsingTwoStacks {

    public static void main(String[] args) throws IOException {

        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        List<String> queries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queries.add(br.readLine().trim());
        }

        for (String query : queries) {
            if (query.equals("2")) {
                int queueLength = stack1.size();
                for (int i = 0; i < queueLength; i++) {
                    String lastElement = stack1.get(stack1.size() - 1);
                    stack1.remove(lastElement);
                    stack2.add(lastElement);
                }
                stack2.remove(0);
            }

            else if (query.equals("3")) {
                System.out.println(stack2.get(0));
            }

            else if (query.charAt(0) == '1') {
                String[] queryArray = query.split(" ");
                int value = Integer.parseInt(queryArray[1]);

                int queueLength = stack1.size();
                for (int i = 0; i < queueLength; i++) {
                    String lastElement = stack1.get(stack1.size() - 1);
                    stack1.remove(lastElement);
                    stack2.add(lastElement);
                }
                stack2.add(String.valueOf(value));
            }

        }

    }
}
