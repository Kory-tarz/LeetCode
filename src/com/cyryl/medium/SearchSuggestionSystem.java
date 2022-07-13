package com.cyryl.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        Arrays.stream(products).forEach(p -> trie.insert(p));
        return trie.findAllSuggestions(searchWord);
    }

    class Trie{

        Node root;
        final int NUMBER_OF_LETTERS = 26;
        final int COUNT_LIMIT = 3;

        public Trie(){
            root = new Node();
        }

        public void insert(String word){
            Node current = root;

            for (int i = 0; i < word.length(); i++) {
                current = current.addChild(word.charAt(i));
            }
            current.setTerminal();
        }

        public List<List<String>> findAllSuggestions(String prefix){
            List<List<String>> result = new ArrayList<>();
            Node current = root;

            for (int i = 0; i < prefix.length(); i++) {
                current = find(String.valueOf(prefix.charAt(i)), current);
                if(current == null)
                    result.add(new ArrayList<>());
                else{
                    result.add(findSuggestions(current, new ArrayList<>(), prefix.substring(0, i+1)));
                }
            }
            return result;
        }

        public Node find(String prefix, Node node){
            Node current = node;

            for (int i = 0; i < prefix.length(); i++) {
                if(current.contains(prefix.charAt(i))){
                    current = current.getChild(prefix.charAt(i));
                }else{
                    return null;
                }
            }
            return current;
        }

        public List<String> findSuggestions(Node node, List<String> list, String word){
            if(node.isTerminal()){
                list.add(word);
            }
            if(list.size() >= COUNT_LIMIT){
                return list;
            }
            for (int i = 0; i < node.children.length; i++) {
                char currChar = intToChar(i);
                if(node.contains(currChar)){
                    findSuggestions(node.getChild(currChar), list, word + currChar);
                    if(list.size() >= COUNT_LIMIT){
                        return list;
                    }
                }
            }
            return list;
        }

        private int charToInt(char c) {
            return Character.toLowerCase(c) - 'a';
        }

        private char intToChar(int value){
            return (char)(value + 'a');
        }


        class Node {

            private Node[] children;
            private boolean terminal;

            public Node() {
                children = new Node[NUMBER_OF_LETTERS];
                terminal = false;
            }

            public Node addChild(char c) {
                int charValue = charToInt(c);
                if(contains(c)){
                    return children[charValue];
                }
                return children[charValue] = new Node();
            }

            public Node getChild(char c){
                return children[charToInt(c)];
            }

            public boolean contains(char c){
                return (children[charToInt(c)] != null);
            }

            public void setTerminal(){
                terminal = true;
            }

            public boolean isTerminal(){
                return terminal;
            }
        }
    }
}
