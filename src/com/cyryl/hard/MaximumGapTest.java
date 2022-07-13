package com.cyryl.hard;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaximumGapTest {

    MaximumGap maximumGap = new MaximumGap();

    @Test
    void exampleTesT(){
        int[] nums = {3,6,9, 1};
        assertEquals(3, maximumGap.maximumGap(nums));
    }
}