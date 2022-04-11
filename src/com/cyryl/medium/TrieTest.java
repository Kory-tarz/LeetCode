package com.cyryl.medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    Trie trie = new Trie();

    @Test
    public void insertTest() {
        trie.insert("hamburger");
        trie.insert("hamuwa");
    }

    @Test
    public void searchTest() {
        trie.insert("hamburger");
        trie.insert("hamuwa");
        Assert.assertTrue(trie.search("hamuwa"));
        Assert.assertFalse(trie.search("ham"));
        Assert.assertTrue(trie.search("hamburger"));
    }

    @Test
    public void startsWithTest() {
        trie.insert("hamburger");
        trie.insert("hamuwa");
        Assert.assertTrue(trie.startsWith("ham"));
        Assert.assertTrue(trie.startsWith("ha"));
        Assert.assertTrue(trie.startsWith("h"));
    }
}