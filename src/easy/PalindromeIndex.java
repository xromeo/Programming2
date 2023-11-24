package easy;

/*
 Given a string of lowercase letters in the range ascii[a-z], determine the index of a character that can be removed to make the string a palindrome. There may be more than one solution, but any will do. If the word is already a palindrome or there is no solution, return -1. Otherwise, return the index of a character to remove.

Example
s = abc

Either remove 'b' at index 0 or 'c' at index 3.

Function Description

Complete the palindromeIndex function in the editor below.

palindromeIndex has the following parameter(s):

string s: a string to analyze
Returns

int: the index of the character to remove or  -1
Input Format

The first line contains an integer q, the number of queries.
Each of the next q lines contains a query string s.
 */

public class PalindromeIndex {

    // Note: all strings are almost() palindrome or are palindrome

    private static int palindromeIndex2(String s) {
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                if (isPalindrome(s.substring(0, i) + s.substring(i + 1))) {
                    return i;
                } else {
                    return n - 1 - i;
                }
            }
        }

        return -1;
    }

    public static int palindromeIndex(String s) {
        // Write your code here
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                String ss = s.substring(0, start) + s.substring(start + 1);
                if (isPalindrome(ss)) {
                    return start;
                } else {
                    return end;
                }
            }
            start++;
            end--;
        }

        return -1;

    }

    private static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        System.out.println(palindromeIndex("cwnssnwcw"));
        System.out.println(palindromeIndex2("cwnssnwcw"));

        System.out.println(palindromeIndex("aaab"));
        System.out.println(palindromeIndex2("aaab"));
    }

}
