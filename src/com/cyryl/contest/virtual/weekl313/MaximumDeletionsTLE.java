package com.cyryl.contest.virtual.weekl313;

import java.util.HashMap;
import java.util.Map;

public class MaximumDeletionsTLE {

    public int deleteString(String s) {
        int[] memo = new int[s.length()];
        Map<String, Integer> memoStr = new HashMap<>();
        return helper(memo, memoStr,0, s);
    }

    private int helper(int[] memo, Map<String, Integer> memoStr, int idx, String s) {
        if(idx >= s.length()){
            return 0;
        }
        if(idx == s.length() - 1){
            return 1;
        }
        if(memo[idx] != 0){
            return memo[idx];
        }
        String currStr = s.substring(idx);
        if(memoStr.containsKey(currStr)){
            memo[idx] = memoStr.get(currStr);
            return memo[idx];
        }

        int max = 1;
        for (int len = 1; (idx + 2 * len - 1) < s.length(); len++) {
            if(isValidDeletion(currStr, len)){
                max = Math.max(max, 1 + helper(memo, memoStr, idx + len, s));
            }
        }
        memo[idx] = max;
        memoStr.putIfAbsent(currStr, max);
        return max;
    }


    public boolean isValidDeletion(String str, int len){
        int idx = 0;
        int reflectionIdx = idx + len;
        System.out.println(str + " " + len);
        while (idx < len){
            if(str.charAt(idx) != str.charAt(reflectionIdx)){
                return false;
            }
            idx++;
            reflectionIdx++;
        }
        return true;
    }
}
