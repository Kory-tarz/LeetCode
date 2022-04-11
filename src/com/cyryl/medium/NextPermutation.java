package com.cyryl.medium;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {

        int i=nums.length-1;
        boolean swapped = false;
        int index;
        boolean changedOrder = false;

        while (!swapped && i>0){
            if(nums[i] > nums[i-1]){
                index = findIndexOfNumberBetween(nums, i+1, nums[i], nums[i-1]);
                if(index < 0) {
                    if (i - 1 == 0)
                        swap(nums, 0 , i);
                    else
                        swap(nums, i - 1, i);
                }
                else {
                    swap(nums, i-1, index);
                }
                reverse(nums, i, nums.length-1);
                swapped = true;
            }else
                i--;
        }
        if(!swapped)
            reverse(nums,0, nums.length-1);
    }

    public static void swap(int[] nums, int indexA, int indexB){
        int temp;
        temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }

    public static void reverse(int[] nums, int i, int j){
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static int findIndexOfNumberBetween(int[] nums, int startingIndex, int a, int b){
        int number = a;
        int index = -1;
        for(int i=startingIndex; i<nums.length; i++){
            if(nums[i] <= number && nums[i] > b) {
                index = i;
                number = nums[i];
            }
        }
        return index;
    }
}
