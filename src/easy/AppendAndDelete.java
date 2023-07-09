package easy;
/*
 * You are given two strings, s and t, and an integer k. Your task is to determine if it's possible to convert string s to string t by performing the following operations:

Append: You can append any lowercase English alphabet to the end of string s.
Delete: You can delete any character from string s.
You need to find the minimum number of operations required to convert s to t. If it is possible to convert s to t within k operations, return "Yes"; otherwise, return "No".

Write a function appendAndDelete(s, t, k) that returns "Yes" or "No" based on whether the conversion is possible within k operations.

Input Format:

The first line of input contains the string s (1 <= |s| <= 100), where |s| represents the length of s.
The second line of input contains the string t (1 <= |t| <= 100), where |t| represents the length of t.
The third line of input contains an integer k (0 <= k <= 100).
Output Format:

Return "Yes" if it's possible to convert s to t within k operations; otherwise, return "No".
Sample Input:

s = "hacker"
t = "hackerrank"
k = 9
Sample Output:
Yes
Explanation:

In this example, we can perform the following operations to convert s to t within 9 operations:

Append 'r' to s, resulting in "hackerr".
Delete 'r' from s, resulting in "hacke".
Append 'a' to s, resulting in "hackea".
Append 'n' to s, resulting in "hackean".
Append 'k' to s, resulting in "hackeank".
Append 'e' to s, resulting in "hackeanke".
Append 'r' to s, resulting in "hackeanker".
Append 'r' to s, resulting in "hackeankerr".
Delete 'k' from s, resulting in "hackeankerr".
Thus, we can convert s to t within 9 operations, so the answer is "Yes".

 */
public class AppendAndDelete {

    public static String appendAndDelete(String s, String t, int k) {

        int n = s.length();
        int m = t.length();

        if (k > n + m) {
            return "Yes";
        }

        int i = 0;

        while (i < Math.min(m, n) && s.charAt(i) == t.charAt(i)) {
            i++;
        }

        k -= n - i;
        k -= m - i;
        if (k >= 0 && k % 2 == 0) {
            return "Yes";
        }

        return "No";
    }

    public static void main(String[] args) {
        System.out.println(appendAndDelete("abc", "abc", 7));
        System.out.println(appendAndDelete("abc", "zxs", 6));
        System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9));
        System.out.println(appendAndDelete("ashley", "ash", 2));
    }
}
