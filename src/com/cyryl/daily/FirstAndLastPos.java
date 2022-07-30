package com.cyryl.daily;

public class FirstAndLastPos {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{binSearchLeft(nums, target, 0, nums.length - 1),
                binSearchRight(nums, target, 0, nums.length - 1)};
    }

    public int binSearchLeft(int[] nums, int target, int left, int right) {
        if (left == right) {
            return nums[left] == target ? left : -1;
        }
        int mid = (left + right) >>> 1;

        if (target == nums[mid]) {
            if (mid - 1 > 0 && nums[mid - 1] == target) {
                return binSearchLeft(nums, target, left, mid-1);
            } else {
                return mid;
            }
        } else if (nums[mid] < target) {
            return binSearchLeft(nums, target, left, mid - 1);
        } else {
            return binSearchLeft(nums, target, mid + 1, right);
        }
    }

    public int binSearchRight(int[] nums, int target, int left, int right) {
        if (left == right) {
            return nums[right] == target ? right : -1;
        }
        int mid = (left + right) >>> 1;

        if (target == nums[mid]) {
            if (nums[mid + 1] == target) {
                return binSearchRight(nums, target, mid + 1, right);
            } else {
                return mid;
            }
        } else if (nums[mid] < target) {
            return binSearchRight(nums, target, left, mid - 1);
        } else {
            return binSearchRight(nums, target, mid + 1, right);
        }
    }
}
