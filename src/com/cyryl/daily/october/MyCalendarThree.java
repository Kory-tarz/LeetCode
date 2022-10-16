package com.cyryl.daily.october;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/my-calendar-iii/
 */

public class MyCalendarThree {
    Map<Integer, Integer> calendar;
    public MyCalendarThree() {
         calendar = new TreeMap<>();
    }

    public int book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        int maxBooking = 0;
        int currBooking = 0;
        for (int events : calendar.values()){
            currBooking += events;
            maxBooking = Math.max(maxBooking, currBooking);
        }
        return maxBooking;
    }
}
