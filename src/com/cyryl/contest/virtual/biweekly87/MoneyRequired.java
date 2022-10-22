package com.cyryl.contest.virtual.biweekly87;

import java.util.Collections;

public class MoneyRequired {

    private final static int COST = 0;
    private final static int CASHBACK = 1;

    public long minimumMoney(int[][] transactions) {
        long totalLoss = 0;
        for (int[] transaction : transactions) {
            if (transaction[COST] > transaction[CASHBACK]) {
                totalLoss += transaction[COST] - transaction[CASHBACK];
            }
        }
        long minMoney = totalLoss;
        for (int[] transaction : transactions) {
            if (transaction[COST] > transaction[CASHBACK]) {
                totalLoss -= transaction[COST] - transaction[CASHBACK];
                minMoney = Math.max(minMoney, totalLoss + transaction[COST]);
                totalLoss += transaction[COST] - transaction[CASHBACK];
            } else {
                minMoney = Math.max(minMoney, totalLoss + transaction[COST]);
            }
        }
        return minMoney;
    }
}
