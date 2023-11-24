package easy;

import java.util.List;

public class SherlockAndArray {

    public static String balancedSums(List<Integer> arr) {
        if (arr.size() == 1) {
            return "YES";
        }
        if (arr.size() == 2) {
            return "NO";
        }

        int left = 0;
        int right = arr.size() - 1;
        long sumLeft = arr.get(left);
        long sumRight = arr.get(right);
        while (left < right) {
            if (sumLeft < sumRight) {
                left++;
                sumLeft += arr.get(left);
            } else if (sumLeft > sumRight) {
                right--;
                sumRight += arr.get(right);
            } else if (sumLeft == sumRight) {
                left++;
                right--;
                sumLeft += arr.get(left);
                sumRight += arr.get(right);
            }
            if (left == right) {
                return sumLeft == sumRight ? "YES" : "NO";
            }
        }
        return "NO";
    }

    public static String balancedSums2(List<Integer> arr) {
        int totalSum = 0, currentSum = 0;

        for (Integer num : arr){
            totalSum += num;
        }

        for (int i = 0; i < arr.size(); i++) {
            totalSum -= arr.get(i);
            if (currentSum == totalSum) {
                return "YES";
            }
            currentSum += arr.get(i);
        }

        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(balancedSums(List.of(5, 6, 8, 11)));
        System.out.println(balancedSums(List.of(1, 2, 3)));
        System.out.println(balancedSums(List.of(1, 2, 3, 3)));
        System.out.println(balancedSums(List.of(1, 2, 2, 3, 2, 3)));
    }
}
