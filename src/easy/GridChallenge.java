package easy;

import java.util.Arrays;
import java.util.List;

/*
 * Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending. Determine if the columns are also in ascending alphabetical order, top to bottom. Return YES if they are or NO if they are not.

Example
grid = ['abc','ade','efg']

The grid is illustrated below.

a b c
a d e
e f g
The rows are already in alphabetical order. The columns a a e, b d f and c e g are also in alphabetical order, so the answer would be YES. Only elements within the same row can be rearranged. They cannot be moved to a different row.
 */
public class GridChallenge {

    public static String gridChallenge(List<String> grid) {

        char[] previous = grid.get(0).toCharArray();
        Arrays.sort(previous);

        for (int i = 1; i < grid.size(); i++) {

            char[] current = grid.get(i).toCharArray();
            Arrays.sort(current);

            for (int j = 0; j < current.length; j++) {
                if (previous[j] > current[j]) {
                    return "NO";
                }
            }
            previous = current;

        }
        return "YES";
    }

    public static void main(String[] args) {
        System.out.println(gridChallenge(Arrays.asList("abc", "ade", "efg")));
    }
}
