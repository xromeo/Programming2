package medium;

/*
 * Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.

Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:

It must be greater than the original word
It must be the smallest word that meets the first condition
Example

w = abcd

The next largest word is abdc.

Complete the function biggerIsGreater below to create and return the new string meeting the criteria. If it is not possible, return no answer.

Function Description

Complete the biggerIsGreater function in the editor below.

biggerIsGreater has the following parameter(s):

string w: a word
Returns
- string: the smallest lexicographically higher string possible or no answer

 w will contain only letters in the range ascii[a..z].
 */
public class BiggerIsGreater {
    public static String biggerIsGreater(String w) {

        char[] array = w.toCharArray();

        // Find the first character from the right that is smaller than its next
        // character

        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }
        // Find the smallest character that is greater than the character at index i
        if (i < 0) {
            return "no answer";
        }

        int j = array.length - 1;
        while (array[j] <= array[i]) {
            j--;
        }

        swap(array, i, j);

        // Reverse the substring starting from index i + 1 to get the smallest word
        reverse(array, i + 1, array.length - 1);

        return new String(array);
    }

    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        //String word = "abc";
        String word = "egfa";
        //String word = "dkhc";
        String nextWord = biggerIsGreater(word);
        System.out.println("Next word: " + nextWord);
    }
}
