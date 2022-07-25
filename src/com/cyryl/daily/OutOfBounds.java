package com.cyryl.daily;

/**
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
 * You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary).
 * You can apply at most maxMove moves to the ball.
 * <p>
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary.
 * Since the answer can be very large, return it modulo 109 + 7.
 */

public class OutOfBounds {

    public final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private final int X = 0;
    private final int Y = 1;
    private final int MOD = (int) 1e9 + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] grid = new int[m][n][2];

        for (int move = 1; move <= maxMove; move++) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    for (int[] dir : DIRS) {
                        grid[i][j][move % 2] = (int) (((long) grid[i][j][move % 2] + movesFromPos(grid, i + dir[X], j + dir[Y], move-1)) % MOD);
                    }
                }
            }
        }
        return grid[startRow][startColumn][maxMove%2];
    }

    private int movesFromPos(int[][][] grid, int x, int y, int moveNr) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length) {
            return 1;
        }
        return grid[x][y][moveNr%2];
    }
}
