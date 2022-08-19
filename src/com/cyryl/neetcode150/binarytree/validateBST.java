package com.cyryl.neetcode150.binarytree;

public class validateBST {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode node, long minVal, long maxVal) {
        if (node == null) {
            return true;
        }
        if (node.val <= minVal || node.val >= maxVal) {
            return false;
        }
        return isValid(node.left, minVal, node.val) && isValid(node.right, node.val, maxVal);
    }
}
