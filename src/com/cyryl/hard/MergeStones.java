package com.cyryl.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeStones {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if(k>n|| (k>2 && n%(k-1)!= 1))
            return -1;

        PriorityQueue<int[]> heap = new PriorityQueue<>( (a, b) -> Integer.compare(a[1], b[1]));

        int[] currentValue = new int[n];
        int[] currentIndex = new int[n];

        for(int i=0; i<n; i++){
            currentIndex[i] = i;
        }

        Arrays.fill(currentValue, -1);

        int sum = 0;
        for(int i=0; i<k; i++){
            sum += stones[i];
        }

        heap.offer(new int[]{0, sum});
        currentValue[0] = sum;

        for(int i=1; i<=n-k; i++){
            sum = sum - stones[i-1] + stones[i+k-1];
            heap.offer(new int[]{i, sum});
            currentValue[i] = sum;
        }

        int[] bestPile;

        while(heap.size() > 1){

            bestPile = heap.poll();
            // check if pile was updated in the meantime
            if(currentValue[bestPile[0]] != bestPile[1])
                continue;

            int index = findCurrIndex(currentIndex, bestPile[0]);
            int stoneSum = bestPile[1];

            

        }

        return 20;
    }

    private void updateLeft(int[] stones, int[] values, int[] currIndex, int stoneSum, int index, int k) {
    }

    int findCurrIndex(int[] currIndex, int i){
        if(currIndex[i] == i)
            return i;
        else
            currIndex[i] = findCurrIndex(currIndex, currIndex[i]);
        return currIndex[i];
    }

}
