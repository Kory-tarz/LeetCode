package com.cyryl.contest.virtual.weekly308;

public class RemovingStars {
    public String removeStars(String s) {
        int[] charToRemove = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                charToRemove[i] = i - 1;
            } else {
                charToRemove[i] = i;
            }
        }
        boolean[] removed = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                removed[i] = true;
                int rmvIdx = remove(charToRemove, i);
                charToRemove[rmvIdx] = rmvIdx - 1;
                removed[rmvIdx] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(!removed[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public int remove(int[] arr, int idx) {
        if (arr[idx] != idx){
            arr[idx] = remove(arr, arr[idx]);
        }
        return arr[idx];
    }
}
