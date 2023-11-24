package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramHR {

    public static int anagram(String s) {
        if (s.length() % 2 != 0) {
            // If the length is odd, it's not possible to split into equal substrings
            return -1;
        }

        int mid = s.length() / 2;
        String s1 = s.substring(0, mid);
        String s2 = s.substring(mid);

        Map<Character, Integer> charCount = new HashMap<>();

        // Count characters in the first substring
        for (char c : s1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Subtract characters in the second substring
        for (char c : s2.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) - 1);
        }

        // Count the total changes needed
        int changes = 0;
        for (int count : charCount.values()) {
            changes += Math.abs(count);
        }

        // The minimum number of changes is half of the total changes
        return changes / 2;
    
    }

}
