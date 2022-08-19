package com.cyryl.neetcode150.binarytree;

public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    public int countGoodNodes(TreeNode node, int pathMax){
        if(node == null){
            return 0;
        }
        int goodCount = 0;
        if(node.val >= pathMax){
            goodCount++;
            pathMax = node.val;
        }
        goodCount += countGoodNodes(node.left, pathMax);
        goodCount += countGoodNodes(node.right, pathMax);
        return goodCount;
    }
}
