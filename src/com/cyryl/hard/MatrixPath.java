package com.cyryl.hard;

public class MatrixPath {
    public int longestIncreasingPath(int[][] matrix) {

        int[][] memory = new int[matrix.length][matrix[0].length];
        int longestPath = 1;

        for(int i=0; i< matrix.length; i++)
            for(int j=0; j < matrix[i].length; j++){
                if(memory[i][j] > 0)
                    longestPath = Math.max(longestPath, memory[i][j]);
                else
                    longestPath = Math.max(longestPath, dfs(matrix, memory, -1, i, j));
            }
        return longestPath;
    }

    private int dfs(int[][] matrix, int[][] memory, int prev, int x, int y){

        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= prev)
            return 0;

        if(memory[x][y] > 0)
            return memory[x][y];

        int longestPath = 1 + dfs(matrix, memory, matrix[x][y], x+1, y);
        longestPath = Math.max(longestPath, 1 + dfs(matrix, memory, matrix[x][y], x-1, y));
        longestPath = Math.max(longestPath, 1 + dfs(matrix, memory, matrix[x][y], x, y+1));
        longestPath = Math.max(longestPath, 1 + dfs(matrix, memory, matrix[x][y], x, y-1));

        memory[x][y] = longestPath;
        Math.pow(prev,x);

        return longestPath;
    }
}
