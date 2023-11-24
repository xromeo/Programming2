package hard;
/*
 * There is a given list of strings where each string contains only lowercase letters from a-j, inclusive. The set of strings is said to be a GOOD SET if no string is a prefix of another string. In this case, print GOOD SET. Otherwise, print BAD SET on the first line followed by the string being checked.

Note If two strings are identical, they are prefixes of each other.

Example

words = ['abcd', 'bcd', 'abcde', 'bcde']

Here 'abcd' is a prefix of 'abcde' and 'bcd' is a prefix of 'bcde'. Since 'abcde' is tested first, print

BAD SET  
abcde

words = ['ab', 'bc', 'cd'].

No string is a prefix of another so print

GOOD SET 


Function Description
Complete the noPrefix function in the editor below.

noPrefix has the following parameter(s):
- string words[n]: an array of strings

Prints
- string(s): either GOOD SET or BAD SET on one line followed by the word on the next line. No return value is expected.

Input Format
First line contains n, the size of words[].
Then next n lines each contain a string, words[i].

Constraints
1<= n <= 10⁵
 1 <= the length of words[i] <= 60 
All letters in word[i] are in the range 'a' through 'j', inclusive.

Sample Input00

STDIN       Function
-----       --------
7            words[] size n = 7
aab          words = ['aab', 'defgab', 'abcde', 'aabcde', 'bbbbbbbbbb', 'jabjjjad']
defgab  
abcde
aabcde
cedaaa
bbbbbbbbbb
jabjjjad
Sample Output00

BAD SET
aabcde
Explanation
'aab' is prefix of 'aabcde' so it is a BAD SET and fails at string 'aabcde'.

Sample Input01

4
aab
aac
aacghgh
aabghgh
Sample Output01

BAD SET
aacghgh
Explanation
'aab' is a prefix of 'aabghgh', and aac' is prefix of 'aacghgh'. The set is a BAD SET. 'aacghgh' is tested before 'aabghgh', so and it fails at 'aacghgh'.

 * 
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoPrefixSet {

    public static void noPrefix(List<String> words) {
        boolean isGoodSet = checkPrefix(words);
        if (isGoodSet) {
            System.out.println("GOOD SET");
        }

    }
    
    private static boolean checkPrefix(List<String> words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            if (!insertWord(root, word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return false;
            }
        }
        return true;
    }

    private static boolean insertWord(TrieNode root, String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            if (currentNode.isEndOfWord) {
                return false;  // Prefix found
            }

            if (currentNode.children.containsKey(ch)) {
                currentNode = currentNode.children.get(ch);
            } else {
                TrieNode newNode = new TrieNode();
                currentNode.children.put(ch, newNode);
                currentNode = newNode;
            }
        }

        if(currentNode.isEndOfWord){
            return false;
        }

        currentNode.isEndOfWord = true;

        // Check if the current word is a prefix of another word
        return currentNode.children.isEmpty();
    }



    private static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
    
    public static void main(String[] args) {

        noPrefix(Arrays.asList("a", "a"));
        noPrefix(Arrays.asList("hola", "omarlene", "podemos", "lograrlo","omar"));
        noPrefix(Arrays.asList("hola", "omarlene", "podemos", "lograrlo"));
    }

}
