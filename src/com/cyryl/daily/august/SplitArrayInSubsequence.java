package com.cyryl.daily.august;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SplitArrayInSubsequence {


    public boolean isPossible(int[] nums) {

        int head = 0;
        int nextInStack = -1;
        int tail = 0;

        int[] stack = new int[nums.length];
        stack[0]++;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                if(nextInStack < tail){
                    head++;
                    nextInStack = tail;
                    stack[head]++;
                } else {
                    stack[nextInStack]++;
                    nextInStack--;
                }
            } else if (nums[i] - nums[i-1] == 1) {
                tail = nextInStack + 1;
                stack[head]++;
                nextInStack = head - 1;
            } else {
                head++;
                stack[head]++;
                nextInStack = head - 1;
                tail = head;
            }
        }
        System.out.println(Arrays.toString(stack));
        for (int i = 0; i <= head; i++) {
            if(stack[i] < 3){
                return false;
            }
        }
        return true;
    }
}
