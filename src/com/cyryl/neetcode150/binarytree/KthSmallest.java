package com.cyryl.neetcode150.binarytree;

import java.util.HashMap;
import java.util.Map;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Map<TreeNode, Integer> smallerCount = new HashMap<>();
        setUpCount(root, smallerCount);
        TreeNode curr = root;
        int target = k - 1;
        while (target > 0 && curr != null){
            int smallerThanCurr = smallerCount.get(curr);
            if(target > smallerThanCurr){
                target -= (smallerThanCurr + 1);
                curr = curr.right;
            } else if (target < smallerThanCurr) {
                curr = curr.left;
            } else {
                return curr.val;
            }
        }
        return -1;
    }

    public int setUpCount(TreeNode node, Map<TreeNode, Integer> smallerCount) {
        if(node == null){
            return 0;
        }
        int smallerThanMe = setUpCount(node.left, smallerCount);
        int biggerThanMe = setUpCount(node.right, smallerCount);
        smallerCount.put(node, smallerThanMe);
        return 1 + smallerThanMe + biggerThanMe;
    }
}
