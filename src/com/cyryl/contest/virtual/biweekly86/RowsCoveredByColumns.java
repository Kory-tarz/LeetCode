package com.cyryl.contest.virtual.biweekly86;

public class RowsCoveredByColumns {
    public int maximumRows(int[][] matrix, int numSelect) {
        int[][] memo = new int[matrix.length][matrix[0].length];

        return helper(matrix, memo, 0, numSelect);
    }

    public int helper(int[][] grid, int[][] memo, int column, int selections) {
        if (column >= grid[0].length) {
            if (selections > 0) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                if (memo[i][column - 1] != -1) {
                    count++;
                }
            }
            return count;
        }
        int pick = 0;
        if (selections > 0) {
            // pick
            for (int i = 0; i < grid.length; i++) {
                if (column > 0) {
                    memo[i][column] = memo[i][column - 1];
                }
            }
            pick = helper(grid, memo, column + 1, selections - 1);
        }
        // dont
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][column] == 1) {
                memo[i][column] = -1;
            }
        }
        int dont = helper(grid, memo, column + 1, selections);
        return Math.max(pick, dont);
    }
}
