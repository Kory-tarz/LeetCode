package com.cyryl.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class MaxEqualFrequency {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> numberOfOccurrence = new HashMap<>();
        int maxLength = 0;
        Set<Integer> oneOccur = new HashSet<>();
        int differentNumbers = 0;
        int curNumber;
        int curNumCount = 1;
        int maxEqualIndex = 0;

        for(int i=0; i<nums.length; i++){

            curNumber = nums[i];

            if(numberOfOccurrence.containsKey(curNumber)){

                curNumCount = numberOfOccurrence.get(curNumber);
                curNumCount++;
                numberOfOccurrence.put(curNumber, curNumCount);

            }else if (oneOccur.contains(curNumber)){

                oneOccur.remove(curNumber);
                differentNumbers++;
                curNumCount = 2;
                numberOfOccurrence.put(curNumber, curNumCount);

            }else{

                oneOccur.add(curNumber);

            }

            maxLength = Math.max(curNumCount, maxLength);

            // One different number, everything else has equal length
            if(curNumCount == maxLength && oneOccur.size() == 1 && isEqualFrequency(i, differentNumbers, maxLength)){
                maxEqualIndex = i;
            }

            // No single numbers, one frequency is one number longer than others
            if(curNumCount == maxLength-1 && oneOccur.isEmpty() && isEqualFrequency(i, differentNumbers, maxLength-1))
                maxEqualIndex = i;

            // All single numbers or one frequency length 2
            if(oneOccur.size() == i+1 || oneOccur.size() == i-1)
                maxEqualIndex = i;

            if(differentNumbers == 1 && oneOccur.isEmpty())
                maxEqualIndex = i;

        }
        return maxEqualIndex+1;
    }

    private boolean isEqualFrequency(int curIndex, int differentNumbers, int maxLength){
        return differentNumbers * maxLength == curIndex;
    }

}

