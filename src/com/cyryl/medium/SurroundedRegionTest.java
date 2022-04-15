package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SurroundedRegionTest {

    SurroundedRegion surroundedRegion = new SurroundedRegion();
    
    @Test
    public void exampleTest(){
        char[][] input = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] output = {{'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'},{'X','O','X','X'}};

        surroundedRegion.solve(input);

        Assert.assertArrayEquals(output, input);
    }

    @Test
    public void exampleTest2(){
        char[][] input = {{'X'}};
        char[][] output = {{'X'}};

        surroundedRegion.solve(input);

        Assert.assertArrayEquals(output, input);
    }

    @Test
    public void twoField(){
        char[][] input = {{'X','O'},{'O','X'}};
        char[][] output = {{'X','O'},{'O','X'}};

        surroundedRegion.solve(input);

        Assert.assertArrayEquals(output, input);
    }

    @Test
    public void xoXO(){
        char[][] input = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        char[][] output = {{'X','O','X','O','X','O'},{'O','X','X','X','X','X'},{'X','X','X','X','X','O'},{'O','X','O','X','O','X'}};

        surroundedRegion.solve(input);

        Assert.assertArrayEquals(output, input);
    }
}