package com.cyryl.contest.virtual.weekly310;

public class OptimalPartition {
    public int partitionString(String s) {
        boolean[] visited = new boolean[26];
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if(visited[s.charAt(i) - 'a']){
                count++;
                visited = new boolean[26];
            }
            visited[s.charAt(i) - 'a'] = true;
        }
        return count;
    }
}
