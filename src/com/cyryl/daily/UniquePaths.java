package com.cyryl.daily;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[Math.max(m+1,n+1)][Math.max(m+1,n+1)];
        return path(memo, m, n);
    }

    int path(int[][] memo, int m, int n){
        if (m == 1 || n == 1) {
            return 1;
        }
        if(memo[m][n] != 0){
            return memo[m][n];
        }
        if(memo[n][m] != 0){
            return memo[n][m];
        }

        memo[m][n] = path(memo,m - 1, n) + path(memo, m, n - 1);
        return memo[m][n];
    }
}
