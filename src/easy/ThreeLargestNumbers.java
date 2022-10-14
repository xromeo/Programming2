package easy;

import commons.Array;

public class ThreeLargestNumbers {

    int[] findThreeLargestNumbers(int[] array) {
        int[] threeLargest = new int[3];
        for (int value : array) {
            if (threeLargest[2] == 0 || value > threeLargest[2]) {
                shiftAndUpdate(threeLargest, value, 2);
            } else if (threeLargest[1] == 0 || value > threeLargest[1]) {
                shiftAndUpdate(threeLargest, value, 1);
            } else if (threeLargest[0] == 0 || value > threeLargest[0]) {
                shiftAndUpdate(threeLargest, value, 0);
            }
        }
        return threeLargest;
    }

    private void shiftAndUpdate(int[] threeLargest, int value, int idx) {
        for (int i = 0; i < idx + 1; i++) {
            if (i == idx) {
                threeLargest[i] = value;
            } else {
                threeLargest[i] = threeLargest[i + 1];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 3, 5, 723, 3, 4, 423, 5, 6, 7, 2, 5, 9, 7, 8 };

        new Array().print(new ThreeLargestNumbers().findThreeLargestNumbers(array));
    }

}
