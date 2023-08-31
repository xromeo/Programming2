package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 Given a string, remove characters until the string is made up of any two alternating characters. When you choose a character to remove, all instances of that character must be removed. Determine the longest string possible that contains just two alternating letters.

Example

s = abaacdabd

Delete a, to leave bcdbd. Now, remove the character c to leave the valid string bdbd with a length of 4. Removing either b or d at any point would not result in a valid string. Return 4.

Given a string s, convert it to the longest possible string t made up only of alternating characters. Return the length of string t. If no string t can be formed, return 0. 
 
 */

public class TwoCharacters {

    public static int alternate2(String s) {

        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            characters.add(s.charAt(i));
        }

        Object[] uniques = characters.toArray();
        int max = 0;
        for (int i = 0; i < uniques.length; i++) {
            for (int j = i + 1; j < uniques.length; j++) {
                String aux = s;
                for (int k = 0; k < uniques.length; k++) {
                    if (i != k && j != k) {
                        aux = aux.replace(String.valueOf(uniques[k]), "");
                    }
                }
                int maxS = 0;
                if (aux.length() >= 2) {
                    Character c1 = aux.charAt(0);
                    Character c2 = aux.charAt(1);
                    if (c1 != c2) {
                        maxS = aux.length();
                        for (int k = 2; k < aux.length(); k++) {
                            if (k % 2 == 0) {
                                if (aux.charAt(k) != c1) {
                                    maxS = 0;
                                    break;
                                }
                            } else {
                                if (aux.charAt(k) != c2) {
                                    maxS = 0;
                                    break;
                                }
                            }
                        }

                    }
                }
                max = Math.max(max, maxS);
            }
        }

        return max;
    }

    public static int alternate(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();
        int maxLength = 0;

        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        for (char char1 : uniqueChars) {
            for (char char2 : uniqueChars) {
                if (char1 != char2) {
                    StringBuilder validString = new StringBuilder();
                    for (char c : s.toCharArray()) {
                        if (c == char1 || c == char2) {
                            validString.append(c);
                        }
                    }
                    if (isAlternating(validString.toString()) && validString.length() > maxLength) {
                        maxLength = validString.length();
                    }
                }
            }
        }

        return maxLength;
    }

    public static boolean isAlternating(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }





    public static void main(String[] args) {

        System.out.println(alternate("abaacdabd")); // 4
        System.out.println(alternate("beabeefeab")); // 5
        System.out.println(alternate("bea")); // 2
        System.out.println(alternate("abea")); // 3
        System.out.println(alternate("aea")); // 3
        System.out.println(alternate("ea")); // 2
    }
}
