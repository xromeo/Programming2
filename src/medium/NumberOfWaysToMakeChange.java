/**
Given a variety of coin denominations existing in a currency system, find the total number of ways a given amount of money can be expressed using coins in that currency system.

Assume an infinite supply of coins of every denomination.

Example

input 
coins: [1, 2, 3],
amount: 3

Output:

3

The three ways are:

Use the coin with denomination 1 three times.
Use the coin with denomination 3 once.
Use the coin with denomination 2 once and coin with denomination 1 once.
Notes
Two ways are considered different if they use a different number of coins of any particular denomination.
Constraints:

1 <= total number of denominations <= 102
1 <= denomination of a coin <= 104
1 <= amount to be expressed <= 104

*/

package medium;

public class NumberOfWaysToMakeChange {

    public int numberOfWaysToMakeChange(int[] coins, int amount) {

        int[] ways = new int[amount + 1];

        ways[0] = 1;

        for (int coin : coins) {
            for (int value = 1; value < amount + 1; value++) {
                if (coin <= value) {
                    ways[value] = ways[value] + ways[value - coin];
                }
            }

        }

        return ways[amount];
    }

    public static void main(String[] args) {

        int[] coins = { 1, 5, 10, 25 };
        System.out.println(new NumberOfWaysToMakeChange().numberOfWaysToMakeChange(coins, 10));
        System.out.println(new NumberOfWaysToMakeChange().numberOfWaysToMakeChange(coins, 0));
    }
}
