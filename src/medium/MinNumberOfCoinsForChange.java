/**
Given a value V, if we want to make a change for V cents, and we have an infinite supply of each of C = { C1, C2, .., Cm} valued coins, what is the minimum number of coins to make the change? If it’s not possible to make a change, print -1.

Examples:  

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required We can use one coin of 25 cents and one of 5 cents 

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required We can use one coin of 6 cents and 1 coin of 5 cents


This problem is a variation of the problem discussed Coin Change Problem. Here instead of finding the total number of possible solutions, we need to find the solution with the minimum number of coins.



*/

package medium;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

    public int minNumberOfCoinsForChange(int[] coins, int amount) {

        int[] numOfCoins = new int[amount + 1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);

        numOfCoins[0] = 0;

        for (int coin : coins) {
            for (int value = 0; value < amount + 1; value++) {
                if (coin <= value) {
                    if (numOfCoins[value - coin] == Integer.MAX_VALUE) {
                        numOfCoins[value] = Math.min(numOfCoins[value], numOfCoins[value - coin]);
                    } else {
                        numOfCoins[value] = Math.min(numOfCoins[value], numOfCoins[value - coin] + 1);

                    }
                }
            }
        }
        return numOfCoins[amount] != Integer.MAX_VALUE ? numOfCoins[amount] : -1;
    }

    public static void main(String[] args) {

        int[] coins = { 2, 4, 6 };
        System.out.println(new MinNumberOfCoinsForChange().minNumberOfCoinsForChange(coins, 6));
        System.out.println(new MinNumberOfCoinsForChange().minNumberOfCoinsForChange(coins, 0));
        System.out.println(new MinNumberOfCoinsForChange().minNumberOfCoinsForChange(coins, 7));
    }
}
