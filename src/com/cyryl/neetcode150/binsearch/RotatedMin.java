package com.cyryl.neetcode150.binsearch;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */

public class RotatedMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right){
            mid = (left + right) >> 1;

            if(nums[left] < nums[right]){
                return nums[left];
            }

            if(nums[left] <= nums[mid]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }



}
