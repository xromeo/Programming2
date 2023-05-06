package medium;

//*** codelity no validated

/*
 * Let us consider an infinite sequence of stacks indexed from 0, and an exchange operation that removes two tokens from a stack and adds one token to the next stack.
For example, lets assume there are two tokens on stack 0 and three on stack 1 . Two tokens from stack 0 may be exchanged for one new token on stack 1. After that operation, there are four tokens on stack 1 that may be exchanged for two new tokens on stack 2. Fianlly, a new token may be added to the stack 3  by exchanging two tokens fro stack 2. This gives us: stacks 0, 1 and 2 empty, and stack 3 with one token.
Given the heigths of first N stacks, find the minimum number of tokens that may remain after any number of exchange operations. You may asume that all of tokens are identical. All uninitialized stacks are empty by default.
Write a function :
class Solution { public int solution(int[] A){} }
that, given an array A of N integers, representing the heights of the first N stacks in the sequence, return s the minimum number of tokens wich may remain on the stacks after any number of exchange operations
 * 
 */

public class TokenStackExchange {

    public int solution(int[] A) {
        int n = A.length;
        int result = 0;
        int exchange = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] + exchange == 1) {
                result++;
            } else {
                if ((A[i] + exchange) % 2 == 1) {
                    result++;
                }
                exchange = (A[i] + exchange)  / 2;
            }
        }
        while (exchange > 0) {
            if (exchange % 2 == 1) {
                result++;
            }
            exchange = exchange / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TokenStackExchange().solution(new int[] { 2, 3 })); // 1
        System.out.println(new TokenStackExchange().solution(new int[] { 5 })); // 2
        System.out.println(new TokenStackExchange().solution(new int[] { 4, 0, 3, 0 })); // 1
        System.out.println(new TokenStackExchange().solution(new int[] { 1, 0, 4, 1 })); // 3
        System.out.println(new TokenStackExchange().solution(new int[] { 0, 1, 7 })); // 4
        System.out.println(new TokenStackExchange().solution(new int[] { 0, 1, 19 })); // 4
        System.out.println(new TokenStackExchange().solution(new int[] { 0, 1, 1001 })); // 8
    }
}
