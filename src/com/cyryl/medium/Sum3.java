package com.cyryl.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sum3 {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> triple;
        Arrays.sort(nums);
        int maxNumIndex;
        int minNumIndex;
        int sum;

        for(int i=0; i<nums.length-2;i++){
            maxNumIndex = nums.length-1;
            minNumIndex = i+1;

            if(nums[i] <= 0 && (i == 0 || nums[i] != nums[i - 1])){
                while(minNumIndex < maxNumIndex) {

                    sum = nums[i] + nums[minNumIndex] + nums[maxNumIndex];

                    if(sum == 0){

                        triple = new ArrayList<>();
                        Collections.addAll(triple, nums[i], nums[minNumIndex], nums[maxNumIndex]);
                        result.add(triple);

                        while (minNumIndex < maxNumIndex && nums[minNumIndex + 1] == nums[minNumIndex])
                            minNumIndex++;

                        while (minNumIndex < maxNumIndex && nums[maxNumIndex - 1] == nums[maxNumIndex])
                            maxNumIndex--;

                        minNumIndex++;
                        maxNumIndex--;

                    }else if(sum < 0)
                        minNumIndex++;
                    else
                        maxNumIndex--;
                }
            }
        }
        return result;
    }
}


