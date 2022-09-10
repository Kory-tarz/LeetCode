package com.cyryl.neetcode150.backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(findWord(board, used, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, boolean[][] used, int x, int y, String word, int letter) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[x].length || used[x][y]){
            return false;
        }
        if(word.charAt(letter) != board[x][y]){
            return false;
        }
        if(letter == word.length()-1){
            return true;
        }
        used[x][y] = true;
        boolean result = findWord(board, used, x + 1, y, word, letter + 1);
        result = result || findWord(board, used, x - 1, y, word, letter  + 1);
        result = result || findWord(board, used, x, y + 1, word, letter  + 1);
        result = result || findWord(board, used, x, y - 1, word, letter  + 1);
        used[x][y] = false;
        return result;
    }
}
