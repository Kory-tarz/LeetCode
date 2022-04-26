package com.cyryl.hard;

public class MultipleSum {
    public boolean isPossible(int[] target) {

        if(target.length == 1)
            return target[0] == 1;

        int max = 0;
        int maxIndex = 0;
        int newMaxIndex = 0;
        int newMax = 0;
        long sum = 0;

        for(int i=0; i< target.length; i++){
            sum += target[i];
            if(target[i] > max){
                max = target[i];
                maxIndex = i;
            }
        }

        while(max > sum/2 && sum > 1){

            for(int i=0; i<target.length; i++){
                if(i != maxIndex){
                    if(target[i] > newMax){
                        newMax = target[i];
                        newMaxIndex = i;
                    }
                }
            }
            sum -= max;
            if(sum <= 1)
                return sum == 1;

            max = max % (int)sum;

            sum += max;
            target[maxIndex] = max;

            maxIndex = newMaxIndex;
            max = newMax;
            newMax = 0;
            System.out.println();
        }
        return sum == target.length;
    }
}
