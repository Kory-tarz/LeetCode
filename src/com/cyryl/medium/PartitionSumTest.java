package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionSumTest {

    @Test
    public void example(){
        PartitionSum partitionSum = new PartitionSum();

        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;

        Assert.assertTrue(partitionSum.canPartitionKSubsets(nums, k));
    }



    @Test
    public void example2(){
        PartitionSum partitionSum = new PartitionSum();

        int[] nums = {4,5,9,3,10,2,10,7,10,8,5,9,4,6,4,9};
        int k = 5;

        Assert.assertTrue(partitionSum.canPartitionKSubsets(nums, k));
    }

}