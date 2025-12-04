package com.cyryl.daily.year2025.november;

public class FruitfulChildren {
    public int maxCollectedFruits(int[][] fruits) {
        int firstChildCount = 0;
        for (int i = 0; i < fruits.length; i++) {
            firstChildCount += fruits[i][i];
        }
        int len = fruits.length;
        int[][] memoryCount = new int[len][len];
        memoryCount[len - 1][0] = fruits[len - 1][0];
        for (int j = 1; j < len - 1; j++) {
            for (int i = len - 1; i >= len - j - 1 && i > j; i--) {
                memoryCount[i][j] = fruits[i][j];
                int prevMax = Math.max(memoryCount[i - 1][j - 1], memoryCount[i][j - 1]);
                if (i + 1 < len) {
                    prevMax = Math.max(prevMax, memoryCount[i + 1][j - 1]);
                }
                memoryCount[i][j] += prevMax;
            }
        }
        memoryCount[0][len - 1] = fruits[0][len - 1];
        for (int i = 1; i < fruits.length - 1; i++) {
            for (int j = len - 1; j >= len - i - 1 && j > i; j--) {
                memoryCount[i][j] = fruits[i][j];
                int prevMax = Math.max(memoryCount[i - 1][j - 1], memoryCount[i - 1][j]);
                if (j + 1 < len) {
                    prevMax = Math.max(prevMax, memoryCount[i - 1][j + 1]);
                }
                memoryCount[i][j] += prevMax;
            }
        }
        int totalCount = memoryCount[len - 1][len - 2] + memoryCount[len - 2][len - 1] + firstChildCount;
        return totalCount;
    }
}
