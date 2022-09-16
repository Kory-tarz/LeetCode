package com.cyryl.daily.august;

public class UTF8Validation {
    public boolean validUtf8(int[] data) {

        System.out.println(1<<7);
        System.out.println(1<<6);

        int curr = 0;
        while(curr < data.length){
            if((data[curr] & 1 << 7) == 0){
                continue;
            }
            int numberOfBytes = 0;
            int bit = 6;
            while(bit >= 4 && (((1 << bit) & data[curr]) != 0)){
                numberOfBytes++;
                bit--;
            }
            System.out.println("BYTES: " + numberOfBytes);
            if(numberOfBytes == 0 || bit < 4){
                System.out.println("invalid amount");
                return false;
            }
            for(int i=1; i<=numberOfBytes; i++){
                if(i + curr >= data.length){
                    System.out.println("length");
                    return false;
                }
                if(((data[i+curr] & (1 << 7)) == 0) || ((data[i+curr] & (1 << 6)) != 0)){
                        System.out.println("invalid start on: " + (i + curr));
                    return false;
                }
            }
            curr += numberOfBytes + 1;
        }
        return true;
    }
}
