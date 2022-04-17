package com.cyryl.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SecretPeopleTest {

    @Test
    public void exampleTest(){
        SecretPeople secretPeople = new SecretPeople();
        int[][] input = {{3,1,3},{1,2,2},{0,3,3}};
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        result.add(3);

        Assert.assertEquals(result, secretPeople.findAllPeople(4, input, 3));
    }

}