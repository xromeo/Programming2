package easy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import binaryTree.Node;
public class BranchSums {

    void branchSum(Node node, int runningSum, List<Integer> sums){
        if(Objects.isNull(node)){
            return;
        }
        int sum = runningSum + node.getData();
        if(Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight())){
            sums.add(sum);
            return;
        }
        branchSum(node.getLeft(), sum, sums);
        branchSum(node.getRight(), sum, sums);
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
        
        BranchSums branchSums = new BranchSums();
        List<Integer> sums = new ArrayList<>();
        branchSums.branchSum(node, 0, sums);
        sums.stream().forEach(System.out::println);;
    }

}
