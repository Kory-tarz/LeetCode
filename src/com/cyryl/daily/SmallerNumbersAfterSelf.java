package com.cyryl.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 */

public class SmallerNumbersAfterSelf {

    private class Node {
        int val;
        int smaller;
        int count;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.smaller = 0;
            this.count = 1;
        }

    }

    private class BST {

        Node root;

        public BST(int val) {
            root = new Node(val);
        }

        public int insert(int val) {
            return insert(root, val);
        }

        private int insert(Node node, int val) {
            if (val > node.val) {
                int sum = node.smaller + node.count;
                if (node.left == null) {
                    node.left = new Node(val);
                    return sum;
                } else {
                    return insert(node.left, val) + sum;
                }
            } else if (val < node.val) {
                node.smaller++;
                if (node.right == null) {
                    node.right = new Node(val);
                    return 0;
                } else {
                    return insert(node.right, val);
                }
            } else {
                return node.smaller;
            }
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        res[res.length-1] = 0;
        BST bst = new BST(nums[nums.length-1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = bst.insert(nums[i]);
        }
        return Arrays.stream(res).toList();
    }
}
