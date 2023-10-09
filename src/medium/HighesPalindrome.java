package medium;

/*
 * Palindromes are strings that read the same from the left or right, for example madam or 0110.

You will be given a string representation of a number and a maximum number of changes you can make. Alter the string, one digit at a time, to create the string representation of the largest number possible given the limit to the number of changes. The length of the string may not be altered, so you must consider 0's left of all higher digits in your tests. For example 0110 is valid, 0011 is not.

Given a string representing the starting number, and a maximum number of changes allowed, create the largest palindromic string of digits possible or the string '-1' if it is not possible to create a palindrome under the contstraints.

Example
s='1231'
k=3
Make 3 replacements to get 9339.
s=12321
k=1

Make 1 replacement to get 12921.

Function Description

Complete the highestValuePalindrome function in the editor below.

highestValuePalindrome has the following parameter(s):

string s: a string representation of an integer
int n: the length of the integer string
int k: the maximum number of changes allowed
Returns

string: a string representation of the highest value achievable or -1

Sample Input 0

STDIN   Function
-----   --------
4 1     n = 4, k = 1
3943    s = '3943'
Sample Output 0

3993
Sample Input 1

6 3
092282
Sample Output 1

992299
Sample Input 2

4 1
0011
Sample Output 2

-1
 */

public class HighesPalindrome {

    public static String highestValuePalindrome(String s, int n, int k) {

        char[] arr = s.toCharArray();
        int left = 0;
        int right = n - 1;
        int changes = 0;

        while (left < right) {
            if (arr[left] != arr[right]) {
                char maxChar = (char) Math.max(arr[left], arr[right]);
                arr[left] = maxChar;
                arr[right] = maxChar;
                changes++;
            }
            left++;
            right--;
        }

        if (changes > k) {
            return "-1"; 
        }

        left = 0;
        right = n - 1;
        while (left <= right) {
            if (left == right) {
                if (k - changes > 0) {
                    arr[left] = '9';
                }
            } else {
                if (arr[left] < '9') {
                    if (k - changes >= 2 && arr[left] == s.charAt(left) && arr[right] == s.charAt(right)) {
                        
                        arr[left] = '9';
                        arr[right] = '9';
                        changes += 2;
                    } else if (k - changes >= 1 && s.charAt(left) != s.charAt(right)) {
                        
                        arr[left] = '9';
                        arr[right] = '9';
                        changes++;
                    }
                }
            }
            left++;
            right--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {

        System.out.println(highestValuePalindrome("12321", 5, 1)); // 12921 *
        System.out.println(highestValuePalindrome("092282", 6, 3)); // 992299 *
        System.out.println(highestValuePalindrome("932239", 6, 2)); // 992299

        System.out.println(highestValuePalindrome("1231", 4, 3)); // 9339
        System.out.println(highestValuePalindrome("3943", 4, 1)); // 3993
        System.out.println(highestValuePalindrome("092282", 6, 3)); // 992299
        System.out.println(highestValuePalindrome("0011", 4, 1)); // -1
    }
}
