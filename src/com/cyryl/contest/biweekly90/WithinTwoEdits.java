package com.cyryl.contest.biweekly90;

import java.util.ArrayList;
import java.util.List;

public class WithinTwoEdits {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for (String query : queries) {
            for (String word : dictionary) {
                int mismatchCount = 0;
                for (int i = 0; i < word.length(); i++) {
                    if(query.charAt(i) != word.charAt(i)){
                        mismatchCount++;
                    }
                }
                if(mismatchCount <= 2){
                    result.add(query);
                    break;
                }
            }
        }
        return result;
    }
}
