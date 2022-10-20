package com.cyryl.contest.virtual.weekl313;

public class HourglassSum {
    public int maxSum(int[][] grid) {
        int maxSum = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                maxSum = Math.max(maxSum, calculate(grid, i, j));
            }
        }
        return maxSum;
    }

    private int calculate(int[][] grid, int x, int y) {
        int sum = grid[x+1][y+1];
        for (int i = 0; i < 3; i++) {
            sum += grid[x][y+i];
            sum += grid[x+2][y+i];
        }
        return sum;
    }
}
