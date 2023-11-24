package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * 
 Max Min


You will be given a list of integers, arr, and a single integer k. You must create an array of length k from elements of arr such that its unfairness is minimized. Call that array arr. Unfair calculated as

max(arr')-min(arr')

Where:

- max denotes the largest integer in arr'. 
- min denotes the smallest integer in arr'.

Example

arr = [1,4,7,2] k=2

Pick any two elements, say arr = [4,7]. 
unfairness max(4,7)-min(4,7)=7-4-3 
Testing for all pairs, the solution [1, 2] provides the minimum unfairness.

Note: Integers in arr may not be unique.

Function Description

Complete the maxMin function in the editor below.

maxMin has the following parameter(s):

int k: the number of elements to select

int arr[n]:: an array of integers

Returns

int: the minimum possible unfairness

Input Format

The first line contains an integer n, the number of elements in array arr. 
The second line contains an integer k.

Each of the next n lines contains an integer arr[i] where 0 <= i < n

Constraints

2≤ n ≤ 10

2≤ k ≤n
0 <= arr[i] <= 10⁹

Sample Input

Sample Input #01

10
4
1
2
3
4
10
20
30
40
100
200
Sample Output

Sample Output #01

3
Explanation

Explanation #01
Here ; selecting the  integers , unfairness equals

max(1,2,3,4) - min(1,2,3,4) = 4 - 1 = 3

To solve this problem, you can follow these steps:

Sort the array arr in ascending order.
Initialize a variable minUnfairness with a very large value.
Iterate over the sorted array and select a subarray of length k. Calculate the unfairness for each subarray.
Keep track of the minimum unfairness encountered during the iteration.
Return the minimum unfairness as the result.
 * 
 */

public class MaxMin {

    public static int maxMin(int k, List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
       

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.size() -  k + 1; i++) {
            int unfairness = arr.get(k - 1 + i) - arr.get(i);
            min = Math.min(min, unfairness);
        }
        return min;       

    }

    public static void main(String[] args) {
        // System.out.println(maxMin(2, Arrays.asList(1,4,7,2)));
        // System.out.println(maxMin(4, Arrays.asList(1,2,3,4,10,20,30,40,100,200)));

       List<Integer> asList = Arrays.asList(7652,
1377,
7089,
2736,
4748,
1615,
4235,
3461,
3895,
8328,
175,
8131,
4877,
5606,
4730,
3563,
2210,
966,
7842,
9551,
152,
9079,
5366,
2158,
1236,
8046,
2660,
5528,
544,
6965,
2428,
8197,
4694,
5869,
7285,
5794,
3837,
1521,
9255,
4084,
9849,
5782,
2215,
4726,
1388,
3297,
4641,
9950,
615,
8836,
5853,
768,
4267,
1219,
9278,
5503,
9265,
8290,
7383,
6162,
5255,
6163,
711,
6301,
2033,
7996,
2095,
2222,
9517,
7702,
6306,
5718,
3484,
4873,
6797,
1224,
8170,
1438,
1175,
8785,
274,
3380,
5905,
4541,
4600,
5183,
6396,
3865,
3473,
3780,
27,
5080,
9943,
738,
7733,
8328,
5087,
9828,
550,
4604);
    System.out.println(maxMin(25, asList)); // 1563



        
    }

}
