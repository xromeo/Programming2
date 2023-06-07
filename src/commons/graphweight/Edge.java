package commons.graphweight;

public class Edge {
    private int source;
    private int destination;    
    private int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getDestination() {
        return destination;
    }

    public int getSource() {
        return source;
    }    
    
    
}
