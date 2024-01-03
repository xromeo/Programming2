package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * SherlockAndTheValidString
 * 
 * Sherlock considers a string to be valid if all characters of the string
 * appear the same number of times. It is also valid if he can remove just 1
 * character at 1 index in the string, and the remaining characters will occur
 * the same number of times. Given a string s, determine if it is valid. If so,
 * return YES, otherwise return NO.
 * 
 * Example
 * 
 * s= abc
 * 
 * This is a valid string because frequencies are {a:1, b:1, c:1}.
 * 
 * s=abcc
 * 
 * This is a valid string because we can remove one c and have 1 of each
 * character in the remaining string.
 * 
 * s = abccc
 * 
 * This string is not valid as we can only remove 1 occurrence of c. That leaves
 * character frequencies of {a:1, b:1, c:2}.
 * 
 * Function Description
 * 
 * Complete the isValid function in the editor below.
 * 
 * isValid has the following parameter(s):
 * 
 * string s: a string
 * Returns
 * 
 * string: either YES or NO
 * Input Format
 * 
 * A single string s.
 * 
 * Constraints
 * 1<= |s| <= 10⁵
 * Each character s[i] E ascii[a-z]
 * Sample Input 0
 * aabbcd
 * Sample Output 0
 * NO
 * Explanation 0
 * 
 * Given s=aabbcd, we would need to remove two characters, both c and d -> aabb
 * or a and b -> abcd, to make it valid. We are limited to removing only one
 * character, so s is invalid.
 * 
 * 
 */
public class SherlockAndTheValidString {

    static String isValid(String s) {
        // Count the frequency of each character
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Count the frequencies of the frequencies (meta, right?)
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int count : charCount.values()) {
            freqCount.put(count, freqCount.getOrDefault(count, 0) + 1);
        }

        // If there is only one distinct frequency, it's already valid
        if (freqCount.size() == 1) {
            return "YES";
        }

        // If there are two distinct frequencies and one of them is 1, it's valid
        if (freqCount.size() == 2) {
            int freq1 = 0, freq2 = 0;
            for (int freq : freqCount.keySet()) {
                if (freq1 == 0) {
                    freq1 = freq;
                } else {
                    freq2 = freq;
                }
            }
            if ((freqCount.get(freq1) == 1 && (freq1 - 1 == freq2 || freq1 == 1)) ||
                    (freqCount.get(freq2) == 1 && (freq2 - 1 == freq1 || freq2 == 1))) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {

        System.out.println(isValid("aabbc")); // YES
        System.out.println(isValid("aaaabbcc")); // NO
        System.out.println(isValid("abababcccddd")); // YES
        System.out.println(isValid("abcdefghhgfedecba")); // YES
        System.out.println(isValid("aabbccddeefghi")); // NO
        System.out.println(isValid("aabbcd")); // NO
    }
}