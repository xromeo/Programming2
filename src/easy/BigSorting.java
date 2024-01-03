package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 Consider an array of numeric strings where each string is a positive number with anywhere from 1 to 10⁶
digits. Sort the array's elements in non-decreasing, or ascending order of their integer values and return the
sorted array
Example
unsorted = ["1", "200", "150", "3"]
return the array ["1", "3", "150", "200"]

 */
public class BigSorting {

    public static List<String> bigSorting(List<String> unsorted) {
        Collections.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return StringAsIntegerCompare(a, b);
            }
        });

        return unsorted;

    }

    static int StringAsIntegerCompare(String s1, String s2) {
        if (s1.length() > s2.length())
            return 1;
        if (s1.length() < s2.length())
            return -1;
        for (int i = 0; i < s1.length(); i++) {
            if ((int) s1.charAt(i) > (int) s2.charAt(i))
                return 1;
            if ((int) s1.charAt(i) < (int) s2.charAt(i))
                return -1;
        }
        return 0;
    }

    public static List<String> bigSorting2(List<String> unsorted) {
        Collections.sort(unsorted, new StringLengthComparator());
        return unsorted;
    }

    static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return 1;
            } else if (s1.length() < s2.length()) {
                return -1;
            } else {
                return s1.compareTo(s2);
            }
        }
    }

    public static List<String> bigSorting3(List<String> unsorted) {
        Collections.sort(unsorted, Comparator.comparing(String::length).thenComparing(String::compareTo));

        return unsorted;

    }

    public static void main(String[] args) {
        System.out.println(bigSorting(new ArrayList<>(List.of("1", "200", "150", "3"))));
        System.out.println(bigSorting2(new ArrayList<>(List.of("1", "200", "150", "3"))));
    }
}
