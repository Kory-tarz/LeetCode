package com.cyryl.daily.novemeber;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/word-search-ii/
 */

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        Trie trie = new Trie();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (String word : words) {
            trie.insert(word);
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                dfs(board, visited, x, y, trie.root, new StringBuilder(), result);
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    private void dfs(char[][] board, boolean[][] visited, int x, int y, Trie.Node node, StringBuilder stringBuilder, Set<String> result) {
        if (node == null || x < 0 || x >= board.length || y < 0 || y >= board[x].length || visited[x][y]) {
            return;
        }
        node = node.getChild(board[x][y]);
        if(node == null){
            return;
        }
        stringBuilder.append(board[x][y]);
        if (node.isTerminal()) {
            result.add(stringBuilder.toString());
        }
        visited[x][y] = true;
        dfs(board, visited, x + 1, y, node, stringBuilder, result);
        dfs(board, visited, x - 1, y, node, stringBuilder, result);
        dfs(board, visited, x, y + 1, node, stringBuilder, result);
        dfs(board, visited, x, y - 1, node, stringBuilder, result);
        visited[x][y] = false;
        stringBuilder.setLength(stringBuilder.length() - 1);
    }

    private class Trie {

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                node = node.getChildOrCreate(word.charAt(i));
            }
            node.setTerminal();
        }

        private class Node {
            private final Node[] children;
            private boolean terminal;

            Node() {
                children = new Node[26];
                terminal = false;
            }

            public Node getChild(char c) {
                return children[c - 'a'];
            }

            public Node getChildOrCreate(char c) {
                if (children[c - 'a'] == null) {
                    children[c - 'a'] = new Node();
                }
                return children[c - 'a'];
            }

            public void setTerminal() {
                terminal = true;
            }

            public boolean isTerminal() {
                return terminal;
            }
        }
    }
}
