package com.cyryl.contest.virtual.weekly320;

import com.cyryl.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ClosestNodesQueriesBST {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        for (Integer query : queries) {
            List<Integer> queryResult = new ArrayList<>();
            queryResult.add(findSmaller(root, -1, query));
            queryResult.add(findBigger(root, Integer.MAX_VALUE, query));
            result.add(queryResult);
        }
        return result;
    }


    private int findSmaller(TreeNode node, int min, int val) {
        if (node == null) {
            return min;
        }
        if (node.val == val) {
            return val;
        }
        if (node.val > val) {
            return findSmaller(node.left, min, val);
        } else { // node.val < val
            return findSmaller(node.right, Math.max(node.val, min), val);
        }
    }

    private int findBigger(TreeNode node, int max, int val) {
        if (node == null) {
            return max == Integer.MAX_VALUE ? -1 : max;
        }
        if (node.val == val) {
            return val;
        }
        if(node.val > val){
            return findBigger(node.left, Math.min(max, node.val), val);
        } else { // node.val < val
            return findBigger(node.right, max, val);
        }
    }
}
