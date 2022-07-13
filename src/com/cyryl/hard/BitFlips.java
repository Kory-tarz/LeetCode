package com.cyryl.hard;

public class BitFlips {
    public int minKBitFlips(int[] nums, int k) {
        int[] flipCount = new int[nums.length];
        int moveCount = 0;
        int sum = 0;

        int i=0;
        while(i <= nums.length-k){
            sum+=flipCount[i];
            if(sum % 2 == nums[i]){
                flipCount[i] += 1;
                if(i + k < nums.length)
                    flipCount[i+k] -= 1;
                sum++;
                moveCount++;
            }
            i++;
        }
        sum = 0;
        for(int m=0; m<nums.length; m++){
            sum += flipCount[m];
            if(sum % 2 == nums[m])
                return -1;
        }
        return moveCount;
    }

    private void print(int[] arr){
        System.out.println("-----");
        for(int el : arr){
            System.out.print(el + " ");
        }
        System.out.println("-----");
    }
}
