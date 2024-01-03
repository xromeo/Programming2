package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * QueriesWithFixedLength
 * 
 * Consider an n-integer sequence, A= {a0, a1 ,...,an-1}. We perform a query on
 * A by using an integer, d, to calculate the result of the following
 * expression:
 * 
 * min (max aj )
 * 0<=i<=n-d i<=j<i+d
 * 
 * In other words, if we let mi = max(ai, ai+1, ai+2, ... , ai+d-1), then you
 * need to calculate min(m0, m1,..., mn-d).
 * 
 * Given arr and q queries, return a list of answers to each query.
 * 
 * Example
 * 
 * arr = [2, 3, 4, 5, 6] queries = [2, 3]
 * 
 * The first query uses all of the subarrays of length 2: [2, 3] [3, 4], [4, 5],
 * [5, 6] The maxima of the subarrays are [3, 4, 5, 6] The minimum of these is
 * 3.
 * 
 * The second query uses all of the subarrays of length 3: [2, 3, 4] [3, 4, 5],
 * [4, 5, 6]. The maxima of the subarrays are [4, 5, 6] The minimum of these is
 * 4.
 * 
 * Return [3, 4]
 * 
 * Function Description
 * 
 * Complete the solve function below.
 * 
 * solve has the following parameter(s):
 * 
 * • int arr[n] : an array of integers
 * 
 * int queries[q]: the lengths of subarrays to query
 * 
 * Returns
 * 
 * int [q] : the answers to each query
 */
public class QueriesWithFixedLength {

    // time O(n³) ->
    public static List<Integer> solve2(List<Integer> A, List<Integer> queries) {
        int n = A.size();
        List<Integer> answer = new ArrayList<>();
        for (Integer d : queries) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <= n - d; i++) {
                int max = 0;
                System.out.println("[");
                for (int j = i; j < i + d; j++) {
                    System.out.println("aj = " + A.get(j));
                    max = Math.max(A.get(j), max);
                }
                System.out.println("]");
                System.out.println("max = " + max);
                min = Math.min(max, min);
            }
            answer.add(min);
        }

        return answer;

    }

    public static List<Integer> solve(List<Integer> A, List<Integer> queries) {
        int n = A.size();
        List<Integer> answer = new ArrayList<>();
        for (Integer d : queries) {

            Deque<Integer> deque = new ArrayDeque<>();

            // Process the first window of size d
            for (int j = 0; j < d; j++) {
                while (!deque.isEmpty() && A.get(j) >= A.get(deque.peekLast())) {
                    deque.removeLast();
                }
                deque.addLast(j);
            }

            List<Integer> maxValues = new ArrayList<>();
            maxValues.add(A.get(deque.peekFirst()));

            // Process the rest of the windows
            for (int i = d; i < n; i++) {
                //This loop ensures that the elements at the front of the deque are within the current window.
                while (!deque.isEmpty() && deque.peekFirst() <= i - d) {
                    deque.removeFirst();
                }
                // This loop removes elements from the back of the deque that are smaller than the current element
                while (!deque.isEmpty() && A.get(i) >= A.get(deque.peekLast())) {
                    deque.removeLast();
                }
                deque.addLast(i);
                maxValues.add(A.get(deque.peekFirst()));
            }

            // Find the minimum of the max values
            int minMax = Integer.MAX_VALUE;
            for (int maxValue : maxValues) {
                minMax = Math.min(minMax, maxValue);
            }

            answer.add(minMax);
        }

        return answer;

    }

    public static void main(String[] args) {
        //System.out.println(solve(List.of(2, 3, 4, 5, 6), List.of(2, 3)));
        //System.out.println(solve(List.of(33, 11, 44, 11, 55), List.of(1, 2, 3, 4, 5)));
        System.out.println(solve(List.of(33, 11, 44, 11, 55), List.of(3)));
    }

}