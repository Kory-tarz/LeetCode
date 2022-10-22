package com.cyryl.contest.virtual.weekly311;

public class PrefixScores {

    private final static int NR_OF_LETTERS = 26;

    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = trie.calculateWord(words[i]);
        }
        return result;
    }

    private class Trie {

        private Node root;

        public Trie() {
            root = new Node();
        }

        public int calculateWord(String word){
            Node curr = root;
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                curr = curr.getChild(word.charAt(i));
                count += curr.count;
            }
            return count;
        }

        public void addWord(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                curr = curr.addChild(word.charAt(i));
            }
        }

        private class Node {
            Node[] children;
            int count;

            Node() {
                count = 0;
                children = new Node[NR_OF_LETTERS];
            }

            public Node addChild(char c) {
                int charVal = c - 'a';
                if(children[charVal] == null){
                    children[charVal] = new Node();
                }
                children[charVal].count++;
                return children[charVal];
            }

            public Node getChild(char c){
                return children[c - 'a'];
            }
        }
    }
}
