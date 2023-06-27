package commons.graphbasic;

import java.util.ArrayList;
import java.util.List;

/**
 * Vertex
 */
public class Vertex {

    
        private int id;
        private List<Vertex> neighbors;
    
        public Vertex(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }
    
        public int getId() {
            return id;
        }
    
        public List<Vertex> getNeighbors() {
            return neighbors;
        }
    
        public void addNeighbor(Vertex neighbor) {
            neighbors.add(neighbor);
        }
    
        public void removeNeighbor(Vertex neighbor) {
            neighbors.remove(neighbor);
        }
    }
    