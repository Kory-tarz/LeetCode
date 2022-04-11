package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Sum3Test {

    @Test
    public void simpleTest(){
        int[] input = {-1,0,1,2,-1,-4};
        int[] input2 = {1,2,-2,-1};
        int[] input3 = {0,0,0};
        int[][] output = {{-1,-1,2}, {-1, 0, 1}};
        for(List<Integer> elemt : Sum3.threeSum(input)){
            for(int n : elemt)
                System.out.println(n +" ");
            System.out.println();
        }
    }
}