package com.cyryl.contest.virtual.weekly309;

public class LetterDistance {
    public boolean checkDistances(String s, int[] distance) {
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = s.charAt(i) - 'a';
            if (distance[curr] == -1) {
                continue;
            }
            if (i - distance[curr] - 1 < 0 || s.charAt(i - distance[curr] - 1) != s.charAt(i)) {
                return false;
            }
            distance[curr] = -1;
        }
        return true;
    }
}
