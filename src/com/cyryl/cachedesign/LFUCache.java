package com.cyryl.cachedesign;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private CacheNode head;
    private final Map<Integer, CacheNode> nodeMap = new HashMap<>();
    final int capacity;

    LFUCache(int capacity) {
        this.capacity = capacity;
    }

    int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        CacheNode node = nodeMap.get(key);
        node.useCount++;
        adjustLFULRUOrder(node);
        return node.value;
    }

    void put(int key, int value) {
        CacheNode node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.value = value;
            node.useCount++;
        } else {
            if (nodeMap.size() == capacity) {
                removeLeastFrequentlyUsedNode();
            }
            node = addNewNode(key, value);
        }
        adjustLFULRUOrder(node);
    }

    private void adjustLFULRUOrder(CacheNode node) {
        int count = 0;
        while (node.next != null && node.next.useCount <= node.useCount) {
            CacheNode nextNode = node.next;
            CacheNode prevNode = node.prev;
            if (head == node) {
                head = nextNode;
            } else {
                prevNode.next = nextNode;
            }
            nextNode.prev = prevNode;
            node.next = nextNode.next;
            if (node.next != null) {
                node.next.prev = node;
            }
            node.prev = nextNode;
            nextNode.next = node;
            count++;
        }
    }

    private CacheNode addNewNode(int key, int value) {
        CacheNode node = new CacheNode(key, value);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        nodeMap.put(key, node);
        return node;
    }

    private void removeLeastFrequentlyUsedNode() {
        CacheNode nodeToRemove = head;
        head = nodeToRemove.next;
        if (head != null) {
            head.prev = null;
        }
        nodeMap.remove(nodeToRemove.key);
    }

    private class CacheNode {
        int useCount = 1;
        int value;
        final int key;
        CacheNode prev, next;

        CacheNode(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }
}
