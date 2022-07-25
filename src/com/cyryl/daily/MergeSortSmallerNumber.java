package com.cyryl.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSortSmallerNumber {

    private class ValIndex {
        int val;
        int idx;

        public ValIndex(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] result = new int[nums.length];
        ValIndex[] sorted = new ValIndex[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sorted[i] = new ValIndex(nums[i], i);
        }
        mergeSort(sorted, 0, nums.length - 1, result);
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    private void mergeSort(ValIndex[] arr, int start, int end, int[] result) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid, result);
        mergeSort(arr, mid + 1, end, result);
        int left = start;
        int right = mid + 1;
        List<ValIndex> merged = new ArrayList<>();
        int mergedFromRight = 0;
        while (left <= mid && right <= end) {
            if (arr[left].val > arr[right].val) {
                mergedFromRight++;
                merged.add(arr[right]);
                right++;
            } else {
                result[arr[left].idx] += mergedFromRight;
                merged.add(arr[left]);
                left++;
            }
        }
        while (left <= mid){
            result[arr[left].idx] += mergedFromRight;
            merged.add(arr[left]);
            left++;
        }
        while (right <= end){
            merged.add(arr[right]);
            right++;
        }
        for (int i = start; i <= end; i++) {
            arr[i] = merged.get(i - start);
        }
    }
}
