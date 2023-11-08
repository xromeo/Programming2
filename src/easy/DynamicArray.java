package easy;

/*
 Declare a 2-dimensional array, arr, of n empty arrays. All arrays are zero indexed
 Declare an integer, last Answer, and initialize it to 0.

• There are 2 types of queries, given as an array of strings for you to parse:

1. Query: 1 x y

    1. Let idx=((z XOR lastAnswer) % n).
    2. Append the integer y to arr[idx]).

2. Query: 2 x y

    1. Let idx=((z XOR lastAnswer) % n).
    2. Assign the value arr[idx][y % size(arr[idx])] to lastAnswer.
    3. Store the new value of last Answer to an answers array.

Note: is the bitwise XOR operation, which corresponds to the ^ operator in most languages. Learn more about it on Wikipedia. 
% is the modulo operator. 
Finally, size(arr[idx]) is the number of elements in arr[idx]

Function Description

Complete the dynamicArray function below.

dynamicArray has the following parameters:

-Int n: the number of empty arrays to initialize in arr

-string queries[q]: query strings that contain 3 space-separated Integers

Returns

int[]: the results of each type 2 query in the order they are presented

Input Format

The first line contains two space-separated Integers, n, the size of arr to create, and q, the number of queries respectively.

Each of the q subsequent lines contains a query string queries[i].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;

        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        List<Integer> answer = new ArrayList<>();

        for (List<Integer> query : queries) {
            int i = query.get(0);
            int x = query.get(1);
            int y = query.get(2);
            int idx = (x ^ lastAnswer) % n;
            if (i == 1) {
                arr.get(idx).add(y);
            } else if (i == 2) {
                int k = y % arr.get(idx).size();
                lastAnswer = arr.get(idx).get(k);
                answer.add(lastAnswer);
            }

        }
        return answer;

    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(1, 0, 5));
                add(Arrays.asList(1, 1, 7));
                add(Arrays.asList(1, 0, 3));
                add(Arrays.asList(2, 1, 0));
                add(Arrays.asList(2, 1, 1));
            }
        };

        System.out.println(dynamicArray(2, list));
    }

}
