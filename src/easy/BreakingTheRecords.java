package easy;

/**
 * 
 * Maria plays college basketball and wants to go pro. Each season she maintains a record of her play. She tabulates the number of times she breaks her season record for most points and least points in a game. Points scored in the first game establish her record for the season, and she begins counting from there.

Example

scores = [12, 24, 10 24]

Scores are in the same order as the games played. She tabulates her results as follows:

                                     Count
    Game  Score  Minimum  Maximum   Min Max
     0      12     12       12       0   0
     1      24     12       24       0   1
     2      10     10       24       1   1
     3      24     10       24       1   1
Given the scores for a season, determine the number of times Maria breaks her records for most and least points scored during the season.

Function Description

Complete the breakingRecords function in the editor below.

breakingRecords has the following parameter(s):

int scores[n]: points scored per game
Returns

int[2]: An array with the numbers of times she broke her records. Index 0 is for breaking most points records, and index 1 is for breaking least points records.

Constraints

1 <= n <= 1000
0 <= scores[i] <= 10^8

Sample Input 0

9
10 5 20 20 4 5 2 25 1
Sample Output 0

2 4

 */

import java.util.Arrays;
import java.util.List;

public class BreakingTheRecords {

    public static List<Integer> breakingRecords(List<Integer> scores) {

        int best = Integer.MIN_VALUE;
        int worst = Integer.MAX_VALUE;

        int min = -1;
        int max = -1;

        for (int s : scores) {
            if (s > best) {
                best = s;
                max++;
            }
            if (s < worst) {
                worst = s;
                min++;
            }
        }
        
        return List.of(max, min);
    }

    public static void main(String[] args) {
        System.out.println((breakingRecords(Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1))));
        System.out.println(breakingRecords(Arrays.asList(12, 24,10,24)));
    }
}
