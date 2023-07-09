package easy;

import java.util.Arrays;
import java.util.List;

/*
 * Two friends Anna and Brian, are deciding how to split the bill at a dinner. Each will only pay for the items they consume. Brian gets the check and calculates Anna's portion. You must determine if his calculation is correct.

For example, assume the bill has the following prices: bill = [2,4,6]. Anna declines to eat item k=bill[2] which costs 6. If Brian calculates the bill correctly, Anna will pay (2+4)/2=3. If he includes the cost of bill[2], he will calculate (2+4+6)/2=6. In the second case, he should refund 3 to Anna.

Function Description

Complete the bonAppetit function in the editor below. It should print Bon Appetit if the bill is fairly split. Otherwise, it should print the integer amount of money that Brian owes Anna.

bonAppetit has the following parameter(s):

bill: an array of integers representing the cost of each item ordered
k: an integer representing the zero-based index of the item Anna doesn't eat
b: the amount of money that Anna contributed to the bill


The amount of money due Anna will always be an integer
 */

public class BillDivision {

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int s = 0;
        for (int i = 0; i < bill.size(); i++) {
            if (i != k) {
                s += bill.get(i);
            }
        }

        int actual = s / 2;
        if (b == actual) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - actual);
        }

    }

    public static void main(String[] args) {
        bonAppetit(Arrays.asList(3,10,2,9), 1, 12);
        bonAppetit(Arrays.asList(3,10,2,9), 1, 7);
    }

}
