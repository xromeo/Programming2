package easy;

/*
 * Flatland is a country represented as a number line, and cities are marked on the number line. The cities are numbered from 0 to n-1. Some cities have space stations, and their indices are given as an array, c. For example, if c = [0, 4, 6], then cities 0, 4, and 6 have space stations.

The distance between two cities, i and j (where i < j), is given by |j - i|.

You need to find the maximum distance that an inhabitant of Flatland would need to travel to reach the nearest space station.

Write a function flatlandSpaceStations(n, c) that returns an integer representing the maximum distance to the nearest space station.

Input Format:

The first line of input contains two space-separated integers, n (0 <= n <= 10^5) and m (0 <= m <= n), where n is the number of cities and m is the number of space stations.
The second line of input contains m space-separated integers denoting the indices of the cities with space stations, c[0], c[1], ..., c[m-1].
Output Format:

Return an integer representing the maximum distance to the nearest space station.
Sample Input 1:

n = 5, m = 2
c = [0, 4]
Sample Output 1:
2

Explanation 1:

In this example, there are 5 cities and 2 space stations located at cities 0 and 4. The maximum distance to the nearest space station is 2, as the second city is 2 units away from the nearest space station at city 0.
 */

public class FlatlandSpaceStation {

    static int flatlandSpaceStations(int n, int[] c) {

        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE;
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c.length; j++) {
                int v = c[j];
                d[i] = Math.min(Math.abs(v - i), d[i]);
            }
            max = Math.max(d[i], max);
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(flatlandSpaceStations(3, new int[] { 1 }));
        System.out.println(flatlandSpaceStations(5, new int[] { 0, 4 }));
        System.out.println(flatlandSpaceStations(6, new int[] { 0, 1, 2, 4, 3, 5 }));
    }
}
