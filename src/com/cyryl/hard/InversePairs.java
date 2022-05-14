package com.cyryl.hard;

import java.util.Arrays;

public class InversePairs {

    static final int[] sum = integerSum();
    static final int MAX_N = 1000;

    int[][] memory;
    final int MOD = (int)1e9 + 7;

    static int[] integerSum(){
        int[] sum = new int[MAX_N + 1];
        for(int i=1; i<sum.length; i++)
            sum[i] = i + sum[i-1];
        return sum;
    }

    public int kInversePairs(int n, int k) {
        memory = new int[n+1][k+1];
        for(int[] mem : memory)
            Arrays.fill(mem, -1);

        return calculate(n, k);
    }

    public int calculate(int n, int k){
        if(n<=0 || k < 0 || k > sum[n-1])
            return 0;
        if(k==0 || k == sum[n-1])
            return 1;
        if(memory[n][k] != -1)
            return memory[n][k];

        int result = 0;

        for(int i=0; i<= Math.min(n-1, k); i++){
            result = (result + calculate(n-1, k-i))%MOD;
        }
        memory[n][k] = result;
        return result;
    }
}
