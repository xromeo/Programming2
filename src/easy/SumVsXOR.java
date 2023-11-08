package easy;

/*

Given an integer n, find each x such that:

0<=x<=n
n + x = n XOR x

where XOR denotes the bitwise XOR operator. Return the number of x's satisfying the criteria.

Example 
n = 4
4 + 0 = 4 XOR 0 = 4
4 + 1 = 4 XOR 1 = 5
4 + 2 = 4 XOR 2 = 6
4 + 3 = 4 XOR 3 = 7

There are four values that meet the criteria:
return 4








public static long sumXor(long n) {        
// Since (n + x)=(n OR X)=(n XOR x) except when both bits are 1
//      n   b   n OR b n XOR b n AND b
//      ---------------------------
//      0   0    0       0        0
//      0   1    1       1        0
//      1   0    1       1        0
//      1   1    1       0  <---  1
// 
// The strategy is to only consider when (n OR x) = (n XOR x), 
// and that only occurs when (n AND b) == 0
// The way we do that is to loop through all bits and drop the 
// right bit (right shift) in very iteration (n>>1). We count how 
// many times the condition (n AND 1) == 0 is met.
// Finally we rise the counter to power of 2 to obtain the result. 
// Why power of 2? Because we have 2 possible combination for 
// every bit of n.
//  

	int counter = 0;
	while(n > 0) {
	if ((n & 1) == 0) // count only when n|x == n^x
 counter++;
n = n >> 1; //drop right-most digit 
	          //(cut the number in half)
	}
	return 1l << counter; //a nice way to rise a number to power of 2

}

 */

public class SumVsXOR {

    

    public static long sumXor(long n) {
        int counter = 0;
        while (n > 0) {
            if ((n & 1) == 0){ // count only when n|x == n^x
                counter++;
            }
            n = n >> 1; // drop right-most digit
                        // (cut the number in half)
        }
        return 1l << counter; // a nice way to rise a number to power of 2

    }


    public static long sumXor2(long n) {
        long zeros = Long.toBinaryString(n).length() - Long.bitCount(n);
        return (n > 0) ? 1L << zeros : 1;
    }

    public static void main(String[] args) {
        System.out.println(sumXor(5));

    }
}
