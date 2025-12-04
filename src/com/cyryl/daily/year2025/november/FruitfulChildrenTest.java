package com.cyryl.daily.year2025.november;

import org.junit.Test;

public class FruitfulChildrenTest {
    @Test
    public void test1() {
        int[][] input = new int[][]{{16,3,11,14,14},{3,0,10,13,14},{7,18,8,7,18},{7,8,5,7,5},{0,14,8,1,0}};
        new FruitfulChildren().maxCollectedFruits(input);
    }

    @Test
    public void test2() {
        int[][] input = new int[][]{{1,2,3,4},{5,6,8,7},{9,10,11,12},{13,14,15,16}};
        new FruitfulChildren().maxCollectedFruits(input);
    }
}
