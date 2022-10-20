package com.cyryl.contest.virtual.weekly314;

public class PathsSum {

    private final static int MOD = (int)1e9 + 7;

    public int numberOfPaths(int[][] grid, int k) {
        Integer[][][] memo = new Integer[grid.length][grid[0].length][k];

        return helper(memo, grid, 0, 0, 0, k);
    }

    private int helper(Integer[][][] memo, int[][] grid, int x, int y, int prevSum, int k) {
        if(x >= grid.length || y >= grid[x].length){
            return 0;
        }
        int currSum = (prevSum + grid[x][y]) % MOD;
        if(x == grid.length - 1 && y == grid.length -1){
            return currSum % k == 0 ? 1 : 0;
        }
        int divRemainder = currSum % k;
        if(memo[x][y][divRemainder] != null){
            return memo[x][y][divRemainder];
        }
        int result = helper(memo, grid, x + 1, y, currSum, k)
                + helper(memo, grid, x, y + 1, currSum, k);
        memo[x][y][divRemainder] = result;
        return result;
    }
}
