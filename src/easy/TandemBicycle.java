package easy;
import java.util.Arrays;
import java.util.Collections;

public class TandemBicycle {

    int tandemBicycle(Integer[] redShirtSpeeds, Integer[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        if (fastest) {
            Arrays.sort(blueShirtSpeeds, Collections.reverseOrder());
        } else {
            
            Arrays.sort(blueShirtSpeeds);
        }
        int sum = 0;
        for (int i = 0; i < blueShirtSpeeds.length; i++) {
            int max = Math.max(blueShirtSpeeds[i], redShirtSpeeds[i]);
            sum += max;
        }

        return sum;
    }

    public static void main(String[] args) {
        Integer[] redShirtSpeeds = new Integer[]{5,5,3,9,2};
        Integer[] blueShirtSpeeds = new Integer[]{3,6,7,2,1};
        var tandemBicycle = new TandemBicycle();
        System.out.println(tandemBicycle.tandemBicycle(redShirtSpeeds, blueShirtSpeeds, true));
        System.out.println(tandemBicycle.tandemBicycle(redShirtSpeeds, blueShirtSpeeds, false));
    }
}
