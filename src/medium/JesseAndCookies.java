package medium;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * JesseAndCookies
 */
public class JesseAndCookies {

    public static int cookies(int k, List<Integer> A) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.addAll(A);

        if (A.size() < 2) {
            return -1;
        }
        
        int count = 0;
        while (queue.size() > 1) {
            int previous = queue.poll();        
            int second = queue.poll();        

            if(previous >= k){
                return count; 
            }
           
            int newCookie = previous + 2 * second;
            System.out.println(previous + " + 2 x " + second + " = " + newCookie);
            queue.offer(newCookie);
            count++;
        }

        if(queue.peek() >= k){
            return count;
        }
        // Write your code here
        return -1;
    }

    public static void main(String[] args) {

       //System.out.println(cookies(9, List.of(2,7,3,6,4,6)));
       System.out.println(cookies(777, List.of(1,2,3,9,10,12)));
    }
}