package com.cyryl.neetcode150.graph;

import java.util.*;

/**
 * https://www.lintcode.com/problem/892/
 */

public class AlienDictionary {

    private final static int NR_OF_LETTERS = 26;
    private final static char NONE = ' ';

    public String alienOrder(String[] words) {
        LanguageTree languageTree = new LanguageTree();
        for (String word : words) {
            if (!languageTree.insertWord(word)){
                return "";
            }
        }
        return languageTree.solve();
    }

    private class LanguageTree {

        private Node root;
        private Map<Character, Integer> inDegree = new HashMap<>();
        private Map<Character, List<Character>> graph = new HashMap<>();
        private String lastWord;

        public LanguageTree() {
            root = new Node();
            lastWord = "";
        }

        public boolean insertWord(String word) {
            Node currNode = root;
            boolean dependencyFound = false;
            boolean newData = false;
            for (int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);
                graph.putIfAbsent(currChar, new ArrayList<>());
                inDegree.putIfAbsent(currChar, 0);
                if (currNode.contains(currChar)) {
                    currNode = currNode.getChild(currChar);
                } else {
                    newData = true;
                    if (!dependencyFound && currNode.last != NONE) {
                        dependencyFound = true;
                        graph.get(currNode.last).add(currChar);
                        inDegree.put(currChar, inDegree.get(currChar) + 1);
                    }
                    currNode = currNode.createChild(currChar);
                }
            }
            boolean result = newData || lastWord.equals(word);
            lastWord = word;
            return result;
        }

        public String solve() {
            StringBuilder sb = new StringBuilder();
            PriorityQueue<Character> queue = new PriorityQueue<>();
            for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
                if (entry.getValue() == 0) {
                    queue.offer(entry.getKey());
                }
            }
            while (!queue.isEmpty()) {
                char curr = queue.poll();
                sb.append(curr);
                for (char next : graph.get(curr)){
                    inDegree.put(next, inDegree.get(next) - 1);
                    if(inDegree.get(next) == 0){
                        queue.offer(next);
                    }
                }
            }
            for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
                if (entry.getValue() != 0) {
                    return "";
                }
            }
            return sb.toString();
        }

        private class Node {
            Node[] children;
            char last;

            public Node() {
                children = new Node[NR_OF_LETTERS];
                last = NONE;
            }

            public boolean contains(char c) {
                return children[c - 'a'] != null;
            }

            public Node getChild(char c) {
                return children[c - 'a'];
            }

            public Node createChild(char c) {
                last = c;
                children[c - 'a'] = new Node();
                return children[c - 'a'];
            }
        }
    }
}
