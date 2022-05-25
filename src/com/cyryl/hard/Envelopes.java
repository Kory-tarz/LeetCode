package com.cyryl.hard;

import java.util.Arrays;
import java.util.Comparator;

public class Envelopes {

    final int WIDTH = 0;
    final int HEIGHT = 1;

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) ->
                a[WIDTH] == b[WIDTH] ? Integer.compare(b[HEIGHT], a[HEIGHT]) : Integer.compare(a[WIDTH], b[WIDTH]));

        int[] lis = new int[envelopes.length+1];
        int maxIndex = 0;
        int currIndex;

        for(int i=0; i<envelopes.length; i++){
            currIndex = binarySearch(lis, envelopes[i][HEIGHT], 0, maxIndex);
            lis[currIndex] = envelopes[i][HEIGHT];
            maxIndex = Math.max(currIndex, maxIndex);
        }

        return maxIndex;
    }

    public int binarySearch(int[] arr, int val, int start, int end){
        int high = end;
        int low = start;

        int mid;

        while(low <= high){
            mid = (low + high) >>> 1;

            if(arr[mid] == val)
                return mid;

            if(arr[mid] > val){
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return high+1;
    }
}
