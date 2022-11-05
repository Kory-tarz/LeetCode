package com.cyryl.contest.virtual.weekly316;

import java.util.Arrays;

public class TwoEventsHaveConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        final int START = 0;
        final int END = 1;
        int[] interval1 = convertToInterval(event1);
        int[] interval2 = convertToInterval(event2);

        if(interval1[START] < interval2[START]){
            return interval2[START] <= interval1[END];
        } else {
            return interval1[START] <= interval2[END];
        }
    }

    public int[] convertToInterval(String[] event){
        return new int[]{convertToNumber(event[0]), convertToNumber(event[1])};
    }

    public int convertToNumber(String time){
        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        return hours * 60 + minutes;
    }


}
