package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequenceEcuation {

    public static List<Integer> permutationEquation(List<Integer> p) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < p.size(); i++) {
            map.put(p.get(i), i + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int x = 1; x <= p.size(); x++) {
            int px = map.get(x);
            int py = map.get(px);
            result.add(py);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(permutationEquation(Arrays.asList(5,2,1,3,4)));
    }
}
