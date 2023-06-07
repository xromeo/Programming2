package commons.graph;

public class Edge {
    private int destination;
    private int weight;

    public Edge(int destination, int weight){
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
