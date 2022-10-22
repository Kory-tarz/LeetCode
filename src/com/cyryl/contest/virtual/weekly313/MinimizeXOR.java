package com.cyryl.contest.virtual.weekly313;

public class MinimizeXOR {
    public int minimizeXor(int xorValue, int bitsValue) {
        int xorBits = calculateSetBits(xorValue);
        int bitsAvailable = calculateSetBits(bitsValue);
        int number = 0;
        int bitIdx = 0;
        while (bitsAvailable > 0){
            if ((xorValue & (1 << bitIdx)) != 0){ // bit is set in xor value
                if(bitsAvailable >= xorBits){
                    number = number | (1 << bitIdx);
                    bitsAvailable--;
                }
                xorBits--;
            } else { // bit is not set
                if(bitsAvailable > xorBits){
                    number = number | (1 << bitIdx);
                    bitsAvailable--;
                }
            }
            bitIdx++;
        }
        return number;
    }

    private int calculateSetBits(int x){
        int count = 0;
        while (x > 0){
            if((x & 1) != 0){
                count++;
            }
            x = x >> 1;
        }
        return count;
    }
}
