package com.cyryl.medium;

import java.util.*;

public class QueueReconstruction {

    private final int HEIGHT = 0;
    private final int PEOPLE_IN_FRONT = 1;

    public int[][] reconstructQueue(int[][] people) {
        
        int[][] result = new int[people.length][];
        Arrays.sort(people, (a, b) -> a[HEIGHT] == b[HEIGHT] ? b[PEOPLE_IN_FRONT] - a[PEOPLE_IN_FRONT] : a[HEIGHT] - b[HEIGHT]);
        for (int[] person : people){
            insertAtEmptyIndex(result, person, person[PEOPLE_IN_FRONT]);
        }
        return result;
    }

    private void insertAtEmptyIndex(int[][] arr, int[] person, int index){
        int currIndex = 0;
        int emptyCount = 0;

        while (true){
            if(arr[currIndex] == null){
                if(emptyCount == index) {
                    arr[currIndex] = new int[]{person[HEIGHT], person[PEOPLE_IN_FRONT]};
                    return;
                }else{
                    emptyCount++;
                }
            }
            currIndex++;
        }
    }
}
