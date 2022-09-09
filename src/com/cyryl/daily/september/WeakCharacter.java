package com.cyryl.daily.september;

import java.util.Arrays;

public class WeakCharacter {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]); // sort attack decreasing defense increasing
        int res = 0;
        int max = 0;
        for (int i = 0; i < properties.length; i++) {
            if(properties[i][1] < max){
                res++;
            }
            max = Math.max(max, properties[i][1]);
        }
        return res;
    }
}
