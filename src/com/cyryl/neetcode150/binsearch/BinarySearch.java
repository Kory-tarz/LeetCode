package com.cyryl.neetcode150.binsearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        return binary(nums, 0, nums.length - 1, target);
    }

    private int binary(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;

        if (nums[mid] > target) {
            return binary(nums, left, mid - 1, target);
        } else if (nums[mid] < target) {
            return binary(nums, mid + 1, right, target);
        } else {
            return mid;
        }
    }
}
