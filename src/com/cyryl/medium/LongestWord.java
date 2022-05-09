package com.cyryl.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LongestWord {
    public String findLongestWord(String s, List<String> dictionary) {

        TreeSet<Integer>[] stringRep = new TreeSet[26];
        String bestResult = "";

        for(int i=0; i<stringRep.length; i++)
            stringRep[i] = new TreeSet<>();

        for(int i=0; i<s.length(); i++){
            stringRep[charToInt(s.charAt(i))].add(i);
        }


        for(String word : dictionary){
            int wordIndex = 0;
            Integer sIndex = -1;

            while(sIndex != null && wordIndex < word.length()){
                sIndex = stringRep[charToInt(word.charAt(wordIndex))].ceiling(sIndex);
                wordIndex++;
            }

            if(sIndex != null && wordIndex == word.length())
                bestResult = updateBest(bestResult, word);
        }
        return bestResult;
    }

    private String updateBest(String currBest, String word) {
        if(word.length() > currBest.length())
            return word;
        if(currBest.length() > word.length())
            return currBest;

        if(currBest.compareTo(word) <= 0)
            return currBest;
        else
            return word;
    }


    private int charToInt(char c){
        return c - 'a';
    }
}
