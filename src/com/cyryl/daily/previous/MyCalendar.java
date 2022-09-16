package com.cyryl.daily.previous;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {

    private TreeMap<Integer, Integer> bookings;

    public MyCalendar() {
        bookings = new TreeMap<>();
        bookings.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
        bookings.put(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> smallerKey = bookings.floorEntry(start);
        Map.Entry<Integer, Integer> biggerKey = bookings.ceilingEntry(start);
        if (smallerKey.getValue() <= start && biggerKey.getKey() >= end){
            bookings.put(start, end);
            return true;
        }
        return false;
    }
}
