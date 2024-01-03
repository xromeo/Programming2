package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 You are a waiter at a party. There is a pile of numbered plates. Create an empty answers array. At each iteration, i, remove each plate from the top of the stack in order. Determine if the number on the plate is evenly divisible ith the  prime number. If it is, stack it in pile Bi. Otherwise, stack it in stack Ai. Store the values Bi in  from top to bottom in answers. In the next iteration, do the same with the values in stack . Once the required number of iterations is complete, store the remaining values in Ai  in answers , again from top to bottom. Return the answers  array.


Function Description

Complete the waiter function in the editor below.

waiter has the following parameters:

int number[n]: the numbers on the plates
int q: the number of iterations
Returns

int[n]: the numbers on the plates after processing
Input Format

The first line contains two space separated integers, n and q.
The next line contains n space separated integers representing the initial pile of plates, i.e., A.

 */

public class Waiter {


    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Stack<Integer>> stacks = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        Stack<Integer> initialStack = new Stack<>();
        initialStack.addAll(number);

        for (int i = 0; i < q; i++) {
            int prime = getNthPrime(i + 1);
            Stack<Integer> A = new Stack<>();
            Stack<Integer> B = new Stack<>();

            while (!initialStack.isEmpty()) {
                int current = initialStack.pop();

                if (current % prime == 0) {
                    B.push(current);
                } else {
                    A.push(current);
                }
            }

            while (!B.isEmpty()) {
                result.add(B.pop());
            }

            stacks.add(A);
            initialStack = A;
        }

        while (!initialStack.isEmpty()) {
            result.add(initialStack.pop());
        }

        return result;
    }

    private static int getNthPrime(int n) {
        int count = 0;
        int num = 2;

        while (count < n) {
            if (isPrime(num)) {
                count++;
            }

            if (count < n) {
                num++;
            }
        }

        return num;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<Integer> number = List.of(3, 4, 7, 6, 5);
        int q = 1;

        List<Integer> result = waiter(number, q);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
