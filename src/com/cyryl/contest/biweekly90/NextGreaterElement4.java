package com.cyryl.contest.biweekly90;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreaterElement4 {

    private final static int VAL = 0;
    private final static int IDX = 1;

    public int[] secondGreaterElement(int[] nums) {
        ArrayDeque<int[]> noneGreater = new ArrayDeque<>();
        ArrayDeque<int[]> oneGreater = new ArrayDeque<>();
        ArrayDeque<int[]> temp = new ArrayDeque<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!oneGreater.isEmpty() && oneGreater.peekFirst()[VAL] < nums[i]) {
                int[] element = oneGreater.pop();
                result[element[IDX]] = nums[i];
            }
            while (!noneGreater.isEmpty() && noneGreater.peekFirst()[VAL] < nums[i]) {
                temp.push(noneGreater.pop());
            }
            while (!temp.isEmpty()){
                oneGreater.push(temp.pop());
            }
            noneGreater.push(new int[]{nums[i], i});
        }
        return result;
    }
}
