package com.cyryl.neetcode150.dynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/burst-balloons/
 */

// TLE obviously
public class BursBalloons {
    public int maxCoins(int[] nums) {
        Map<Set<Integer>, Integer> memo = new HashMap<>();
        return helper(memo, new HashSet<>(), new Linked(nums));
    }

    public int helper(Map<Set<Integer>, Integer> memo, Set<Integer> popped, Linked elements){
        if(elements.isEmpty()){
            return 0;
        }
        if(memo.containsKey(popped)){
            return memo.get(popped);
        }
        Linked.Node curr = elements.head.next;
        int max = 0;
        while (curr != elements.tail){
            Linked.Node next = curr.next;
            int currVal = elements.poppedVal(curr);
            elements.remove(curr);
            popped.add(curr.idx);
            max = Math.max(currVal + helper(memo, popped, elements), max);
            popped.remove(curr.idx);
            elements.insertBefore(next, curr);
            curr = next;
        }
        memo.put(new HashSet<>(popped), max);
        return max;
    }

    private class Linked{

        Node head;
        Node tail;

        public Linked(int[] arr){
            head = new Node(-1, 1);
            tail = new Node(-1, 1);
            head.next = tail;
            tail.prev = head;
            for (int i = 0; i < arr.length; i++) {
                insertBefore(tail, new Node(i, arr[i]));
            }
        }

        public int poppedVal(Node node){
            return node.prev.val * node.val * node.next.val;
        }

        public void insertBefore(Node node, Node nodeToInsert){
            Node tmp = node.prev;
            node.prev = nodeToInsert;
            nodeToInsert.next = node;
            tmp.next = nodeToInsert;
            nodeToInsert.prev = tmp;
        }

        public boolean isEmpty(){
            return head.next == tail;
        }

        public void remove(Node node){
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }


        private class Node{
            int idx;
            int val;
            Node next;
            Node prev;

            public Node(int idx, int val) {
                this.idx = idx;
                this.val = val;
            }
        }
    }
}
