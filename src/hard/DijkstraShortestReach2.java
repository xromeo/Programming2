package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 
 Given an undirected graph and a starting node, determine the lengths of the shortest paths from the starting node to all other nodes in the graph. If a node is unreachable, its distance is -1. Nodes will be numbered consecutively from 1 to n, and edges will have varying distances or lengths.

For example, consider the following graph of 5 nodes:

Begin	End	Weight
1	2	5
2	3	6
3	4	2
1	3	15
 * 
 */
public class DijkstraShortestReach2 {
    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. 2D_INTEGER_ARRAY edges
     * 3. INTEGER s
     */
    public static class Edge {
        private int destination;
        private int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        public int getDestination() {
            return this.destination;
        }

        public int getWeight() {
            return this.weight;
        }

    }

    public static class Vertex {

        private String data;
        private int id;
        private List<Edge> neighbors;

        public Vertex(String data, int id) {
            this.data = data;
            this.id = id;
            this.neighbors = new ArrayList<>();
        }

        public Vertex(String data, int id, List<Edge> neighbors) {
            this(data, id);
            this.neighbors = neighbors;
        }

        public String getData() {
            return this.data;
        }

        public int getId() {
            return this.id;
        }

        public List<Edge> getNeighbors() {
            return this.neighbors;
        }

        public void addEdge(int destination, int weight) {
            Edge edge = new Edge(destination, weight);
            neighbors.add(edge);
        }

        public void removeEdge(int destination) {
            neighbors.remove(destination);
        }
    }

    public static class Graph {
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
    }

