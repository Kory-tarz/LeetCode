package com.cyryl.daily.september;

import java.util.*;


// BAD SOLUTION
public class PalindromePairs {

    private final int NUMBER_OF_LETTERS = 26;

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        Trie trie = new Trie();
        FirstCharTrie firstCharTrie = new FirstCharTrie();
        Trie reversedTrie = new Trie();
        FirstCharTrie reversedFirstCharTrie = new FirstCharTrie();

        for (int i = 0; i < words.length; i++) {
            Set<List<Integer>> partialResult = new HashSet<>();
            if (words[i].equals("")) {
                bruteEmpty(words, i, partialResult);
                result.addAll(partialResult);
                continue;
            }

            String reversedWord = new StringBuilder(words[i]).reverse().toString();

            searchTrieReversed(trie, partialResult, reversedWord, i);
            searchTrieReversed(firstCharTrie, partialResult, reversedWord, i);

            searchTrie(reversedTrie, partialResult, words[i], i);
            searchTrie(reversedFirstCharTrie, partialResult, words[i], i);

            reversedFirstCharTrie.addWord(reversedWord, i);
            reversedTrie.addWord(getWordWithoutFirstChar(reversedWord), i);

            firstCharTrie.addWord(words[i], i);
            trie.addWord(getWordWithoutFirstChar(words[i]), i);

            result.addAll(partialResult);
        }
        return result;
    }

    private void bruteEmpty(String[] words, int emptyIdx, Set<List<Integer>> result) {
        for (int i = 0; i < words.length; i++) {
            if(i != emptyIdx && isPalindrome(words[i])){
                result.add(List.of(i, emptyIdx));
                result.add(List.of(emptyIdx, i));
            }
        }
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if(word.charAt(left) != word.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void searchTrie(Trie trie, Set<List<Integer>> result, String word, int i) {
        List<Integer> search = trie.search(word);
        for (int idx : search) {
            if (idx != i) {
                result.add(List.of(idx, i));
            }
        }
    }

    private void searchTrieReversed(Trie trie, Set<List<Integer>> result, String word, int i) {
        List<Integer> search = trie.search(word);
        for (int idx : search) {
            if (idx != i) {
                result.add(List.of(i, idx));
            }
        }
    }

    private String getWordWithoutFirstChar(String word) {
        if (word.length() == 0) {
            return "";
        }
        char firstChar = word.charAt(0);
        int i = 1;
        while (i < word.length() && word.charAt(i) == firstChar) {
            i++;
        }
        return word.substring(i);
    }

    private class Trie {
        protected Node root;

        Trie() {
            root = new Node();
        }

        public void addWord(String word, int idx) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                curr = curr.getChild(word.charAt(i));
            }
            curr.setTerminal(idx);
        }

        public List<Integer> search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                if (curr.hasChild(word.charAt(i))) {
                    curr = curr.getChild(word.charAt(i));
                } else {
                    return new ArrayList<>();
                }
            }
            return curr.getTerminalWords();
        }
    }

    private class FirstCharTrie extends Trie {
        @Override
        public void addWord(String word, int idx) {
            Node curr = root;
            if (word.length() > 0) {
                char firstChar = word.charAt(0);
                curr = curr.getChild(firstChar);
                curr.setCycle(firstChar);
            }
            Node tempRoot = root;
            root = curr;
            super.addWord(getWordWithoutFirstChar(word), idx);
            root = tempRoot;
        }

    }

    private class Node {
        private Node[] children;
        private List<Integer> terminalWords;

        public Node() {
            this.children = new Node[NUMBER_OF_LETTERS];
            terminalWords = new ArrayList<>();
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

        public void setCycle(char c) {
            children[charToInt(c)] = this;
        }
    }

    private int charToInt(char c) {
        return c - 'a';
    }
}
