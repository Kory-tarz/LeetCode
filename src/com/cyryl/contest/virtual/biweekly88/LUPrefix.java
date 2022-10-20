package com.cyryl.contest.virtual.biweekly88;

public class LUPrefix {

    private int needed;
    boolean[] videos;

    public LUPrefix(int n) {
        videos = new boolean[n + 2];
        needed = 1;
    }

    public void upload(int video) {
        videos[video] = true;
        while (videos[needed]){
            needed++;
        }
    }

    public int longest() {
        return needed - 1;
    }
}