    public static List<Integer> shortestReachCool(int n, List<List<Integer>> edges, int s) {

        Map<Integer, Integer> distances = new HashMap<>();

        Graph graph = new Graph();

        for (int i = 1; i <= n; i++) {
            Vertex v = new Vertex(Integer.toString(i), i);
            graph.addVertex(v);
        }

        for (List<Integer> edge : edges) {
            int v1 = edge.get(0);
            int v2 = edge.get(1);
            int w = edge.get(2);

            graph.getVertices().get(v1).addEdge(v2, w);

            graph.getVertices().get(v2).addEdge(v1, w);
        }

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.getId()));
        queue.offer(graph.vertices.get(s));
        distances.put(s, 0);

        while (!queue.isEmpty()) {

            Vertex current = queue.poll();

            current.getNeighbors().stream().forEach(neighbor -> {

                int weight = neighbor.getWeight();

                int newDistance = distances.get(current.id) + weight;

                if (!distances.containsKey(neighbor.getDestination())
                        || newDistance < distances.get(neighbor.getDestination())) {
                    int destinationId = neighbor.getDestination();
                    distances.put(destinationId, newDistance);

                    queue.remove(graph.getVertices().get(destinationId));
                    queue.add(graph.getVertices().get(destinationId));
                }
            });
        }

        List<Integer> result = new ArrayList<>(Collections.nCopies(n + 1, 0));
        for (int i = 1; i <= n; i++) {
            int d = distances.get(i) == null ? -1 : distances.get(i);
            result.set(i, d);
        }

        result.remove(s);
        result.remove(0);
        return result;
    }

    public static class Node{
        private int destination;
        private int weight;

        public Node(int destination, int weight){
            this.destination = destination;
            this.weight = weight;
        }

        public int getDestination(){
            return this.destination;
        }

        public int getWeight(){
            return this.weight;
        }
    }

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, List<Node>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int v1 = edge.get(0);
            int v2 = edge.get(1);
            int w = edge.get(2);

            graph.get(v1).add(new Node(v2, w));
            graph.get(v2).add(new Node(v1, w));
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{s, 0});
        distances.put(s, 0);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int dist = current[1];

            if (dist > distances.get(node)) {
                continue;
            }

            for (Node neighbor : graph.get(node)) {
                int newDist = dist + neighbor.getWeight();

                if (!distances.containsKey(neighbor.getDestination()) || newDist < distances.get(neighbor.getDestination())) {
                    distances.put(neighbor.getDestination(), newDist);
                    queue.offer(new int[]{neighbor.getDestination(), newDist});
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int d = distances.getOrDefault(i, -1);
            if (i != s) {
                result.add(d);
            }
        }

        return result;
    }


    public static List<Integer> shortestReach2(int n, List<List<Integer>> edges, int s) {

        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, List<Node>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {

            graph.put(i, new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int v1 = edge.get(0);
            int v2 = edge.get(1);
            int w = edge.get(2);
            
            graph.get(v1).add(new Node(v2, w));
            graph.get(v2).add(new Node(v1, w));

        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(s);
        distances.put(s, 0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            List<Node> nodes = graph.get(current);

            for (Node neighbor : nodes) {
                int weight = neighbor.getWeight();

                int distance = distances.get(current) + weight;

                Integer destination = neighbor.getDestination();
                if (!distances.containsKey(destination) || distance < distances.get(destination)) {
                    distances.put(destination, distance);

                    queue.remove(destination);
                    queue.add(destination);
                }
            }
        }

        List<Integer> result = new ArrayList<>(Collections.nCopies(n + 1, 0));
        for (int i = 1; i <= n; i++) {
            int d = distances.get(i) == null ? -1 : distances.get(i);
            result.set(i, d);
        }

        result.remove(s);
        result.remove(0);
        return result;
    }

    public static void main(String[] args) {
        int s = 17;
        int n = 20;

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1, 7, 45));
        edges.add(Arrays.asList(2, 14, 15));
        edges.add(Arrays.asList(3, 7, 29));
        edges.add(Arrays.asList(4, 1, 48));
        edges.add(Arrays.asList(5, 1, 66));
        edges.add(Arrays.asList(6, 7, 17));
        edges.add(Arrays.asList(7, 14, 15));
        edges.add(Arrays.asList(8, 14, 43));
        edges.add(Arrays.asList(9, 1, 27));
        edges.add(Arrays.asList(10, 1, 33));
        edges.add(Arrays.asList(11, 14, 64));
        edges.add(Arrays.asList(12, 14, 27));
        edges.add(Arrays.asList(13, 7, 66));
        edges.add(Arrays.asList(14, 7, 54));
        edges.add(Arrays.asList(15, 14, 56));
        edges.add(Arrays.asList(16, 7, 21));
        edges.add(Arrays.asList(17, 1, 20));
        edges.add(Arrays.asList(18, 1, 34));
        edges.add(Arrays.asList(19, 7, 52));
        edges.add(Arrays.asList(20, 14, 14));
        edges.add(Arrays.asList(9, 14, 9));
        edges.add(Arrays.asList(15, 1, 39));
        edges.add(Arrays.asList(12, 1, 24));
        edges.add(Arrays.asList(9, 1, 16));
        edges.add(Arrays.asList(1, 2, 33));
        edges.add(Arrays.asList(18, 1, 46));
        edges.add(Arrays.asList(9, 1, 28));
        edges.add(Arrays.asList(15, 14, 3));
        edges.add(Arrays.asList(12, 1, 27));
        edges.add(Arrays.asList(1, 2, 5));
        edges.add(Arrays.asList(15, 1, 34));
        edges.add(Arrays.asList(1, 2, 28));
        edges.add(Arrays.asList(9, 7, 16));
        edges.add(Arrays.asList(3, 7, 23));
        edges.add(Arrays.asList(9, 7, 21));
        edges.add(Arrays.asList(9, 14, 19));
        edges.add(Arrays.asList(3, 1, 20));
        edges.add(Arrays.asList(3, 1, 5));
        edges.add(Arrays.asList(12, 14, 19));
        edges.add(Arrays.asList(3, 14, 2));
        edges.add(Arrays.asList(12, 1, 46));
        edges.add(Arrays.asList(3, 14, 5));
        edges.add(Arrays.asList(9, 14, 44));
        edges.add(Arrays.asList(6, 14, 26));
        edges.add(Arrays.asList(9, 14, 16));
        edges.add(Arrays.asList(9, 14, 34));
        edges.add(Arrays.asList(6, 7, 42));
        edges.add(Arrays.asList(3, 14, 27));
        edges.add(Arrays.asList(1, 7, 9));
        edges.add(Arrays.asList(1, 7, 41));
        edges.add(Arrays.asList(15, 14, 19));
        edges.add(Arrays.asList(12, 7, 13));
        edges.add(Arrays.asList(3, 7, 10));
        edges.add(Arrays.asList(1, 7, 2));

        List<Integer> result = shortestReach(n, edges, s);
        System.out.println(result);
    }
}
