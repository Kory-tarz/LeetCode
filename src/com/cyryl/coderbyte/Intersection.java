package com.cyryl.coderbyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Intersection {

    public static String FindIntersection(String[] strArr) {
        List<Integer> a = Arrays.stream(strArr[0].split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> b = Arrays.stream(strArr[1].split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        int aIdx = 0;
        int bIdx = 0;
        List<String> result = new ArrayList<>();

        while (aIdx < a.size() && bIdx < b.size()){
            int aNum = a.get(aIdx);
            int bNum = b.get(bIdx);
            if(aNum == bNum){
                result.add(String.valueOf(aNum));
                aIdx++;
                bIdx++;
            } else if (aNum > bNum) {
                bIdx++;
            } else {
                aIdx++;
            }
        }
        if(result.size() == 0){
            return "";
        }
        return String.join(",", result);
    }
}
