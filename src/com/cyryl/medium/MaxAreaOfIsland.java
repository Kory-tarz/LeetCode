package com.cyryl.medium;

public class MaxAreaOfIsland {

    private final int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private final int X = 0;
    private final int Y = 1;
    private final int VISITED = -1;
    private final int NEW_LAND = 1;

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == NEW_LAND){
                    maxArea = Math.max(dfs(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x >= grid.length || x < 0 || y < 0 || y >= grid[x].length || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = VISITED;
        int sumNeighbours = 0;
        for (int[] dir : DIR) {
            sumNeighbours += dfs(grid, x + dir[X], y + dir[Y]);
        }
        return 1 + sumNeighbours;
    }
}
