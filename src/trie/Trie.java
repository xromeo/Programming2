package trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;

        for (char ch : word.toCharArray()) {
            currentNode.children.putIfAbsent(ch, new TrieNode());
            currentNode = currentNode.children.get(ch);
        }

        currentNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = root;

        for (char ch : word.toCharArray()) {
            if (!currentNode.children.containsKey(ch)) {
                return false;
            }
            currentNode = currentNode.children.get(ch);
        }

        return currentNode.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;

        for (char ch : prefix.toCharArray()) {
            if (!currentNode.children.containsKey(ch)) {
                return false;
            }
            currentNode = currentNode.children.get(ch);
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("cherry");

        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("orange")); // false
        System.out.println(trie.startsWith("app")); // true
    }
}
