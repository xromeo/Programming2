import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FlippingMatrix
 */
public class FlippingMatrix {

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int sum = 0;
        int size = matrix.size();
        for (int i = 0; i < size/2; i++) {
            for (int j = 0; j < size/2; j++) {
                sum += Math.max( matrix.get(i).get(j), 
                    Math.max( matrix.get(i).get(size-1-j),
                    Math.max( matrix.get(size-1-i).get(j), 
                        matrix.get(size-1-i).get(size-1-j))
                    )  
                );
            }            
        }
        return sum;
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(112,42,83,119,4,3));
        matrix.add(Arrays.asList(56,125,56,49,2,1));
        matrix.add(Arrays.asList(15,78,101,43,5,0));
        matrix.add(Arrays.asList(62,98,114,108,17,21));
        matrix.add(Arrays.asList(61,19,14,18,11,20));
        matrix.add(Arrays.asList(22,37,74,10,7,24));

        System.out.println(flippingMatrix(matrix));
    }
}