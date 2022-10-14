package easy;
/**
 * BinarySearch
 */
public class BinarySearch {

    int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length);
    }

    int binarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int midle = (left + right) / 2;
        int value = array[midle];
        if (target == value) {
            return value;
        }
        if (value < target) {
            return binarySearch(array, target, midle + 1, right);
        } else {
            return binarySearch(array, target, left, midle - 1);
        }

    }

    int binarySearch2(int[] array, int target) {
        return binarySearch2(array, target, 0, array.length);
    }

    int binarySearch2(int[] array, int target, int left, int right) {
        while (left <= right) {
            int midle = (left + right) / 2;
            int value = array[midle];
            if (target == value) {
                return value;
            }
            if (value < target) {
                left = midle + 1;
            } else {
                right = midle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 };
        System.out.println(new BinarySearch().binarySearch(array, 33));
        System.out.println(new BinarySearch().binarySearch2(array, 33));
    }
}