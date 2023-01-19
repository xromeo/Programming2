package easy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import binarytree.Node;
public class BranchCounts {

    void branchCount(Node node, int count, List<Integer> counts){
        if(Objects.isNull(node)){
            return;
        }
        count++;
        if(Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight())){
            counts.add(count);
            return;
        }
        branchCount(node.getLeft(), count, counts);
        branchCount(node.getRight(), count, counts);
    }
    public static void main(String[] args) {
        Node node = new Node(10);
        node.insert(5);
        node.insert(15);
        node.insert(4);
        node.insert(13);
        node.insert(12);
        node.insert(2);
        node.insert(7);
        
        BranchCounts branchCounts = new BranchCounts();
        List<Integer> sums = new ArrayList<>();
        branchCounts.branchCount(node, 0, sums);
        sums.stream().forEach(System.out::println);;
    }

}
