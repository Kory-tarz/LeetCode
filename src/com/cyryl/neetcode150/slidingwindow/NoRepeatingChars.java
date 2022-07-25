package com.cyryl.neetcode150.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastCharPos = new HashMap<>();
        int maxLen = 0;
        int leftIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (lastCharPos.containsKey(curChar)) {
                int lastPos = lastCharPos.get(curChar);
                leftIndex = Math.max(lastPos + 1, leftIndex);
            }
            System.out.println(leftIndex);
            maxLen = Math.max(i - leftIndex + 1, maxLen);
            System.out.println(maxLen);
            lastCharPos.put(curChar, i);
        }
        return maxLen;
    }
}
