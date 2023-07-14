package easy;

import java.util.List;

/*
You are the benevolent ruler of Rankhacker Castle, and today you're distributing bread. Your subjects are in a line, and some of them already have some loaves. Times are hard and your castle's food stocks are dwindling, so you must distribute as few loaves as possible according to the following rules:

Every time you give a loaf of bread to some person i, you must also give a loaf of bread to the person immediately in front of or behind them in the line (i.e., persons i+1 or i-1).
After all the bread is distributed, each person must have an even number of loaves.
Given the number of loaves already held by each citizen, find and print the minimum number of loaves you must distribute to satisfy the two rules above. If this is not possible, print NO

Sample Input 0

STDIN       Function
-----       --------
5           B[] size N = 5
2 3 4 5 6   B = [2, 3, 4, 5, 6]   
Sample Output 0

4
Explanation 0

The initial distribution is (2,3,4,5,6). The requirements can be met as follows:

Give 1 loaf of bread each to the second and third people so that the distribution becomes (2,4,5,5,6).
Give 1 loaf of bread each to the third and fourth people so that the distribution becomes (2,4,6,6,6).
Each of the N subjects has an even number of loaves after 4 loaves were distributed.

*/

public class FairRations {

    public static String fairRations(List<Integer> B) {

        int total = 0;
        int previous = -1;
        boolean even = true;
        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) % 2 == 1) {
                if (even) {
                    previous = i;
                    even = false;
                } else {
                    total += (i - previous) * 2;
                    even = true;
                }
            }
        }

        if (even) {
            return String.valueOf(total);
        }
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(fairRations(List.of(4, 5, 6, 7)));
        System.out.println(fairRations(List.of(2, 3, 4, 5, 6)));
        System.out.println(fairRations(List.of(1, 2)));
    }
}
