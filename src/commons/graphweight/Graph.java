package commons.graphweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Graph {
    Map<Integer, Vertex> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(int id, String data) {
        Vertex vertex = new Vertex(id, data);
        vertices.put(id, vertex);
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        vertices.get(source).getEdges().add(edge);

        // Add a reverse edge for an undirected graph
        Edge reverseEdge = new Edge(destination, source, weight);
        vertices.get(destination).getEdges().add(reverseEdge);
    }

    public List<Edge> getEdges(int vertex) {
        return vertices.get(vertex).getEdges();
    }

    public Vertex getVertex(int vertex) {
        return vertices.get(vertex);
    }



    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex(0, "Vertex 0");
        graph.addVertex(1, "Vertex 1");
        graph.addVertex(2, "Vertex 2");

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 5);

        for (int i = 0; i < graph.vertices.size(); i++) {
            Vertex vertex = graph.getVertex(i);
            List<Edge> edges = graph.getEdges(i);
            System.out.print("Vertex " + vertex.getId() + " (" + vertex.getData() + ") is connected to: ");
            for (Edge edge : edges) {
                System.out.print("(" + edge.getDestination() + ", Weight: " + edge.getWeight() + ") ");
            }
            System.out.println();
        }
    }
}
