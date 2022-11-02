package com.cyryl.medium;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class NextGreat {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&  nums2[stack.peekFirst()] < nums2[i]){
                stack.pop();
            }
            resultMap.put(nums2[i], stack.isEmpty() ? -1 : nums2[stack.peekFirst()]);
            stack.push(i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultMap.get(nums1[i]);
        }
        return result;
    }
}
