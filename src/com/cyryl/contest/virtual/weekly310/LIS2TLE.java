package com.cyryl.contest.virtual.weekly310;

import java.util.*;

public class LIS2TLE {
    public int lengthOfLIS(int[] nums, int k) {
        Set<Sequence> sequences = new HashSet<>();
        for (int num : nums) {
            Set<Sequence> newSequences = new HashSet<>();
            boolean found = false;
            for (Sequence sequence : sequences) {
                if (sequence.max + 1 == num) {
                    newSequences.add(new Sequence(sequence.max + 1, sequence.count + 1));
                    found = true;
                    continue;
                } else if (num > sequence.max + 1 && num - sequence.max <= k) {
                    newSequences.add(new Sequence(num, sequence.count + 1));
                    found = true;
                }
                newSequences.add(sequence);
            }
            sequences = newSequences;
            if (!found) {
                sequences.add(new Sequence(num, 1));
            }
        }
        int max = 0;
        for (Sequence sequence : sequences) {
            max = Math.max(max, sequence.count);
        }
        return max;
    }

    private class Sequence {
        int max;
        int count;

        public Sequence(int max, int count) {
            this.max = max;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Sequence sequence = (Sequence) o;
            return max == sequence.max && count == sequence.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(max, count);
        }
    }
}
