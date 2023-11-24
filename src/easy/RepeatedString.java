package easy;

/*
There is a string, s, of lowercase English letters that is repeated infinitely many times. Given an integer, n, find and print the number of letter a's in the first n letters of the infinite string.

Example
s = 'abcac'
n = 10

The substring we consider is abcacabcac, the first 10 characters of the infinite string. There are 4 occurrences of a in the substring.
 */

public class RepeatedString {

    public static long repeatedString(String s, long n) {
     
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a'){
                count++;
            }
        }

        long c = n / s.length();
        long repeated = c * count;

        long remaining = n % s.length();

        for (int i = 0; i < remaining; i++) {
            if(s.charAt(i) == 'a'){
                repeated++;
            }
        }
        return repeated;
    }


    static long repeatedString2(String s, long n) {
        long count = s.chars().filter(ch -> ch == 'a').count();
        long c = n / s.length();
        long repeated = c * count;
        
        long remaining = n % s.length();
        repeated += s.substring(0, (int) remaining).chars().filter(ch -> ch == 'a').count();

        return repeated;
    }

    public static void main(String[] args) {

        System.out.println(repeatedString("abcac", 10));
        System.out.println(repeatedString("aba", 10));
        System.out.println(repeatedString("a", 1000000000000L));
                                                   
    }
}
