package com.cyryl.hard;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainVirusTest {

    ContainVirus containVirus = new ContainVirus();

    @Test
    public void exampleTest(){
        int[][] board = {{0,1,0,0,0,0,0,1},{0,1,0,0,0,0,0,1},{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0}};

        Assert.assertEquals(10, containVirus.containVirus(board));
    }

    @Test
    public void example2Test(){
        int[][] board = {{1,1,1},{1,0,1},{1,1,1}};

        Assert.assertEquals(4, containVirus.containVirus(board));
    }

    @Test
    public void example3Test(){
        int[][] board = {{1,1,1,0,0,0,0,0,0},{1,0,1,0,1,1,1,1,1},{1,1,1,0,0,0,0,0,0}};

        Assert.assertEquals(13, containVirus.containVirus(board));
    }
    
    @Test
    public void failTest(){
        int[][] board = {{0,1,0,1,1,1,1,1,1,0},{0,0,0,1,0,0,0,0,0,0},{0,0,1,1,1,0,0,0,1,0},{0,0,0,1,1,0,0,1,1,0},{0,1,0,0,1,0,1,1,0,1},{0,0,0,1,0,1,0,1,1,1},{0,1,0,0,1,0,0,1,1,0},{0,1,0,1,0,0,0,1,1,0},{0,1,1,0,0,1,1,0,0,1},{1,0,1,1,0,1,0,1,0,1}};

        Assert.assertEquals(38, containVirus.containVirus(board));
    }
}