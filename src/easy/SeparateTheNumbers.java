package easy;

/**
 * SeparateTheNumbers
 * 
 * 
A numeric string, s, is beautiful if it can be split into a sequence of two or more positive integers,a[1],a[2],…,a[n], , satisfying the following conditions:

a[i]-a[i-1]=1 for any 1<i<=n (i.e., each element in the sequence is 1 more than the previous element).
No a[i] contains a leading zero. For example, we can split s=10203 into the sequence {1,02,03}, but it is not beautiful because 02 and  03 have leading zeroes.
The contents of the sequence cannot be rearranged. For example, we can split s=312 into the sequence {3,1,2}, but it is not beautiful because it breaks our first constraint (i.e.,1-3!=1 ).

You must perform q queries where each query consists of some integer string s. For each query, print whether or not the string is beautiful on a new line. If it’s beautiful, print YES x, where x is the first number of the increasing sequence. If there are multiple such values of x, choose the smallest. Otherwise, print NO
 */
public class SeparateTheNumbers {

    public static void separateNumbers(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            String a = s.substring(0, i + 1);
            long x = Long.parseLong(a);
            StringBuilder expected = new StringBuilder(String.valueOf(a));
            while (expected.length() < s.length()) {
                expected.append(++x);
            }

            if (expected.toString().equals(s)) {
                System.out.println("YES " + a);
                return;
            }
        }
        System.out.println("NO");
    }

    public static void main(String[] args) {
        // separateNumbers("1234");
        // separateNumbers("91011");
        // separateNumbers("99100");
        // separateNumbers("101103");
        // separateNumbers("010203");
        // separateNumbers("13");
        // separateNumbers("1");

        // separateNumbers("99910001001");
        // separateNumbers("7891011");
        // separateNumbers("9899100");
        // separateNumbers("999100010001");

        separateNumbers("00000000000000000000000000000000");
        separateNumbers("11111111111111111111111111111111");
        separateNumbers("10001001100210031004100510061007");
    }
}