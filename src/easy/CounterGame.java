package easy;

/*
 * Louise and Richard have developed a numbers game. They pick a number and check to see if it is a power of 2. If it is, they divide it by 2. If not, they reduce it by the next lower number which is a power of 2. Whoever reduces the number to 1 wins the game. Louise always starts.

Given an initial value, determine who wins the game.

Example
n = 132
It's Louise's turn first. She determines that  is not a power of 132. The next lower power of 2 is 128, so she subtracts that from 132 and passes 4 to Richard. 4 is a power of 2, so Richard divides it by 2 and passes 2 to Louise. Likewise, 2 is a power so she divides it by 2 and reaches 2. She wins the game.

Update If they initially set counter to 1, Richard wins. Louise cannot make a move so she loses.

Function Description

Complete the counterGame function in the editor below.

counterGame has the following parameter(s):

int n: the initial game counter value
Returns

string: either Richard or Louise

 */
public class CounterGame {

    public static String counterGame(long n) {

        int turn = 0;
        while (n > 1) {

            if ((n & (n - 1)) == 0) {
                n = n >> 1;
            } else {
                n = n - Long.highestOneBit(n);
            }
            turn = 1 - turn;
        }
        return turn == 0 ? "Richard" : "Louise";

    }

    public static void main(String[] args) {
        System.out.println(counterGame(132L)); // Louise
        System.out.println(counterGame(6L)); // Richard
        System.out.println(counterGame(1L)); // Richard
    }
}
