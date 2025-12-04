package com.cyryl.daily.year2025.november;

import java.util.function.Predicate;

public class MountainChains {

    public int longestMountain(int[] arr) {
        int leftSummit = 0;
        int leftBottom = leftSummit;
        int rightSummit = arr.length - 1;
        int rightBottom = rightSummit;
        int highestSummit = Math.max(arr[leftSummit], arr[rightSummit]);
        while (leftSummit < rightSummit) {
            if (arr[leftSummit] <= arr[rightSummit]) {
                int finalRightSummit = rightSummit;
                leftBottom = findMountainBottom(arr, leftSummit, 1, pos -> pos < finalRightSummit);
                leftSummit = findPotentialNextSummit(arr, leftBottom, 1, pos -> pos < finalRightSummit);
            } else {
                int finalLeftSummit = leftSummit;
                rightBottom = findMountainBottom(arr, rightSummit, -1, pos -> pos > finalLeftSummit);
                rightSummit = findPotentialNextSummit(arr, rightBottom, -1, pos -> pos > finalLeftSummit);
            }
            if (leftSummit == rightSummit && arr[leftSummit] > highestSummit && isSummit(arr, leftSummit)) {
                return rightBottom - leftBottom + 1;
            }
        }
        return 0;
    }

    private boolean isSummit(int[] arr, int pos) {
        return arr[pos] > arr[pos - 1] && arr[pos] > arr[pos + 1];
    }

    private int findPotentialNextSummit(int[] arr, int startingPos, int dir, Predicate<Integer> bound) {
        int currPos = startingPos;
        while (bound.test(currPos) && arr[currPos] < arr[currPos + dir]) {
            currPos += dir;
        }
        return currPos;
    }

    private int findMountainBottom(int[] arr, int startingPos, int dir, Predicate<Integer> bound) {
        int currPos = startingPos;
        while (bound.test(currPos) && arr[currPos] >= arr[currPos + dir]) { // traverse equal or downhill terrain
            currPos += dir;
        }
        return currPos;
    }
}
