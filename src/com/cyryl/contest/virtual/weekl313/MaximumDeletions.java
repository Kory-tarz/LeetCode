package com.cyryl.contest.virtual.weekl313;

import java.util.ArrayList;
import java.util.List;

public class MaximumDeletions {
    public int deleteString(String s) {
        int[] memo = new int[s.length()];
        List<List<Integer>> nexts = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            nexts.add(KMP(s.substring(i)));
        }
        return helper(nexts, memo, 0, s);
    }

    private int helper(List<List<Integer>> nexts, int[] memo, int idx, String s) {
        if(idx >= s.length()){
            return 0;
        }
        if(nexts.size() == 0){
            return 1;
        }
        if(memo[idx] != 0){
            return memo[idx];
        }
        int max = 1;
        for (int next : nexts.get(idx)){
            max = Math.max(max, 1 + helper(nexts, memo, idx, s));
        }
        memo[idx] = max;
        return max;
    }


    public List<Integer> KMP(String s){
        int[] preSuf = new int[s.length()];
        int curr = 1;
        while (curr < s.length()){
            int len = preSuf[curr - 1];
            while (len > 0 && s.charAt(len) != s.charAt(curr)){
                len = preSuf[len];
            }
            if(s.charAt(curr) == s.charAt(len)){
                len++;
            }
            preSuf[curr] = len;
            curr++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(i - preSuf[i] + 1 == preSuf[i]) {
                result.add(i);
            }
        }
        System.out.println(s + ": " + result);
        return result;
    }
}
