package com.cyryl.neetcode150.binsearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 */

public class TimeMap {

    Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new TreeMap<>());
        timeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(timeMap.containsKey(key)){
            Map.Entry<Integer, String> prevTimestamp = timeMap.get(key).floorEntry(timestamp);
            if(prevTimestamp != null){
                return prevTimestamp.getValue();
            }
        }
        return "";
    }
}
