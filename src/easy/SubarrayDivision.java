package easy;

import java.util.List;

/*
 * Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.

Lily decides to share a contiguous segment of the bar selected such that:

The length of the segment matches Ron's birth month, and,
The sum of the integers on the squares is equal to his birth day.
Determine how many ways she can divide the chocolate.

Example
s = [2,2,1,3,2]
d = 4
m = 2


Lily wants to find segments summing to Ron's birth day, d = 4 with a length equalling his birth month, m = 2. In this case, there are two segments meeting her criteria: [2,2] and [1,3].

Function Description

birthday has the following parameter(s):

int s[n]: the numbers on each of the squares of chocolate
int d: Ron's birth day
int m: Ron's birth month
Returns

int: the number of ways the bar can be divided
*/

public class SubarrayDivision {
    public static int birthday(List<Integer> s, int d, int m) {
        int i = 0;
        int r = 0;
        int sg = 0;
        int c = 0;
        int n = s.size();
        if (n == 1 && s.get(0) == d && m == 1) {
            return 1;
        }

        while (r <= n - 1) {
            while (r - i < m) {
                sg += s.get(r);
                r++;
            }
            if (sg == d) {
                c++;
            }
            sg -= s.get(i);
            i++;
        }
        return c;
    }

    public static int birthday2(List<Integer> s, int d, int m) {
        
        int r = m - 1;
        int c = 0;
        int n = s.size();

        int sum = 0;
        for (int i = 0; i < m - 1; i++) {
            sum += s.get(i);
        }
        int i = 0;
        while (r < n) {
            sum += s.get(r);
            r++;

            if (sum == d) {
                c++;
            }
            sum -= s.get(i);
            i++;
        }
        return c;
    }

    
    public static void main(String[] args) {

        List<Integer> s = List.of(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1);
        int d = 18;
        int m = 7;
        
        System.out.println(birthday2(s, d, m));

        s = List.of(2, 2, 1, 3, 1);
        d = 4;
        m = 2;
        System.out.println(birthday2(s, d, m));
    }
}
