package com.cyryl.daily.year2025.october;

import java.util.Arrays;

public class FindValue {
    public int finalValueAfterOperations(String[] operations) {
        return Arrays.stream(operations)
                .mapToInt(op -> (op.startsWith("-") || op.endsWith("-")) ? -1 : 1)
                .sum();

    }
}
