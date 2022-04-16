package com.cyryl.hard;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Trie prefixTree = new Trie();
        SuffixTrie suffixTree = new SuffixTrie();
        Map<String, Set<String>> wordConnections = new HashMap<>();
        boolean[] possibleWords;
        String newWord;

        wordList.add(beginWord);

        for(String word: wordList){
            prefixTree.insert(word);
            suffixTree.insert(word);
        }

        for(String word: wordList){
            for(int i=0; i<word.length(); i++){
                possibleWords = concatenate(prefixTree.search(word.substring(0,i)), suffixTree.search(word.substring(i+1)));

                for(int j=0; j<possibleWords.length; j++){
                    if(possibleWords[j] && word.charAt(i) != intToChar(j)) {
                        newWord = word.substring(0, i) + intToChar(j) + word.substring(i + 1);
                        if(prefixTree.search(newWord) != null)
                            connectWords(wordConnections, newWord, word);
                    }
                }
            }
        }
        if(!wordConnections.containsKey(beginWord))
            return 0;

        return findShortestRoad(wordConnections, beginWord, endWord);
    }

    private int findShortestRoad(Map<String, Set<String>> map, String start, String end){
        Map<String, Integer> distance = new HashMap<>();
        distance.put(start, 1);
        String curWord;
        int curDistance;

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {

            curWord = queue.poll();
            curDistance = distance.get(curWord);

            for (String neighbour : map.get(curWord)) {
                if (!distance.containsKey(neighbour)) {
                    distance.put(neighbour, curDistance + 1);
                    queue.offer(neighbour);
                }
            }
        }

        return distance.getOrDefault(end, 0);
    }


    private void connectWords(Map<String, Set<String>> map, String wordA, String wordB){
        if(!map.containsKey(wordA)){
            map.put(wordA, new HashSet<>());
        }
        map.get(wordA).add(wordB);

        if(!map.containsKey(wordB)){
            map.put(wordB, new HashSet<>());
        }
        map.get(wordB).add(wordA);
    }


    private boolean[] concatenate(boolean[] arrA, boolean[] arrB){
        if (arrA == null || arrB == null)
            return null;

        boolean[] result = new boolean[arrA.length];

        for(int i=0; i<arrA.length; i++){
            result[i] = arrA[i] && arrB[i];
        }
        return result;
    }

    private int charToInt(char c){
        return c - 'a';
    }

    private char intToChar(int val){
        return (char)(val + 'a');
    }

    private class Trie{

        private final TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){

            TrieNode node = root;
            char curChar;

            for(int i=0; i<word.length(); i++){
                curChar = word.charAt(i);
                if(node.contains(curChar))
                    node = node.getChildren(curChar);
                else{
                    node = node.addChild(curChar);
                }
            }
            node.setTerminal();
        }

        public boolean[] search(String prefix){

            TrieNode node = root;
            char curChar;

            for(int i=0; i<prefix.length();i++){
                curChar = prefix.charAt(i);
                if(node.contains(curChar))
                    node = node.getChildren(curChar);
                else
                    return null;
            }
            return node.getLetters();
        }

        private class TrieNode{

            private boolean[] letters;
            private TrieNode[] children;
            private final int MAX_LETTERS = 26;
            boolean terminal;

            public TrieNode(){
                letters = new boolean[MAX_LETTERS];
                children = new TrieNode[26];
            }

            public boolean[] getLetters() {
                return letters;
            }

            public TrieNode addChild(char c){
                int charValue = charToInt(c);
                letters[charValue] = true;
                children[charValue] = new TrieNode();
                return children[charValue];
            }

            public void setTerminal(){
                terminal = true;
            }

            public TrieNode getChildren(char c) {
                return children[charToInt(c)];
            }

            public boolean contains(char c){
                return letters[charToInt(c)];
            }
        }

    }

    private class SuffixTrie extends Trie {

        @Override
        public void insert(String word){
            StringBuilder stringBuilder = new StringBuilder(word);
            super.insert(stringBuilder.reverse().toString());
        }

        @Override
        public boolean[] search(String prefix){
            StringBuilder stringBuilder = new StringBuilder(prefix);
            return super.search(stringBuilder.reverse().toString());
        }
    }
}
