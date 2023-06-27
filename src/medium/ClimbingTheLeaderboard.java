package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * An arcade game player wants to climb to the top of the leaderboard and track
 * their ranking. The game uses Dense Ranking, so its leaderboard works like
 * this:
 * 
 * The player with the highest score is ranked number on the leaderboard.
 * Players who have equal scores receive the same ranking number, and the next
 * player(s) receive the immediately following ranking number.
 * Example
 * 
 * ranked=[100, 90, 90, 80]
 * 
 * player = [70, 80, 105]
 * 
 * The ranked players will have ranks 1, 2 , 2 , and 3, respectively. If the
 * player’s scores are 70, 80 and 105, their rankings after each game are 4th,
 * 3rd and 1st. Return [4, 3, 1].
 * 
 * Function Description
 * 
 * Complete the climbingLeaderboard function in the editor below.
 * 
 * climbingLeaderboard has the following parameter(s):
 * 
 * int ranked[n]: the leaderboard scores
 * int player[m]: the player’s scores
 * 
 * The existing leaderboard, ranked, is in descending order.
 * The player's scores, player, are in ascending order.
 */

public class ClimbingTheLeaderboard {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> leaderboard = new ArrayList<>();
        List<Integer> distinctRanked = getDistinctRanks(ranked);
        int n = distinctRanked.size();
        int m = player.size();
        int j = n - 1; 

        for (int i = 0; i < m; i++) {
            while (j >= 0 && player.get(i) >= distinctRanked.get(j)) {
                j--;
            }
            leaderboard.add(j + 2);
        }

        return leaderboard;
    }
    
    private static List<Integer> getDistinctRanks(List<Integer> ranked) {
        List<Integer> distinctRanks = new ArrayList<>();
        for (int i = 0; i < ranked.size(); i++) {
            if (i == 0 || !ranked.get(i).equals(ranked.get(i - 1))) {
                distinctRanks.add(ranked.get(i));
            }
        }
        return distinctRanks;
    }

    public static void main(String[] args) {
        //List<Integer> rankedScores = List.of(100, 90, 90, 80);
        //List<Integer> playerScores = List.of(70, 75, 105, 110);

        // List<Integer> rankedScores = List.of(100, 90, 90, 80, 75, 60);
        // List<Integer> playerScores = List.of(50, 65, 77, 90, 102);
        
        List<Integer> rankedScores = List.of(100, 100, 50, 40, 20, 10);
        List<Integer> playerScores = List.of(5, 25, 50, 120);

        List<Integer> result = climbingLeaderboard(rankedScores, playerScores);

        System.out.println("Rankings del jugador:");
        for (int rank : result) {
            System.out.println(rank);
        }
    }
}
