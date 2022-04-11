package com.cyryl.medium;

public class JumpGameIII {
    static boolean[] visited;

    public static boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        visited[start] = true;
        return checkLeft(arr, start) || checkRight(arr, start);
    }

    private static boolean checkLeft(int[] arr, int index){
        int newPos = index - arr[index];
        if(newPos < 0)
            return false;
        if(arr[newPos] == 0)
            return true;
        else if (visited[newPos])
            return false;
        else {
            visited[newPos] = true;
            return checkLeft(arr, newPos) || checkRight(arr, newPos);
        }
    }

    private static boolean checkRight(int[] arr, int index){
        int newPos = index + arr[index];
        if(newPos >= arr.length)
            return false;
        if(arr[newPos] == 0)
            return true;
        else if (visited[newPos])
            return false;
        else {
            visited[newPos] = true;
            return checkLeft(arr, newPos) || checkRight(arr, newPos);
        }
    }
}
