package com.cyryl.medium;

import java.util.Arrays;

public class MatchSticks {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        int sum = 0;
        for(int matchstick : matchsticks)
            sum += matchstick;

        if(sum % 4 != 0)
            return false;

        int subsetSum = sum/4;
        int currSum;

        int[] memo = new int[1 << n];
        Arrays.fill(memo, -1);
        memo[0] = 0;

        for(int i=0; i < (1 << n); i++){

            if(memo[i] == -1)
                continue;
            for(int j=0; j<n; j++){
                if((i & (1 << j)) == 0){ // jth element is not in subset
                    currSum = memo[i] + matchsticks[j];
                    if(currSum < subsetSum)
                        memo[i | (1 << j)] = memo[i] + matchsticks[j];
                    else if(currSum == subsetSum)
                        memo[i | (1 << j)] = 0;
                }
            }
        }

        System.out.println(memo[(1<<n) - 1]);

        return memo[(1<<n) - 1] == 0;
    }

}
