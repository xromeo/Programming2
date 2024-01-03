package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of integers, find the longest subarray where the absolute difference between any two elements is less than or equal to 1.

Example
a = [1,1,2,2,4,4,5,5,5]

There are two subarrays meeting the criterion: [1,1,2,2] and [4,4,5,5,5]. The maximum length subarray has 5 elements.

Constraints

2 <= n <= 100
0 < a[i] < 100
The answer will be >= 2.

*/

public class PickingNumbers {

    public static int pickingNumbers(List<Integer> a) {

        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int current = 0;
        int next = 0;

        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            current = map.get(key);
            next = map.getOrDefault(key + 1, 0);
            result = Math.max(result, current + next);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1)));// 3
        System.out.println(pickingNumbers(Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5)));// 5
        System.out.println(pickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2)));// 5
        System.out.println(pickingNumbers(Arrays.asList(1, 5)));// 5
    }
}
