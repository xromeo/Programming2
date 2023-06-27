package easy;

/**
 * 
You are choreographing a circus show with various animals. For one act, you are given two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).

The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump.
The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.
You have to figure out a way to get both kangaroos at the same location at the same time as part of the show. If it is possible, return YES, otherwise return NO.

Example

x1 = 2
v1 = 1
x2 = 1
v2 = 2

After one jump, they are both at x = 3, (x1 + v1 = 2 + 1, x2 + v2 = 1 + 2), so the answer is YES.

Sample Input 1

0 2 5 3
Sample Output 1

NO
Explanation 1

The second kangaroo has a starting location that is ahead (further to the right) of the first kangaroo's starting location (i.e., x2 > x1 ). Because the second kangaroo moves at a faster rate (meaning v2 > v1) and is already ahead of the first kangaroo, the first kangaroo will never be able to catch up. Thus, we print NO.



After one jump, they are both at , (, ), so the answer is YES.
 */

public class NumberLineJumps {

    public static String kangaroo(int x1, int v1, int x2, int v2) {

        if(x2 > x1 && v2 > v1){
            return "NO";
        }
        if(x1 > x2 && v1 > v2){
            return "NO";
        }
        if(x1 == x2 && v1 != v2){
            return "NO";
        }
        if(x1 == x2 && v1 == v2){
            return "YES";
        }
        if(v1 == v2){
            return "NO";
        }

        int k = (x1 - x2) % (v1 - v2);
        if(k == 0){
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        
  
        System.out.println(kangaroo(2, 1, 1, 2));
        System.out.println(kangaroo(0, 3, 4, 2));
        System.out.println(kangaroo(0, 2, 5, 3));

        System.out.println(kangaroo(0, 7, 4, 1));

        System.out.println(kangaroo(43, 2, 70, 2));

        var p = new Property();
        System.out.println(p.abc() + ", " + p.xyz());


    }

}
