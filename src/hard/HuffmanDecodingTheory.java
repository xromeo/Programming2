package hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class HuffmanDecodingTheory {

    public static class Data {

        private Character character;
        private int frequency;

        public Data(Character character, int frequency){
            this.character = character;
            this.frequency = frequency;
        }

        public Character getCharacter() {
            return this.character;
        }

        public int getFrequency() {
            return this.frequency;
        }
    }

    public static class Node {
        private Data data;
        private Node left;
        private Node right;

        public Node(Data data) {
            this.data = data;
        }

        public Data getData() {
            return this.data;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        public void insert(Node node) {
            if (this.data.frequency >= node.data.frequency) {
                if (Objects.nonNull(this.left)) {
                    this.left.insert(node);
                } else {
                    this.left = node;
                }
            } else if(this.data.frequency < node.data.frequency){
                if(Objects.nonNull(this.right)){
                    this.right.insert(node);
                } else {
                    this.right = node;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine().trim();
        System.out.println(s);

        bufferedReader.close();

        Map<Character, Data> frequencies = getFrequencies(s);

        for (Map.Entry<Character, Data> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().frequency);
        }

        System.out.println();

        List<Data> sorted = getSortedFrequencies(frequencies, s);

        for (Data data : sorted) {
            System.out.println(data.character + ": " + data.frequency);
        }

        Node root = buildHuffmanTree(sorted);

        decodeHuffman(root, "01111001100011010111100");

    }

    public static Node buildHuffmanTree( List<Data> sorted) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.data.frequency - b.data.frequency);

        for (Data data : sorted) {
            minHeap.add(new Node(new Data(data.character, data.frequency)));
        }

        while (minHeap.size() > 1) {
            Node left = minHeap.poll();
            Node right = minHeap.poll();
            Node merged = new Node(new Data('\0', left.data.frequency + right.data.frequency));
            merged.left = left;
            merged.right = right;
            minHeap.add(merged);
        }

        return minHeap.poll();
    }

    public static void decodeHuffman(Node root, String encodedString) {
        Node current = root;
        StringBuilder decoded = new StringBuilder();

        for (char bit : encodedString.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.left == null && current.right == null) {
                decoded.append(current.data.getCharacter());
                current = root;
            }
        }

        System.out.println(decoded);
    }

    private static List<Data> getSortedFrequencies(Map<Character, Data> frequencies, String word) {
        List<Data> sorted = new ArrayList<>(frequencies.values());

        sorted.sort((a, b) -> {
            if (a.frequency != b.frequency) {
                return Integer.compare(b.frequency, a.frequency);
            } else {
                return Integer.compare(word.indexOf(a.character), word.indexOf(b.character));
            }
        });

        return sorted;
    }

    private static Map<Character, Data> getFrequencies(String s) {
        Map<Character, Data> frequencies = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            Data data = frequencies.getOrDefault(ch, new Data(ch, 0));
            data.frequency++;
            frequencies.put(ch, data);

        }
        return frequencies;
    }
}
