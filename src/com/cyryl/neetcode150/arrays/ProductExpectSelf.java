package com.cyryl.neetcode150.arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * more ideas:
 * - we can get rid of leftProduct and rightProduct Arrays and calculate result values on the fly doing forward and backward pass.
 *
 */

public class ProductExpectSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        leftProduct[0] = nums[0];
        rightProduct[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = nums[i] * leftProduct[i - 1];
            int revIndex = nums.length - i - 1;
            rightProduct[revIndex] = nums[revIndex] * rightProduct[revIndex + 1];
        }
        int[] result = new int[nums.length];
        result[0] = rightProduct[1];
        result[nums.length - 1] = leftProduct[nums.length - 2];

        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = leftProduct[i - 1] * rightProduct[i + 1];
        }
        return result;
    }
    // more memory efficient solution
    public int[] productExceptSelf2(int[] nums){
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i-1] * result[i-1];
        }
        int rightProduct = nums[nums.length-1];
        for (int i = nums.length - 2; i>=0; i--){
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
}



