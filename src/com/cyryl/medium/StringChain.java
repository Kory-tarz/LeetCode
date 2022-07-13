package com.cyryl.medium;

import java.util.*;

public class StringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int max = 0;
        Map<String, Integer> parentLen = new HashMap<>();

        int currLen = words[words.length-1].length();
        int currIndex = words.length-1;
        int setIndex = words.length-1;

        while(setIndex >= 0 && words[setIndex].length() == currLen) setIndex--;

        while(setIndex >= 0){
            Set<String> shorterWords = new HashSet<>();
            int nextLen = words[setIndex].length();

            while (setIndex >= 0 && words[setIndex].length() == nextLen){
                shorterWords.add(words[setIndex]);
                setIndex--;
            }

            while (words[currIndex].length() == currLen){
                String currWord = words[currIndex];
                for (int i = 0; i < currLen; i++) {
                    StringBuilder sb = new StringBuilder(currWord);
                    String nextWord = sb.deleteCharAt(i).toString();
                    if(shorterWords.contains(nextWord)){
                        int len = parentLen.getOrDefault(currWord, currLen);
                        if(parentLen.getOrDefault(nextWord, 0) < len){
                            parentLen.put(nextWord, len);
                            max = Math.max(max, len - nextWord.length() + 1);
                        }
                    }
                }
                currIndex--;
            }
            currLen = nextLen;
        }
        return max;
    }
}
