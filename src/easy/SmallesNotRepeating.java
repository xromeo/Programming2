package easy;
/*
 * Given an integer n returns the smallest integer greater than n that does not contain two identical consecutive digits

 * 
 */
public class SmallesNotRepeating {


public int solution(int N) {
    int n = N + 1;
    boolean hasRepeatedDigits = true;
    while (hasRepeatedDigits) {
        hasRepeatedDigits = false;
        String nString = Integer.toString(n);
        for (int i = 0; i < nString.length() - 1; i++) {
            if (nString.charAt(i) == nString.charAt(i + 1)) {
                hasRepeatedDigits = true;
                break;
            }
        }
        if (hasRepeatedDigits) {
            n++;
        }
    }
    return n;
}

    public static void main(String[] args) {
        System.out.println(new SmallesNotRepeating().solution(1765));
        System.out.println(new SmallesNotRepeating().solution(55));
        System.out.println(new SmallesNotRepeating().solution(44432));
        System.out.println(new SmallesNotRepeating().solution(3298));
        System.out.println(new SmallesNotRepeating().solution(1000000000));
    }
}
