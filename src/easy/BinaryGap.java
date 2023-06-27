package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary gap within a positive integer N is any maximal sequence of
 * consecutive zeros that is surrounded by ones at both ends in the binary
 * representation of N.
 * 
 * For example, number 9 has binary representation 1001 and contains a binary
 * gap of length 2. The number 529 has binary representation 1000010001 and
 * contains two binary gaps: one of length 4 and one of length 3. The number 20
 * has binary representation 10100 and contains one binary gap of length 1. The
 * number 15 has binary representation 1111 and has no binary gaps. The number
 * 32 has binary representation 100000 and has no binary gaps.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int N); }
 * 
 * that, given a positive integer N, returns the length of its longest binary
 * gap. The function should return 0 if N doesn't contain a binary gap.
 * 
 * For example, given N = 1041 the function should return 5, because N has
 * binary representation 10000010001 and so its longest binary gap is of length
 * 5. Given N = 32 the function should return 0, because N has binary
 * representation '100000' and thus no binary gaps.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..2,147,483,647].
 */

public class BinaryGap {
    public int solution(int N) {
        // Implement your solution here
        String binaryString = Integer.toBinaryString(N);

        int left = 0;
        int right = binaryString.length() - 1;

        left = findOneLeft(left, right, binaryString);
        right = findOneRight(left, right, binaryString);
        if (left == right) {
            return 0;
        }

        left++;
        int count = 0;
        int max = 0;
        while (left <= right) {
            if (binaryString.charAt(left) == '0') {
                left++;
                count++;
            } else {
                if (max < count) {
                    max = count;
                }
                left++;
                count = 0;
            }
        }

        return max;
    }

    private int findOneLeft(int left, int right, String binary) {
        while (left < right & left < binary.length() && binary.charAt(left) != '1') {
            left++;
        }
        return left;

    }

    private int findOneRight(int left, int right, String binary) {
        while (left < right && right > 0 && binary.charAt(right) != '1') {
            right--;
        }
        return right;
    }

    public int solution2(int N) {
        String binaryString = Integer.toBinaryString(N);

        int longestBinaryGap = 0;
        List<Integer> onesList = new ArrayList<>();

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '0')
                continue;
            onesList.add(i);
        }

        for (int i = 0; i < onesList.size() - 1; i++) {
            // subtract 1 so that don't count 1's next to each other as having any gap
            int indicesDiff = onesList.get(i + 1) - onesList.get(i) - 1;

            longestBinaryGap = Math.max(longestBinaryGap, indicesDiff);
        }
        return longestBinaryGap;
    }

    public static void main(String[] args) {

        System.out.println(new BinaryGap().solution2(1041));
        System.out.println(new BinaryGap().solution2(32));
        System.out.println(new BinaryGap().solution2(15));
        System.out.println(new BinaryGap().solution2(529));
        System.out.println(new BinaryGap().solution2(20));
    }
}
