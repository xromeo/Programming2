package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * 
 */

public class BFSShortestReach {
    
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        List<Integer> distances = new ArrayList<>(Collections.nCopies(n + 1, -1));
        distances.set(s, 0);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.get(current)) {
                if (distances.get(neighbor) == -1) {
                    distances.set(neighbor, distances.get(current) + 6);
                    queue.offer(neighbor);
                }
            }
        }

        distances.remove(s);
        distances.remove(0);

        return distances;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        int s = 1;
        List<Integer> edge1 = List.of(1,2);
        List<Integer> edge2 = List.of(1,3);
        List<Integer> edge3 = List.of(3,4);

        List<List<Integer>> edges = Arrays.asList(edge1, edge2, edge3); 

        bfs(n, m, edges, s);
    }
}
