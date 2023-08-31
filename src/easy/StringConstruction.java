package easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringConstruction {

    public static int stringConstruction(String s) {
        Set<Character> letters = new HashSet<>();

        int cost = 0;

        for (char character : s.toCharArray()) {
            if (!letters.contains(character)) {
                letters.add(character);
                cost++;
            }
        }

        return cost;
    }

    public static int stringConstruction3(String s) {
        Set<Character> p = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            p.add(s.charAt(i));
        }
        int cost = p.size();
        return cost;
    }

    public static int stringConstruction2(String s) {
        return new HashSet<>(List.of(s.split(""))).size();
    }

    public static void main(String[] args) {

        System.out.println(stringConstruction("abcd"));
        System.out.println(stringConstruction("abab"));
    }

}
