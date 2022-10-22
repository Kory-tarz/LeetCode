package com.cyryl.contest.virtual.biweekly87;

public class DaysTogether {

    private final static int[] DAYS_PER_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int leftBound = Math.max(convertDateToDayOfTheYear(arriveAlice), convertDateToDayOfTheYear(arriveBob));
        int rightBound = Math.min(convertDateToDayOfTheYear(leaveAlice), convertDateToDayOfTheYear(leaveBob));
        int result = rightBound - leftBound + 1;
        return Math.max(result, 0);
    }

    public int convertDateToDayOfTheYear(String date){
        String[] parts = date.split("-");
        int months = Integer.parseInt(parts[0]);
        int days = Integer.parseInt(parts[1]);
        int dayCount = 0;
        for (int i = 1; i < months; i++) {
            dayCount += DAYS_PER_MONTH[i-1];
        }
        dayCount += days;
        return dayCount;
    }
}
