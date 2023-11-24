package medium;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

Example

s = mom

The list of all anagrammatic pairs is [m,m],[mo,om] at positions [[0],[2]] [[0,1],[1,2]] respectively.

Function Description

Complete the function sherlockAndAnagrams in the editor below.

sherlockAndAnagrams has the following parameter(s):

string s: a string
Returns

int: the number of unordered anagrammatic pairs of substrings in s
 */

public class SherlockAndAnagrams {

    public static int sherlockAndAnagrams(String s) {
        int result = 0;
        int n = s.length();

        HashMap<String, Integer> substringFrequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String substring = "";
            for (int j = i; j < n; j++) {
                substring = sortString(substring + s.charAt(j));
                substringFrequency.put(substring, substringFrequency.getOrDefault(substring, 0) + 1);
            }
        }

        for (int count : substringFrequency.values()) {

            result += (count * (count - 1)) / 2;
        }

        return result;
    }

    // C(n,k)= k!×(n)! n!​
    // Combinations of n taken by k. 
    // if k = 2 -> n*(n-1)/2

    public static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba"));// 4
        System.out.println(sherlockAndAnagrams("abcd"));// 0
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));// 3
        System.out.println(sherlockAndAnagrams("kkkk"));// 10

    }
}
