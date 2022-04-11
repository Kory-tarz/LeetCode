package com.cyryl.medium;

public class JumpGameII {
    public static int jump(int[] nums) {
        if(nums.length == 1)
            return 0;

        int currentIndex = 0;
        int bestIndex;
        int bestValue;
        int currentValue;
        int currentRange = nums[0];
        int moveCount = 0;
        int minIndex = 1;

        while(currentRange+currentIndex < nums.length-1 ){
            bestIndex = 0;
            bestValue = 0;
            for(int i=minIndex; i<=currentIndex+currentRange; i++){
                if(nums[i] != 0){
                    currentValue = i + nums[i];
                    if(currentValue > bestValue){
                        bestValue = currentValue;
                        bestIndex = i;
                    }
                }
            }
            minIndex = currentIndex + currentRange + 1;
            currentIndex = bestIndex;
            currentRange = nums[bestIndex];
            moveCount++;
        }

        return moveCount+1;
    }
}
