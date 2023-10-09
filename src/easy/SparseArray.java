package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * There is a collection of input strings and a collection of query strings. For each query string, determine how many times it occurs in the list of input strings. Return an array of the results.

Example

strings = ["ab", "ab", "abc"]
queries = ["ab", "abc", "bc"]

There are 2 instances of ab, 1 of abc and 0 of bc. For each query, add an element to the return array, results = [2, 1, 0].

Function Description

Complete the function matchingStrings in the editor below. The function must return an array of integers representing the frequency of occurrence of each query string in strings.

matchingStrings has the following parameters:

string strings[n] - an array of strings to search
string queries[q] - an array of query strings
Returns

int[q]: an array of results for each query
 */

public class SparseArray {

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String string : strings) {
            int value = frequency.getOrDefault(string, 0);
            frequency.put(string, ++value);
        }        

        List<Integer> results = new ArrayList<>();

        for (String query : queries) {
            results.add(frequency.getOrDefault(query, 0));
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(matchingStrings(List.of("ab", "ab", "abc"), List.of("ab", "abc", "bc")));
    }

}
