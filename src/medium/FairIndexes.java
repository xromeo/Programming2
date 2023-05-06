package medium;
// Codelity 70% passesd ????
/*

 * You are given two arrays A and B consisting of N integers each.

Index K is named fair if the four sums (A[0] + ... + A[K-1]), (A[k] + ... + A[N-1]), (B[0] + ... + B[k-1]) and (B[K] + ... + B[N-1]) are all equal. In other words, K is the index where the two arrays, A and B, can be split (into two non-empty arrays each) in such a way that the sums of the resulting arrays' elements are equal.
 */


public class FairIndexes {
    
    public int solution(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        long sumLeftA = 0, sumRightB = 0;
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
            sumB += B[i];
        }        

        if(sumA != sumB){
            return result;
        }


        for (int i = 0; i < A.length; i++) {
            sumLeftA += A[i];
            sumRightB += B[i];
            if (sumLeftA == sumRightB && sumA - sumLeftA == sumLeftA) {
                result++;
            }
            
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] A  = new int[]{1,4,2,-2,5};
        //int[] B = new int[]{7,-2,-2, 2, 5};
        int[] A  = new int[]{0,4,-1,0,3};
        int[] B = new int[]{0,-2,5,0, 3};
        System.out.println(new FairIndexes().solution(A, B));
    }
}
