package medium;

import java.math.BigInteger;

/*
 * The factorial of a number is defined as the product of all natural numbers up to that number. For example, factorial of 5 or 5! is 1 x 2 x 3 x 4 x 5 = 120.

Extra long factorials are factorials of numbers greater than 20. They can be very big with an order of magnitude greater than 2^64 which can not be stored even in long long data types in C or C++. Modern languages like Python and JavaScript can easily store them.
 */

public class ExtraLongFactorials {
    public static void extraLongFactorials(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        System.out.println(result);
    }

    public static void extraLongFactorials2(int n) {
        int[] number = new int[500];

        number[0] = 1;
        int number_size = 1;

        for (int i = 2; i <= n; i++) {
            number_size = multiply(number, i, number_size);
        }

        for (int i = number_size - 1; i >= 0; i--) {
            System.out.print(number[i]);
        }
        System.out.println();

    }

    private static int multiply(int[] number, int m, int size) {
        int carry = 0;

        for (int i = 0; i < size; i++) {
            int prod = number[i] * m + carry;
            number[i] = prod % 10;
            carry = prod / 10;
        }

        while(carry > 0){
            number[size] = carry % 10;
            carry = carry / 10;
            size ++;
        }

        return size;
    }

    public static void main(String[] args) {
        extraLongFactorials(100);
        extraLongFactorials2(100);
    }
}
