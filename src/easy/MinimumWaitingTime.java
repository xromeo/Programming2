package easy;
import java.util.Arrays;

/**
 * MinimumWaitingTime
 */
public class MinimumWaitingTime {

    int minimumWaitingTime(int[] array) {
        Arrays.sort(array);

        int time = 0;
        int total = 0;
        for (int i = 1; i < array.length; i++) {
            time += array[i - 1];
            total += time;
        }
        return total;

    }

    int minimumWaitingTime2(int[] array) {
        Arrays.sort(array);
        
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            int time = array.length - i - 1;
            total += array[i] * time;
        }
        return total;

    }

    public static void main(String[] args) {
        MinimumWaitingTime minimumWaitingTime = new MinimumWaitingTime();
        var r = minimumWaitingTime.minimumWaitingTime(new int[] { 3, 2, 1, 2, 6 });
        System.out.println(r);
        var r2 = minimumWaitingTime.minimumWaitingTime2(new int[] { 3, 2, 1, 2, 6 });
        System.out.println(r2);
    }
}