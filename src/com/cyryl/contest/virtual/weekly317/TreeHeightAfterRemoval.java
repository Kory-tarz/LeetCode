package com.cyryl.contest.virtual.weekly317;

import com.cyryl.structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TreeHeightAfterRemoval {
    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<TreeNode, Integer> heights = new HashMap<>();
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        setHeights(heights, nodeMap, root, 0);
        Map<TreeNode, Integer> afterRemove = new HashMap<>();
        setRemovals(heights, afterRemove, root, 0, 0);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = afterRemove.get(nodeMap.get(queries[i]));
        }
        return result;
    }

    private void setRemovals(Map<TreeNode, Integer> heights, Map<TreeNode, Integer> afterRemove, TreeNode node, int other, int depth) {
        if(node == null){
            return;
        }
        afterRemove.put(node, other);
        int otherLeft = Math.max(other, heights.getOrDefault(node.right, depth));
        int otherRight = Math.max(other, heights.getOrDefault(node.left, depth));
        setRemovals(heights, afterRemove, node.left, otherLeft, depth + 1);
        setRemovals(heights, afterRemove, node.right, otherRight, depth + 1);
    }


    private void setHeights(Map<TreeNode, Integer> heights, Map<Integer, TreeNode> nodeMap, TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        nodeMap.put(node.val, node);
        setHeights(heights, nodeMap, node.right, depth + 1);
        setHeights(heights, nodeMap, node.left, depth + 1);
        heights.put(node, Math.max(heights.getOrDefault(node.right, depth), heights.getOrDefault(node.left, depth)));
    }
}
