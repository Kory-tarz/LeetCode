package com.cyryl.neetcode150.binarytree;

public class SubtreeOfAnother {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(root.val == subRoot.val){
            if(isTheSameStructure(root, subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isTheSameStructure(TreeNode node, TreeNode pattern){
        if(pattern == null && node == null){
            return true;
        }
        if(pattern == null || node == null || pattern.val != node.val){
            return false;
        }
        return isTheSameStructure(node.left, pattern.left) && isTheSameStructure(node.right, pattern.right);
    }


}
