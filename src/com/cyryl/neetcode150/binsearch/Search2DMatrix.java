package com.cyryl.neetcode150.binsearch;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = pickRow(matrix, 0, matrix.length - 1, target);
        return binSearch(matrix[row], 0, matrix[0].length - 1, target);
    }

    private int pickRow(int[][] matrix, int top, int bottom, int target) {
        int mid;
        while (top < bottom) {
            mid = (top + bottom) / 2;
            if (target >= matrix[mid][0] && target < matrix[mid + 1][0]) {
                return mid;
            } else if (target < matrix[mid][0]) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        return bottom;
    }

    private boolean binSearch(int[] arr, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
