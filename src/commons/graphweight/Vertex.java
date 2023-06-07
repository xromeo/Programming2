package commons.graphweight;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int id;
    private String data;
    private List<Edge> edges;

    public Vertex(int id, String data) {
        this.id = id;
        this.data = data;
        this.edges = new ArrayList<>();
    }


    public String getData() {
        return data;
    }

    public int getId() {
        return id;
    }


    public List<Edge> getEdges() {
        return edges;
    }

    
}