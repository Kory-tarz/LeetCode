package com.cyryl.daily.august;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class MaxSumOfRectangle {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        Map<Rectangle, Integer> memo = new HashMap<>();
        int[][] preSumRow = new int[matrix.length][matrix[0].length];
        int[][] preSumCol = new int[matrix.length][matrix[0].length];
        // prefix sum of rows
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                preSumRow[i][j] = sum;
            }
        }
        // prefix sum of columns
        for (int i = 0; i < matrix[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[j][i];
                preSumCol[j][i] = sum;
            }
        }

        int totalSum = Arrays.stream(matrix).flatMapToInt(IntStream::of).sum();

        return solve(memo, preSumCol, preSumRow, new Rectangle(0, 0, matrix.length - 1, matrix[0].length - 1), totalSum, k);
    }

    private int solve(Map<Rectangle, Integer> memo, int[][] preSumCol, int[][] preSumRow, Rectangle rectangle, int currSum, int k) {
        if(memo.containsKey(rectangle)){
            return memo.get(rectangle);
        }
        if(!rectangle.isValid()){
            return Integer.MIN_VALUE;
        }
        System.out.println("Rectangle: " + rectangle + " and sum = " + currSum);

        int bestSum = currSum <= k ? currSum : Integer.MIN_VALUE;
        int removedSum;
        int newSum;
        Rectangle newRectangle;
        // remove top row
        removedSum = preSumRow[rectangle.topX][rectangle.bottomY] - preSumRow[rectangle.topX][rectangle.topY];
        newRectangle = rectangle.getCopy();
        newRectangle.topX++;
        newSum = currSum - removedSum;
        bestSum = Math.max(bestSum, solve(memo, preSumCol, preSumRow, newRectangle, newSum, k));

        // remove left column
        removedSum = preSumCol[rectangle.bottomX][rectangle.topY] - preSumCol[rectangle.topX][rectangle.topY];
        newRectangle = rectangle.getCopy();
        newRectangle.topY++;
        newSum = currSum - removedSum;
        bestSum = Math.max(bestSum, solve(memo, preSumCol, preSumRow, newRectangle, newSum, k));

        // remove bottom row
        removedSum = preSumRow[rectangle.bottomX][rectangle.bottomY] - preSumRow[rectangle.bottomX][rectangle.topY];
        newRectangle = rectangle.getCopy();
        newRectangle.bottomX--;
        newSum = currSum - removedSum;
        bestSum = Math.max(bestSum, solve(memo, preSumCol, preSumRow, newRectangle, newSum, k));

        // remove right column
        removedSum = preSumCol[rectangle.bottomX][rectangle.bottomY] - preSumCol[rectangle.topX][rectangle.bottomY];
        newRectangle = rectangle.getCopy();
        newRectangle.bottomY--;
        newSum = currSum - removedSum;
        bestSum = Math.max(bestSum, solve(memo, preSumCol, preSumRow, newRectangle, newSum, k));

        memo.put(rectangle, bestSum);
        return bestSum;
    }

    private int calcSum(int[][] preSum, int x, int y){
        if(x < 0 || y < 0){
            return 0;
        } else {
            return preSum[x][y];
        }
    }


    private class Rectangle {
        int topX;
        int topY;
        int bottomX;
        int bottomY;

        public Rectangle(int topX, int topY, int bottomX, int bottomY) {
            this.topX = topX;
            this.topY = topY;
            this.bottomX = bottomX;
            this.bottomY = bottomY;
        }

        public Rectangle getCopy(){
            return new Rectangle(topX, topY, bottomX, bottomY);
        }

        public boolean isValid(){
            return topX < bottomX && topY < bottomY;
        }

        @Override
        public int hashCode() {
            return Objects.hash(topX, topY, bottomX, bottomY);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Rectangle other) {
                return
                        this.bottomX == other.bottomX &&
                        this.bottomY == other.bottomY &&
                        this.topX == other.topX &&
                        this.topY == other.topY;
            } else {
                return super.equals(obj);
            }
        }

        @Override
        public String toString() {
            return String.format("TOP(%s, %s), BOTTOM(%s, %s)", topX, topY, bottomX, bottomY);
        }
    }
}
