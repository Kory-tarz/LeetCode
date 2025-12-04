package com.cyryl.daily.year2025.november;

import java.util.ArrayList;
import java.util.List;

public class DominantSubstring {
    public int numberOfSubstrings(String s) {
        int count = countNonZeroSubstrings(s);
        List<Integer> zeroIndices = new ArrayList<>();
        zeroIndices.add(-1);
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroIndices.add(i);
            }
        }
        zeroIndices.add(s.length());
        int maxZeroes = (int) Math.sqrt(s.length());
        for (int zeroCount = 1; zeroCount < maxZeroes; zeroCount++) {
            for (int idx = 1; idx + zeroCount < zeroIndices.size(); idx++) {
                int leftPos = zeroIndices.get(idx);
                int rightPos = zeroIndices.get(idx + zeroCount - 1);

                int currOnes = leftPos - rightPos + 1 - zeroCount;
                int requiredOnes = zeroCount * zeroCount - currOnes;

                int leftAvailable = leftPos + zeroIndices.get(idx - 1);
                int rightAvailable = rightPos + zeroIndices.get(idx + zeroCount);

                if (requiredOnes <= 0) {
                    count += leftAvailable * rightAvailable;
                    continue;
                }
                if (leftAvailable + rightAvailable - 2 < requiredOnes) {
                    continue;
                }

                if (leftAvailable >= requiredOnes) {
                    count += (leftAvailable - requiredOnes) * rightAvailable;
                }

                int maxLeft = Math.min(leftAvailable - 1, requiredOnes - 1);
                int firstLeft = Math.max(0, requiredOnes - rightAvailable + 1);

                if (firstLeft <= maxLeft) {
                    int t = maxLeft - firstLeft + 1;
                    int first = rightAvailable - leftAvailable;
                }

            }
        }
        return 0;
    }

    private int countNonZeroSubstrings(String s) {
        int count = 0;
        int ones = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                ones++;
            } else {
                count += (ones * (ones + 1)) / 2;
                ones = 0;
            }
        }
        count += (ones * (ones + 1)) / 2;
        return count;
    }
}
