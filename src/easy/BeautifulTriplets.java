package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Complete the beautifulTriplets function in the editor below. It must return an integer that represents the number of beautiful triplets in the sequence.

beautifulTriplets has the following parameters:

d: an integer
arr: an array of integers, sorted ascending
 

Input Format

The first line contains 2 space-separated integers n and d, the length of the sequence and the beautiful difference.
The second line contains n space-separated integers arr[i].

Output Format

Print a single line denoting the number of beautiful triplets in the sequence.

Sample Input

7 3
1 2 4 5 7 8 10
Sample Output

3
 */

public class BeautifulTriplets {

    public static int beautifulTriplets2(int d, List<Integer> arr) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int difference = arr.get(j) - arr.get(i);
                if (difference > d) {
                    break;
                } else if (difference < d) {
                    continue;
                } else {
                    for (int k = j + 1; k < arr.size(); k++) {
                        int difference2 = arr.get(k) - arr.get(j);
                        if (difference2 > d) {
                            break;
                        } else if (difference2 == d) {
                            result.add(List.of(i, j, k));
                        }
                    }
                }
            }
        }
        return result.size();

    }

    public static int beautifulTriplets1(int d, List<Integer> arr) {
        int count = 0;
        
        for (int i = 0; i < arr.size() - 2; i++) {
            int a = arr.get(i);
            int b = a + d;
            int c = b + d;
            
            if (arr.contains(b) && arr.contains(c)) {
                count++;
            }
        }
        
        return count;
    }

    public static int beautifulTriplets(int d, List<Integer> arr) {
        int count = 0;
        Set<Integer> elements = new HashSet<>(arr);

        for (int i = 0; i < arr.size() - 2; i++) {
            int a = arr.get(i);
            int b = a + d;
            int c = b + d;

            if (elements.contains(b) && elements.contains(c)) {
                count++;
            }
        }

        return count;
    }
    

    public static void main(String[] args) {
        System.out.println(beautifulTriplets(1, List.of(2, 2, 3, 4, 5)));
        System.out.println(beautifulTriplets(3, Arrays.asList(1, 2, 4, 5, 7, 8, 10)));
    }
}
