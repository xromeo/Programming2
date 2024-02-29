package medium;

import java.util.List;
import java.util.Stack;

/*
 You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they are all the same height, then return the height.

Example

h1 = [1,2,1,1]
h2 = [1,1,2]
h3 = [1,1]

     

There are [4,3] and 2 cylinders in the three stacks, with their heights in the three arrays. Remove the top 2 cylinders from h1 (heights = [1, 2]) and from h2 (heights = [1, 1]) so that the three stacks all are 2 units tall. Return 2 as the answer.

Note: An empty stack is still a stack.

Function Description

Complete the equalStacks function in the editor below.

equalStacks has the following parameters:

int h1[n1]: the first array of heights
int h2[n2]: the second array of heights
int h3[n3]: the third array of heights
Returns

int: the height of the stacks when they are equalized

Constraints

0 < n1, n2, n3 <= 10⁵
0 < height of any cylinder <= 100

 */
public class EqualStacks {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {

        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();
        Stack<Integer> C = new Stack<>();

        int hA = getHeight(h1, A);
        int hB = getHeight(h2, B);
        int hC = getHeight(h3, C);

        boolean equal = false;

        while (!equal) {
            int target = getTarget(hA, hB, hC);
            hA = equalizeStack(A, hA, target);
            hB = equalizeStack(B, hB, target);
            hC = equalizeStack(C, hC, target);
            if (hA == hB && hB == hC) {
                equal = true;
            }
        }

        return hA;

    }

    private static int equalizeStack(Stack<Integer> S, int height, int target) {
        while (height > target) {
            int h = S.pop();
            height -= h;
        }
        return height;
    }

    private static int getTarget(int hA, int hB, int hC) {
        return Math.min(hA, Math.min(hB, hC));
    }

    private static int getHeight(List<Integer> h1, Stack<Integer> A) {
        int n = h1.size();
        int height = 0;
        for (int i = 0; i < n; i++) {
            int h = h1.get(n - i - 1);
            height += h;
            A.push(h);
        }
        return height;
    }

    public static void main(String[] args) {
        System.out.println(equalStacks(List.of(3, 2, 1, 1, 1),
                List.of(4, 3, 2), 
                List.of(1, 1, 4, 1)));
    }
}
