package easy;

import java.util.Arrays;
import java.util.List;

/**
 * There is a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2. The player must avoid the thunderheads. Determine the minimum number of jumps it will take to jump from the starting position to the last cloud. It is always possible to win the game.

For each game, you will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.

Example

c = [0,1,0,0,0,1,0]

Index the array from 0...6. The number on each cloud is its index in the list so the player must avoid the clouds at indices 1 and 5. They could follow these two paths: 0 -> 2 -> 4 -> 6 or 0 -> 2 -> 3 -> 4 -> 6. The first path takes 3 jumps while the second takes 4. Return 3.
 */

public class JumpingOnClouds2 {

    public static int jumpingOnClouds(List<Integer> c) {

        int n = c.size();
        int i = 0;

        int r = 0;

        while (i < n - 1) {

            if (i + 2 < n && c.get(i + 2) == 0) {
                i = i + 2;
            } else {
                i = i + 1;
            }
            r++;
        }

        return r;
    }

    public static void main(String[] args) {

        System.out.println(jumpingOnClouds(Arrays.asList(0,1,0,0,0,1,0))); // 3
        System.out.println(jumpingOnClouds(Arrays.asList(0,0,1,0,0,1,0))); // 4
        System.out.println(jumpingOnClouds(Arrays.asList(0,0,0,0,1,0))); // 3
    }

}
