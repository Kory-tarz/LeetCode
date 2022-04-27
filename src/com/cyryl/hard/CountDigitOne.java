package com.cyryl.hard;

import java.util.HashMap;
import java.util.Map;

public class CountDigitOne {
    Map<Integer, Integer> memory = new HashMap<>();

    public int countDigitOne(int n) {
        if (n<10) return n == 0 ? 0 : 1;

        for(long i=10; ; i*=10){
            calculate((int)(n % i), i);
            if(memory.containsKey(n))
                break;
        }

        return memory.get(n);
    }

    private int calculate(int n, long numLen){

        if(memory.containsKey(n)) {
            return memory.get(n);
        }

        if(numLen == 10)
            return n > 0 ? 1: 0;

        if(n < numLen/10)
            return n == 0 ? 0 : 1;

        int thisNum = n;
        int thisLen = (int)(numLen/10);
        int firstNum = n/thisLen;
        int result = 0;

        if(firstNum == 1)
            result += thisNum % thisLen + 1;
        else
            result += thisLen;

        result += firstNum * calculate(thisLen-1, thisLen) + calculate(thisNum % thisLen, thisLen);

        memory.put(n, result);
        return result;
    }
}
