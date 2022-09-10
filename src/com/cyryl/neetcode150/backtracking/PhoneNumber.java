package com.cyryl.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class PhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList<>();
        Queue<String> nextQueue = new LinkedList<>();
        queue.offer("");
        for (int i = 0; i < digits.length(); i++) {
            int mapping = digits.charAt(i) - '0';
            while (!queue.isEmpty()){
                String prevCombination = queue.poll();
                String letters =  map[mapping];
                for (int j = 0; j < letters.length(); j++) {
                    nextQueue.offer(prevCombination + letters.charAt(j));
                }
            }
            queue = nextQueue;
            nextQueue = new LinkedList<>();
        }
        return queue.stream().collect(Collectors.toList());
    }
}
