package com.cyryl.neetcode150.binsearch;

public class RotatedSorted {

    public static void main(String[] args) {
        RotatedSorted rotatedSorted = new RotatedSorted();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println((rotatedSorted.search(nums, 0)));
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        int pivot = findRotationPivot(nums, 0, len - 1);

        int absLeft = 0;
        int absRight = len;

        while (absLeft <= absRight) {
            int absMid = (absLeft + absRight) / 2;
            int mid = (absMid + pivot) % len;

            if(nums[mid] == target){
                return mid;
            } else if (target > nums[mid]) {
                absLeft = absMid + 1;
            } else {
                absRight = absMid - 1;
            }
        }
        return -1;
    }

    private int findRotationPivot(int[] nums, int left, int right) {
        int mid;
        while (left < right) {
            if (nums[left] < nums[right]) {
                return left;
            }
            mid = (left + right) / 2;

            if (nums[left] > nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
