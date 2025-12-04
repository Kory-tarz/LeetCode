package com.cyryl.daily.year2025.november;

import java.util.*;
import java.util.stream.Collectors;

class TweetCounts {
    private Map<String, List<Integer>> analytics;
    private static Map<String, Integer> FREQUENCIES = Map.of(
        "hour", 60 * 60,
        "minute", 60,
        "day", 60 * 60 * 24
    );

    public TweetCounts() {
         analytics = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        List<Integer> times = analytics.getOrDefault(tweetName, new ArrayList<>());
        times.add(time);
        analytics.put(tweetName, times);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> tweetTimes = analytics.get(tweetName);
        int intervals = (endTime - startTime) / FREQUENCIES.get(freq) + 1;
        int[] counts = new int[intervals];
        tweetTimes.forEach(tweetTime -> {
            if (tweetTime >= startTime && tweetTime <= endTime) {
                int shiftedTime = tweetTime - startTime;
                int interval = shiftedTime / FREQUENCIES.get(freq);
                counts[interval]++;
            }
        });
        return Arrays.stream(counts).boxed().collect(Collectors.toList());
    }

}
