package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * You are given a string s consisting of lowercase English letters and a list
 * of queries. Each query is an integer x. For each query, you need to determine
 * whether there exists a substring of string s whose characters have weights
 * that sum up to the query integer x.
 * 
 * The weight of a character is calculated as follows: 'a' has weight 1, 'b' has
 * weight 2, ..., and 'z' has weight 26. A uniform string is a string in which
 * every letter occurs a number of times that is a multiple of its weight.
 * 
 * Write a function that takes the string s and the list of queries, and returns
 * a list of strings. For each query, the corresponding element in the output
 * list should be either "Yes" if there exists a substring with the given
 * weight, or "No" otherwise.
 * 
 * Function Signature:
 * 
 * List<String> weightedUniformStrings(String s, List<Integer> queries)
 * Input:
 * 
 * s (1 <= |s| <= 10^5) is a string consisting of lowercase English letters.
 * queries is a list of integers (1 <= |queries| <= 10^7).
 * Output:
 * 
 * Return a list of strings, where each element is either "Yes" or "No".
 * 
 * Example:
 * 
 * s = "abccddde"
 * queries = [1, 3, 12, 5, 9]
 * Output: ["Yes", "Yes", "Yes", "Yes", "No"]
 * Please note that the above problem statement is a general outline of the
 * problem. Specific platforms or resources may have slightly different
 * variations of this problem with additional constraints, examples, and
 * instructions. If you're preparing for a coding interview or practicing on a
 * specific platform, I recommend referring to the problem statement provided by
 * that platform for the most accurate information.
 * 
 * 
 */

public class WeightedUniformStrings {
    static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        Set<Integer> weightedValues = new HashSet<>();
        char previousChar = '\0';
        int currentWeight = 0;

        for (char ch : s.toCharArray()) {
            if (ch == previousChar) {
                currentWeight += ch - 'a' + 1;
            } else {
                currentWeight = ch - 'a' + 1;
                previousChar = ch;
            }
            weightedValues.add(currentWeight);
        }

        List<String> result = new ArrayList<>();
        for (int query : queries) {
            if (weightedValues.contains(query)) {
                result.add("Yes");
            } else {
                result.add("No");
            }
        }
        return result;
    }

    

    public static void main(String[] args) {
        System.out.println(weightedUniformStrings("abbcccdddd", Arrays.asList(1, 7, 5, 4, 15)));
        System.out.println(weightedUniformStrings("abccddde", Arrays.asList(1, 3, 12, 5, 9, 10)));
        System.out.println(weightedUniformStrings("aaabbbbcccddd", Arrays.asList(9, 7, 8, 12, 5)));
    }

}
