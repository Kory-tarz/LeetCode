package com.cyryl.contest.virtual.weekly317;

public class BeautifulInteger {
    public long makeIntegerBeautiful(long n, int target) {
        long result = 0;
        long pos = 1;
        long currNum = n;
        while (!isBeautiful(currNum, target)){
            long lastDigit = (int) currNum % 10;
            System.out.println("Digit: " + lastDigit + " num: " + currNum);
            if(lastDigit != 0) {
                result += (10 - lastDigit) * pos;
                currNum = (currNum / 10) + 1;
            } else {
                currNum = currNum / 10;
            }
            System.out.println("Result: " + result);

            pos = pos * 10;
        }
        return result;
    }

    public boolean isBeautiful(long num, int target) {
        long sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum <= target;
    }
}
