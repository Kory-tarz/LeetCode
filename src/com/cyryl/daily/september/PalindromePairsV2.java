package com.cyryl.daily.september;

import java.util.*;

public class PalindromePairsV2 {

    private final int NUMBER_OF_LETTERS = 26;

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.addWord(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) {
                bruteEmpty(words, i, result);
                continue;
            }
            List<Integer> palindromesIndices = trie.search(words[i]);
            System.out.println(words[i] + " idx: " + palindromesIndices.toString());
            for (Integer wordIdx : palindromesIndices) {
                if (wordIdx != i) {
                    result.add(List.of(i, wordIdx));
                }
            }
        }

        return result;
    }

    private void bruteEmpty(String[] words, int emptyIdx, List<List<Integer>> result) {
        for (int i = 0; i < words.length; i++) {
            if (i != emptyIdx && isPalindrome(words[i], 0, words[i].length() - 1)) {
                result.add(List.of(i, emptyIdx));
                result.add(List.of(emptyIdx, i));
            }
        }
    }

    private boolean isPalindrome(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private class Trie {
        protected Node root;

        Trie() {
            root = new Node();
        }

        public void addWord(String word, int idx) {
            Node curr = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (isPalindrome(word, 0, i)) {
                    curr.setTerminal(idx);
                }
                curr = curr.getChild(word.charAt(i));
            }
            curr.lastIdx = idx;
            curr.setTerminal(idx);
        }

        public List<Integer> search(String word) {
            Set<Integer> result = new HashSet<>();
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                if (curr.hasChild(word.charAt(i))) {
                    curr = curr.getChild(word.charAt(i));
                } else {
                    return new ArrayList<>(result);
                }
                if (isPalindrome(word, i + 1, word.length() - 1)){
                    if(curr.lastIdx != -1){
                        result.add(curr.lastIdx);
                    }
                }
            }
            result.addAll(curr.getTerminalWords());
            return new ArrayList<>(result);
        }
    }

    private class Node {
        private Node[] children;
        private List<Integer> terminalWords;
        int lastIdx;

        public Node() {
            this.children = new Node[NUMBER_OF_LETTERS];
            terminalWords = new ArrayList<>();
            lastIdx = -1;
        }

        public Node getChild(char c) {
            int i = charToInt(c);
            if (children[i] == null) {
                children[i] = new Node();
            }
            return children[i];
        }

        public boolean hasChild(char c) {
            return children[charToInt(c)] != null;
        }

        public List<Integer> getTerminalWords() {
            return terminalWords;
        }

        public void setTerminal(int idx) {
            terminalWords.add(idx);
        }
    }

    private int charToInt(char c) {
        return c - 'a';
    }

}
