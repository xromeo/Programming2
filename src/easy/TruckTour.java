package easy;

import java.util.List;

/*
 Suppose there is a circle. There are N petrol pumps on that circle. Petrol pumps are numbered 0 to (N-1)(both inclusive). You have two pieces of information corresponding to each of the petrol pump: (1) the amount of petrol that particular petrol pump will give, and (2) the distance from that petrol pump to the next petrol pump.

Initially, you have a tank of infinite capacity carrying no petrol. You can start the tour at any of the petrol pumps. Calculate the first point from where the truck will be able to complete the circle. Consider that the truck will stop at each of the petrol pumps. The truck will move one kilometer for each litre of the petrol.
 */
public class TruckTour {
    public static int truckTour(List<List<Integer>> petrolpumps) {
        // Write your code here
        int petrol = 0;
        int start = 0;
        int total = 0;
        for (int i = 0; i < petrolpumps.size(); i++) {
            int p = petrolpumps.get(i).get(0);
            int d = petrolpumps.get(i).get(1);
            petrol += p - d;
            total += p - d;
            if (petrol < 0) {
                petrol = 0;
                start = i + 1;
            }
        }
        if (total > 0) {
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(truckTour(List.of(
                List.of(1, 5),
                List.of(10, 3),
                List.of(3, 4))));
    }
}
