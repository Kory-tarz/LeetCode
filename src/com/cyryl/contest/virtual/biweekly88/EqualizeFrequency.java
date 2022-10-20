package com.cyryl.contest.virtual.biweekly88;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EqualizeFrequency {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(freq[i] == 0){
                continue;
            }
            freq[i]--;
            if(areEqual(freq)){
                return true;
            }
            freq[i]++;
        }
        return false;
    }

    private boolean areEqual(int[] freq){
        int value = 0;
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] != 0){
                if(value == 0){
                    value = freq[i];
                } else if(freq[i] != value){
                    return false;
                }
            }
        }
        return true;
    }

}
