package com.cyryl.medium;


public class BetterTrie {

    BetterTrieNode root;
    private static int cumulativeValue;

    public BetterTrie() {
        root = new BetterTrieNode();
        cumulativeValue = 1;
    }

    public void insert(String word) {
        BetterTrieNode node = root;
        char currentChar;

        for(int i=0; i<word.length(); i++) {
            currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)) {
                node.put(word.charAt(i), new BetterTrieNode());
            }
            node = node.get(currentChar);
        }
        node.setTerminal();
    }

    public boolean search(String word) {
        BetterTrieNode node = searchPrefix(word);
        return node != null && node.isTerminal();
    }

    public boolean startsWith(String prefix) {
        BetterTrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private BetterTrieNode searchPrefix(String prefix){
        BetterTrieNode node = root;
        char currentChar;

        for(int i=0; i<prefix.length(); i++){
            currentChar = prefix.charAt(i);
            if(node.containsKey(currentChar))
                node.get(currentChar);
            else
                return null;
        }
        return node;
    }

    protected class BetterTrieNode {

        private BetterTrieNode[] children;
        private boolean terminal;
        private final int NUMBER_OF_LETTERS = 26;

        public BetterTrieNode() {
            children = new BetterTrieNode[NUMBER_OF_LETTERS];
        }

        public boolean containsKey(char ch){
            return children[getCharValue(ch)] != null;
        }

        public boolean isTerminal(){
            return terminal;
        }

        public void setTerminal(){
            terminal = true;
        }

        public BetterTrieNode get(char ch){
            return children[getCharValue(ch)];
        }

        public void put(char ch, BetterTrieNode node){
            children[getCharValue(ch)]=node;
        }

        private int getCharValue(char ch){
            return ch - 'a';
        }

    }
}
