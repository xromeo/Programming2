package commons.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

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