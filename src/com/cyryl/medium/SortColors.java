package com.cyryl.medium;

public class SortColors {
    public static void sortColors(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        int currentIndex = 0;

        while(currentIndex<=rightIndex){
            if(nums[currentIndex] == 2) {
                swap(nums, currentIndex, rightIndex);
                rightIndex--;
            }else if(nums[currentIndex] == 0){
                if(currentIndex == leftIndex){
                    currentIndex++;
                }
                else{
                    swap(nums, currentIndex, leftIndex);
                }
                leftIndex++;
            }else{
                currentIndex++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
