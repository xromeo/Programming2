package medium;

/**
 * In information theory, linguistics, and computer science, the Levenshtein
 * distance is a string metric for measuring the difference between two
 * sequences. Informally, the Levenshtein distance between two words is the
 * minimum number of single-character edits (insertions, deletions or
 * substitutions) required to change one word into the other. It is named after
 * the Soviet mathematician Vladimir Levenshtein, who considered this distance
 * in 1965.
 * 
 * 
 * str1 = "abc"
 * str2 = "yabd"
 * 
 * 
 * Dynamic Programming
 * 
 *      "" y a b d
 *    "" 0 1 2 3 4
 * E = a 1 1 1 2 3
 *   | b 2 2 2 1 2
 *   | c 3 3 3 2 2 <-
 * 
 * if(str1[r-1] == str2[c-1]) : E[r][c] = E[r-1][c-1]
 * else E[r][c] = 1 + min(E[r][c-1], E[r-1][c], E[r-1][c-1])
 * 
 * Time O(N x M)
 * Space O(N x M)
 * 
 * | Space = O(min (N,M))
 */

public class LevenshteinDistance {

    public static int levenshteinDistance(String str1, String str2) {
        int[][] edits = new int[str2.length() + 1][str1.length() + 1];
        for (int i = 0; i < str2.length() + 1; i++) {
            for (int j = 0; j < str1.length() + 1; j++) {
                edits[i][j] = j;
            }
            edits[i][0] = i;
        }
        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = 1 + Math.min(edits[i - 1][j - 1], Math.min(edits[i - 1][j], edits[i][j - 1]));
                }
            }
        }
        return edits[str2.length()][str1.length()];
    }

    public static void main(String[] args) {
        String string1 = "abc";
        String string2 = "yabd";
        System.out.println(levenshteinDistance(string1, string2));

    }

}
