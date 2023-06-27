package easy;
import java.util.ArrayList;

import java.util.List;

public class ProductSum {
    int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    int productSum(List<Object> array, int multiplier) {
        int sum = 0;
        for (Object object : array) {
            if (object instanceof ArrayList) {
                @SuppressWarnings("unchecked")
                var list = (ArrayList<Object>) object;
                sum += productSum(list, multiplier + 1);
            } else {
                sum += (int) object;
            }
        }
        return sum * multiplier;
    }

    public static void main(String[] args) {
        List<Object> array = new ArrayList<>();

        array.add(5);
        array.add(2);
        List<Object> array2 = new ArrayList<>() {
            {
                add(7);
                add(-1);
            }
        };
        array.add(array2);
        array.add(3);

        List<Object> array3 = new ArrayList<>() {
            {
                add(-13);
                add(8);
            }
        };

        List<Object> array4 = new ArrayList<>() {
            {
                add(6);
                add(array3);
                add(4);
            }
        };

        array.add(array4);
        System.out.println(new ProductSum().productSum(array));
    }
}
