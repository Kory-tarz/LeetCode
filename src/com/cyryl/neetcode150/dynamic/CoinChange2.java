package com.cyryl.neetcode150.dynamic;

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] memory = new int[amount + 1];
        memory[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int currAmount = 1; currAmount <= amount; currAmount++) {
                if (currAmount - coins[i] >= 0) {
                    memory[currAmount] += memory[currAmount - coins[i]];
                }
            }
        }
        return memory[amount];
    }
}
