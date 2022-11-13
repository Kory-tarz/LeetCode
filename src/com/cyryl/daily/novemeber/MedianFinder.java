package com.cyryl.daily.novemeber;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    private final PriorityQueue<Integer> lows;
    private final PriorityQueue<Integer> highs;

    public MedianFinder() {
        lows = new PriorityQueue<>(Collections.reverseOrder());
        lows.offer(Integer.MIN_VALUE);
        highs = new PriorityQueue<>();
        highs.offer(Integer.MAX_VALUE);
    }

    public void addNum(int num) {
        assert !lows.isEmpty();
        assert !highs.isEmpty();
        if (lows.size() == highs.size()) {
            if (num > lows.peek()) {
                highs.offer(num);
                num = highs.poll();
            }
            lows.offer(num);
        } else {
            if (num < highs.peek()) {
                lows.offer(num);
                num = lows.poll();
            }
            highs.offer(num);
        }
    }

    public double findMedian() {
        if(lows.size() == highs.size()){
            return (lows.peek() + highs.peek()) / 2.0;
        } else {
            return lows.peek();
        }
    }
}
