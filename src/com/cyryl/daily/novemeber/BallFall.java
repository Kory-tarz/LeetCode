package com.cyryl.daily.novemeber;

/**
 * https://leetcode.com/problems/where-will-the-ball-fall/
 */

public class BallFall {

    private final static int GO_RIGHT = 1;
    private final static int GO_LEFT = -1;

    public int[] findBall(int[][] grid) {
        int nrOfBalls = grid[0].length;
        int[] result = new int[nrOfBalls];
        for (int i = 0; i < nrOfBalls; i++) {
            result[i] = dropBall(grid, 0, i);
        }
        return result;
    }

    private int dropBall(int[][] grid, int x, int y) {
        if (x >= grid.length) {
            return y;
        }
        if (grid[x][y] == GO_RIGHT) {
            if (y + 1 >= grid[0].length || grid[x][y + 1] == GO_LEFT) {
                return -1;
            }
            return dropBall(grid, x + 1, y + 1);
        } else {
            if (y - 1 <= grid[0].length || grid[x][y - 1] == GO_RIGHT){
                return -1;
            }
            return dropBall(grid, x + 1, y - 1);
        }
    }
}
