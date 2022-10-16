package com.cyryl.contest.biweekly89;

public class ClockTimes {
    public int countTime(String time) {
        String[] timeParts = time.split(":");
        return hourPossibilities(timeParts[0]) * minutePossibilities(timeParts[1]);
    }

    private int minutePossibilities(String time){
        int first = time.charAt(0) == '?' ? 6 : 1;
        int second = time.charAt(1) == '?' ? 10 : 1;
        return first * second;
    }

    private int hourPossibilities(String time){
        if(time.charAt(0) == '?' && time.charAt(1) == '?'){
            return 24;
        }
        if(time.charAt(0) == '?'){
            if(time.charAt(1) >= '4'){
                return 2;
            } else {
                return 3;
            }
        }
        if(time.charAt(1) == '?'){
            if(time.charAt(0) <= '1'){
                return 10;
            } else {
                return 4;
            }
        }
        return 1;
    }
}
