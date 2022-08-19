package com.cyryl.neetcode150.linkedlist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 */

class LRUCache {

    private final int capacity;
    private Map<Integer, Integer> keyValueMap;
    private Map<Integer, Node> keyNodeMap;
    private Node head;
    private Node tail;
    private int size;


    private class Node {
        Node prev;
        Node next;
        int key;

        public Node(int key) {
            this.key = key;
        }
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        if(node == tail){
            tail = prev;
        }
        Node next = node.next;
        if (prev != null) {
            prev.next = next;
            next.prev = prev;
        } else {
            if (next != null) {
                next.prev = null;
            }
            head = next;
        }
    }

    private void addNode(Node node) {
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        node.next = null;
        tail = node;
    }

    private int removeFirstNode() {
        Node node = head.next;
        int removedKey = head.key;
        if (node != null) {
            node.prev = null;
        } else {
            tail = null;
        }
        head = node;
        return removedKey;
    }

    private void removeLeastRecentKey(){
        System.out.println("Before: " + head.key);
        int key = removeFirstNode();
        System.out.println("After: " + head.key);
        keyValueMap.remove(key);
        keyNodeMap.remove(key);
        size--;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyValueMap = new HashMap<>();
        keyNodeMap = new HashMap<>();
        size = 0;
    }

    public int get(int key) {
        if(!keyValueMap.containsKey(key)){
            return -1;
        }
        Node node = keyNodeMap.get(key);
        removeNode(node);

        Node newNode = new Node(key);
        keyNodeMap.put(key, newNode);
        addNode(newNode);
        return keyValueMap.get(key);
    }

    public void printList(){
        Node node = head;
        while (node != null){
            System.out.printf(node.key + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void put(int key, int value) {
        System.out.println("PUT: " + key + " " + value + " size: " + size);
        if(keyValueMap.containsKey(key)){
            Node node = keyNodeMap.get(key);
            keyNodeMap.remove(key);
            removeNode(node);
        } else {
            if(size == capacity){
                removeLeastRecentKey();
            } else {
                size++;
            }
        }
        Node newNode = new Node(key);
        addNode(newNode);
        keyValueMap.put(key, value);
        keyNodeMap.put(key, newNode);
        printList();
    }
}
