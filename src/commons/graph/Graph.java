package commons.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
    private Map<Integer, Vertex> vertices = new HashMap<Integer, Vertex>();

    public Graph() {
        this.vertices = new HashMap<Integer, Vertex>();
    }

    public Graph(Map<Integer, Vertex> graph) {
        this.vertices = graph;
    }

    public void addVertex(Vertex vertex) {
        this.vertices.put(vertex.getId(), vertex);
    }

    public void removeVertex(int id) {
        this.vertices.remove(id);
    }

    public Map<Integer, Vertex> getVertices() {
        return this.vertices;
    }

    public void print() {
        for (Map.Entry<Integer, Vertex> entry : vertices.entrySet()) {
            int vertexId = entry.getKey();
            Vertex vertex = entry.getValue();
            System.out.print(vertexId + ": ");
            for (Edge neighbor : vertex.getNeighbors()) {
                System.out.print(neighbor.getDestination() + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int source) {
        if (!vertices.containsKey(source)) {
            return;
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(source);
        queue.offer(source);

        while (!queue.isEmpty()) {

            int vertexId = queue.poll();
            System.out.print(vertexId + " ");

            Vertex vertex = vertices.get(vertexId);

            for (Edge neighbor : vertex.getNeighbors()) {
                if (!visited.contains(neighbor.getDestination())) {
                    visited.add(neighbor.getDestination());
                    queue.offer(neighbor.getDestination());
                }
            }
        }

        System.out.println();
    }

    public void dfs(int source) {
        if (!vertices.containsKey(source)) {
            return;
        }
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        visited.add(source);
        stack.push(source);

        while (!stack.isEmpty()) {

            int vertexId = stack.pop();
            System.out.print(vertexId + " ");

            Vertex vertex = vertices.get(vertexId);
            for (Edge neighbor : vertex.getNeighbors()) {
                if (!visited.contains(neighbor.getDestination())) {
                    visited.add(neighbor.getDestination());
                    stack.push(neighbor.getDestination());
                }
            }
        }

        System.out.println();
    }

    public void dijkstra(int source, int destination) {
        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, Integer> previous = new HashMap<>();

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.getId()));

        queue.offer(vertices.get(source));
        distances.put(source, 0);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            for (Edge neighbor : current.getNeighbors()) {

                int weight = neighbor.getWeight();

                int newDistance = distances.get(current.getId()) + weight;

                if (!distances.containsKey(neighbor.getDestination())
                        || newDistance < distances.get(neighbor.getDestination())) {
                    int destinationId = neighbor.getDestination();
                    distances.put(destinationId, newDistance);
                    previous.put(destinationId, current.getId());
                    queue.remove(vertices.get(destinationId));
                    queue.add(vertices.get(destinationId));
                }
            }
        }

        if (!distances.containsKey(destination)) {
            System.out.println(" No path exists from source to destination.");
            return;
        }

        // Reconstruct the shortest path
        List<Vertex> shortestPath = reconstructPath(source, destination, previous);

        // Print the shortest path
        System.out.println("Shortest path from source to destination:");
        for (int i = 0; i < shortestPath.size(); i++) {
            System.out.print(shortestPath.get(i).getId());
            if (i != shortestPath.size() - 1) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
        System.out.println("Shortest distance from source to destination: " + distances.get(destination));

    }

    private List<Vertex> reconstructPath(int source, int destination, Map<Integer, Integer> previous) {
        List<Vertex> path = new ArrayList<>();
        Vertex current = vertices.get(destination);
        while (current != null) {
            path.add(current);
            Integer before = previous.get(current.getId());
            current = vertices.get(before);
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String... args) {
        Vertex v1 = new Vertex("A", 1);
        Vertex v2 = new Vertex("B", 2);
        Vertex v3 = new Vertex("C", 3);
        Vertex v4 = new Vertex("D", 4);
        Vertex v5 = new Vertex("E", 5);
        Vertex v6 = new Vertex("F", 6);
        Vertex v7 = new Vertex("G", 7);
        Vertex v8 = new Vertex("H", 8);
        Vertex v9 = new Vertex("I", 9);

        v1.addEdge(2, 5);
        v1.addEdge(6, 1);
        v2.addEdge(1, 5);
        v2.addEdge(6, 2);
        v2.addEdge(3, 10);
        v3.addEdge(2, 10);
        v3.addEdge(4, 10);
        v3.addEdge(9, 2);
        v3.addEdge(5, 7);
        v4.addEdge(3, 10);
        v4.addEdge(9, 4);
        v4.addEdge(7, 3);
        v5.addEdge(3, 7);
        v5.addEdge(6, 4);
        v5.addEdge(7, 7);
        v6.addEdge(1, 1);
        v6.addEdge(2, 2);
        v6.addEdge(5, 4);
        v7.addEdge(5, 7);
        v7.addEdge(4, 3);
        v7.addEdge(8, 4);
        v8.addEdge(7, 4);
        v8.addEdge(9, 5);
        v9.addEdge(3, 2);
        v9.addEdge(4, 9);
        v9.addEdge(8, 5);

        Graph graph = new Graph();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);
        graph.addVertex(v8);
        graph.addVertex(v9);

        graph.print();

        graph.bfs(1);

        graph.dfs(1);

        graph.dijkstra(1, 9);
        graph.dijkstra(1, 8);
        graph.dijkstra(1, 2);

    }
}
