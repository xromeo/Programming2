package easy;

/**
 * FlippingBits
 * 
 * You will be given a list of 32 bit unsigned integers. Flip all the bits ( 1 -> 0 and 0 -> 1) and return the result as an unsigned integer.

Example
n = 9 (Base 10)
9 (Base 10) = 1001 (Base 2). We're working with 32 bits, so:
00000000000000000000000000001001 (Base 2) = 9 (Base 10)
11111111111111111111111111110110 (Base 2) = 4294967286 (Base 10)

Return 4294967286.

Function Description

Complete the flippingBits function in the editor below.

flippingBits has the following parameter(s):

int n: an integer
Returns

int: the unsigned decimal integer result
Input Format

The first line of the input contains , the number of queries.
Each of the next  lines contain an integer, , to process.

Constraints

1<= q <= 100
0<= n < 2³2


Sample Input

3 
2147483647 
1 
0
Sample Output

2147483648 
4294967294 
4294967295
Explanation

Take 1 for example, as unsigned 32-bits is 00000000000000000000000000000001 and doing the flipping we get 11111111111111111111111111111110 which in turn is 4294967294.
 */
public class FlippingBits {

    public static long flippingBits(long n) {

        // Basically, 2^32-1 is equal to 4294967295 So subtracting from that is the same as flipping the bits in the binary representation :)
        return 4294967295L - n;
    }


    public static long flippingBits3(long n) {

        // Define the mask where all bits are set to 1 (32 bits)
        long mask = (1L << 32) - 1;
        
        // XOR the input number with the mask to flip the bits
        return n ^ mask;
    }

    public static long flippingBits2(long n) {

        return ~(n | 0xFFFFFFFF00000000L) ;
        /*
         * Explanation:

Since we are only interested in the least significant 32 bits portion of the long, we want to find away to flip those bits and keep the higher order 32 bits as zero.

This is achieved by setting all higher order bits to 1, so that during the flip they can then be 0,

n | 0xFFFFFFFF00000000L
In the above we do a bitwise OR of the long n with the mask. And this sets the higher order bits of n to 1 and leaves the lower 32 bits ontouched.

Once this is achieved, we then do a bitwise flip using the ~ operator on the outcome of the above OR and presto!
         */
    }

    public static void main(String[] args) {

    }
}