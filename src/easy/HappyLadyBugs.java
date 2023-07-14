package easy;

/*
 * Happy Ladybugs is a board game having the following properties:

The board is represented by a string, b, of length n. The ith character of the string,b[i] , denotes ith the cell of the board.

If b[i] is an underscore (i.e., _), it means the ith cell of the board is empty.

If b[i] is an uppercase English alphabetic letter (ascii[A-Z]), it means the ith cell contains a ladybug of color b[i].
String b will not contain any other characters.

A ladybug is happy only when its left or right adjacent cell (i.e.,b[i+1] ) is occupied by another ladybug having the same color.

In a single move, you can move a ladybug from its current position to any empty cell.

Given the values of n and b for games of Happy Ladybugs, determine if it’s possible to make all the ladybugs happy. For each game, print YES on a new line if all the ladybugs can be made happy through some number of moves. Otherwise, print NO.

As an example,b=[YYR_B_BR] . You can move the rightmost B and R to make b=[YYRRBB_] and all the ladybugs are happy.

Function Description

Complete the happyLadybugs function in the editor below. It should return an array of strings, either ‘YES’ or ‘NO’, one for each test string.

happyLadybugs has the following parameters:

b: an array of strings that represents the initial positions and colors of the ladybugs

Input Format

The first line contains an integer g, the number of games.

The next g pairs of lines are in the following format:

The first line contains an integer n, the number of cells on the board.
The second line contains a string b describing the n cells of the board.
Constraints

Output Format

For each game, print YES on a new line if it is possible to make all the ladybugs happy. Otherwise, print NO.

Sample Input 0

4
7
RBY_YBR
6
X_Y__X
2
__
6
B_RRBR
Sample Output 0

YES
NO
YES
YES
 */

public class HappyLadyBugs {

    private static String happyLadybugs(String b) {
        int frequencies[] = new int[26];
        boolean underscore = false;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) != '_'){
                frequencies[b.charAt(i) - 'A']++;
            } else {
                underscore = true;
            }

        }
        for (int i : frequencies) {
            if (i == 1)
                return "NO";
        }
        if (!underscore) {
            for (int i = 1; i < b.length() - 1; i++) {
                if (b.charAt(i) != b.charAt(i - 1) && b.charAt(i) != b.charAt(i + 1)) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static void main(String[] args) {

        // System.out.println(happyLadybugs("RBY_YBR"));
        // System.out.println(happyLadybugs("X_Y__X"));
        // System.out.println(happyLadybugs("__"));
        // System.out.println(happyLadybugs("_"));
        // System.out.println(happyLadybugs("B_RRBR"));

        // System.out.println(happyLadybugs("_"));
        // System.out.println(happyLadybugs("RBRB"));
        // System.out.println(happyLadybugs("RRRR"));
        // System.out.println(happyLadybugs("BBB"));
        // System.out.println(happyLadybugs("BBB_"));

        System.out.println(happyLadybugs("G"));
        System.out.println(happyLadybugs("GR"));
        System.out.println(happyLadybugs("_GR_"));
        System.out.println(happyLadybugs("_R_G_"));
        System.out.println(happyLadybugs("R_R_R"));
        System.out.println(happyLadybugs("RRGGBBXX"));
        System.out.println(happyLadybugs("RRGGBBXY"));
    }

}
