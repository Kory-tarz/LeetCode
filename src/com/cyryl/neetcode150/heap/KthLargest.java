package com.cyryl.neetcode150.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class KthLargest {

    private final PriorityQueue<Integer> heap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = Arrays.stream(nums).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        while (heap.size() > k){
            heap.poll();
        }
    }

    public int add(int val) {
        heap.add(val);
        if(heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
