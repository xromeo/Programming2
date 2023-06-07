package commons.graphbasic;

import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addVertex(int vertexId) {
        Vertex vertex = new Vertex(vertexId);
        vertices.put(vertexId, vertex);
    }

    public void addEdge(int source, int destination) {
        if (!vertices.containsKey(source)) {
            addVertex(source);
        }
        if (!vertices.containsKey(destination)) {
            addVertex(destination);
        }

        Vertex sourceVertex = vertices.get(source);
        Vertex destinationVertex = vertices.get(destination);

        sourceVertex.addNeighbor(destinationVertex);
        destinationVertex.addNeighbor(sourceVertex);
    }

    public void removeVertex(int vertexId) {
        if (!vertices.containsKey(vertexId)) {
            return;
        }

        Vertex vertex = vertices.get(vertexId);

        for (Vertex neighbor : vertex.getNeighbors()) {
            neighbor.removeNeighbor(vertex);
        }

        vertices.remove(vertexId);
    }

    public void removeEdge(int source, int destination) {
        if (!vertices.containsKey(source) || !vertices.containsKey(destination)) {
            return;
        }

        Vertex sourceVertex = vertices.get(source);
        Vertex destinationVertex = vertices.get(destination);

        sourceVertex.removeNeighbor(destinationVertex);
        destinationVertex.removeNeighbor(sourceVertex);
    }

    public List<Vertex> getNeighbors(int vertexId) {
        if (!vertices.containsKey(vertexId)) {
            return new ArrayList<>();
        }

        return vertices.get(vertexId).getNeighbors();
    }

    public void printGraph() {
        for (Map.Entry<Integer, Vertex> entry : vertices.entrySet()) {
            int vertexId = entry.getKey();
            Vertex vertex = entry.getValue();
            System.out.print(vertexId + ": ");
            for (Vertex neighbor : vertex.getNeighbors()) {
                System.out.print(neighbor.getId() + " ");
            }
            System.out.println();
        }
    }

    public void breadthFirstSearch(int startVertex) {
        if (!vertices.containsKey(startVertex)) {
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertexId = queue.poll();
            System.out.print(vertexId + " ");

            Vertex vertex = vertices.get(vertexId);
            for (Vertex neighbor : vertex.getNeighbors()) {
                if (!visited.contains(neighbor.getId())) {
                    visited.add(neighbor.getId());
                    queue.add(neighbor.getId());
                }
            }
        }

        System.out.println();
    }

    public void depthFirstSearch(int startVertex) {
        if (!vertices.containsKey(startVertex)) {
            return;
        }

        Set<Integer> visited = new HashSet<>();
        depthFirstSearchHelper(startVertex, visited);
        System.out.println();
    }

    private void depthFirstSearchHelper(int vertexId, Set<Integer> visited) {
        visited.add(vertexId);
        System.out.print(vertexId + " ");

        Vertex vertex = vertices.get(vertexId);
        for (Vertex neighbor : vertex.getNeighbors()) {
            if (!visited.contains(neighbor.getId())) {
                depthFirstSearchHelper(neighbor.getId(), visited);
            }
        }
    }   
    
    

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(5, 4);
     
        graph.printGraph();

        System.out.print("BFS traversal: ");
        graph.breadthFirstSearch(1);

        System.out.print("DFS traversal: ");
        graph.depthFirstSearch(1);

      
    }
}
