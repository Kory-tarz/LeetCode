package com.cyryl.daily.august;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaxSumOfRectangleTest {

    @Test
    public void example() {
        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        MaxSumOfRectangle maxSumOfRectangle = new MaxSumOfRectangle();
        int k = 2;
        int result = maxSumOfRectangle.maxSumSubmatrix(matrix, k);
        assertEquals(result, 2);
    }
}