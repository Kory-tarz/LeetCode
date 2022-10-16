package com.cyryl.daily.october;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarThreeV2 {

    private Map<Integer, Integer> values;
    private Map<Integer, Integer> futureValues;

    private static final int MAX_BOUND = (int) 1e9;
    private static final int MIN_BOUND = 0;

    public MyCalendarThreeV2() {
        values = new TreeMap<>();
        futureValues = new TreeMap<>();
    }

    private void update(int start, int end, int left, int right, int idx) {
        if (start > right || end < left) {
            return;
        }
        if (start <= left && right <= end) {
            values.put(idx, values.getOrDefault(idx, 0) + 1);
            futureValues.put(idx, futureValues.getOrDefault(idx, 0) + 1);
        } else {
            int mid = (left + right) / 2;
            update(start, end, left, mid, idx * 2);
            update(start, end, mid + 1, right, idx * 2 + 1);
            values.put(idx, futureValues.getOrDefault(idx, 0)
                    + Math.max(
                    values.getOrDefault(idx * 2, 0),
                    values.getOrDefault(idx * 2 + 1, 0)));
        }
    }

    public int book(int start, int end) {
        update(start, end - 1, MIN_BOUND, MAX_BOUND, 1);
        return values.getOrDefault(1, 0);
    }
}
