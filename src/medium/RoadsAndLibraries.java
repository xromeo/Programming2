package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem
 * Determine the minimum cost to provide library access to all citizens of
 * HackerLand. There are n cities numbered from 1 to n. Currently, there are no
 * libraries and the cities are not connected. Bidirectional roads may be built
 * between any city pair listed in cities. A citizen has access to a library if:
 * 
 * Their city contains a library.
 * They can travel by road from their city to a city containing a library.
 * 
 * Function Description

Complete the function roadsAndLibraries in the editor below.
roadsAndLibraries has the following parameters:

int n: integer, the number of cities
int c_lib: integer, the cost to build a library
int c_road: integer, the cost to repair a road
int cities[m][2]: each  contains two integers that represent cities that can be connected by a new road
 */
public class RoadsAndLibraries {

    private static boolean[] visited;
    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER c_lib
     * 3. INTEGER c_road
     * 4. 2D_INTEGER_ARRAY cities
     */

     public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // If the cost of building a library is lower than or equal to the cost of building roads,
        // it is more cost-effective to build a library in each city
        if (c_lib <= c_road) {
            return (long) n * c_lib;
        }

        visited = new boolean[n + 1];
        long totalCost = 0;

        List<List<Integer>> adjacencyList = buildAdjacencyList(n, cities);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                // Start a new DFS from an unvisited city
                long connectedCities = dfs(i, adjacencyList);
                totalCost += c_lib + (connectedCities - 1) * c_road;
            }
        }

        return totalCost;
    }

    private static List<List<Integer>> buildAdjacencyList(int n, List<List<Integer>> cities) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (List<Integer> connection : cities) {
            int city1 = connection.get(0);
            int city2 = connection.get(1);
            adjacencyList.get(city1).add(city2);
            adjacencyList.get(city2).add(city1);
        }

        return adjacencyList;
    }

    private static long dfs(int city, List<List<Integer>> adjacencyList) {
        visited[city] = true;
        long connectedCities = 1;

        for (int adjacentCity : adjacencyList.get(city)) {
            if (!visited[adjacentCity]) {
                connectedCities += dfs(adjacentCity, adjacencyList);
            }
        }

        return connectedCities;
    }

    public static void main(String[] args) {
        int n = 7;
        int c_lib = 2;
        int c_road = 1;
        List<List<Integer>> cities = new ArrayList<>();
        cities.add(List.of(1, 2));
        cities.add(List.of(2, 3));
        cities.add(List.of(1, 3));
        cities.add(List.of(4, 1));
        cities.add(List.of(3, 7));
        cities.add(List.of(5, 6));

        long cost = roadsAndLibraries(n, c_lib, c_road, cities);
        System.out.println("Minimum cost: " + cost);
    
    }
}
