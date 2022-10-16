package com.cyryl.daily.october;

/**
 * https://leetcode.com/problems/string-compression-ii/
 */

public class StringCompression {
    public int getLengthOfOptimalCompression(String s, int k) {
        int[][][] memo = new int[s.length()][k+1][2];
        return helper(memo, s, k, 0, ' ', 0);
    }

    private int helper(int[][][] memo, String s, int k, int idx, char prev, int multiple) {
        if(idx >= s.length()){
            return 0;
        }
        if(memo[idx][k][multiple] != 0){
            return memo[idx][k][multiple];
        }
        char curr = s.charAt(idx);
        int removeLen = Integer.MAX_VALUE;
        int keepLen = 0;
        if(curr == prev){
            if(multiple == 0){
                keepLen++;
            }
            keepLen += helper(memo, s, k, idx + 1, curr, 1);
        } else {
            keepLen++;
            keepLen += helper(memo, s, k, idx + 1, curr, 0);
        }
        if(k > 0) {
            removeLen = helper(memo, s, k-1, idx + 1, prev, multiple);
        }
        int result = Math.min(keepLen, removeLen);
        memo[idx][k][multiple] = result;
        return result;
    }

}
