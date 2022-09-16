package com.cyryl.daily.previous;

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */

public class SortedMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        return find(matrix, 0, 0, matrix.length, matrix[0].length, target);
    }

    private boolean find(int[][] matrix, int topX, int topY, int bottomX, int bottomY, int target) {
        if (topX > bottomX || topY > bottomY || topX >= matrix.length || topY >= matrix[0].length){
            return false;
        }
        if (topX == bottomX && topY == bottomY) {
            return matrix[topX][topY] == target;
        }
        int midX = (topX + bottomX) / 2;
        int midY = (topY + bottomY) / 2;

        if (target > matrix[midX][midY]) {
            return find(matrix, topX, midY + 1, midX, bottomY, target) ||
                    find(matrix, midX + 1, topY, bottomX, bottomY, target);
        } else if (target < matrix[midX][midY]) {
            return find(matrix, topX, midY, midX - 1, bottomY, target) ||
                    find(matrix, topX, topY, bottomX, midY - 1, target);
        } else {
            return true;
        }
    }
}
