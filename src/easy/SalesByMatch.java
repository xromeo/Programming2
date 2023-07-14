package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SalesByMatch {

    public static int sockMerchant(int n, List<Integer> ar) {
        Set<Integer> frequencies = new HashSet<>();
        int count = 0;

        for (Integer v : ar) {
            if (frequencies.contains(v)) {
                frequencies.remove(v);
                count++;
            } else {
                frequencies.add(v);
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(sockMerchant(9, Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20)));
        System.out.println(sockMerchant(7, Arrays.asList(1, 2, 1, 2, 1, 3, 2)));
    }
}
