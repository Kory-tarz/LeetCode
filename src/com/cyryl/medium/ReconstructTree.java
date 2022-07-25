package com.cyryl.medium;

/**
 * much better solution is to use hash map to for inorder pass array Map value->index
 */

public class ReconstructTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] pre = {5,4,1,3,2};
        int[] in = {1,2,3,4,5};

        buildTree(pre, in);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        boolean[] preVis = new boolean[preorder.length];
        boolean[] inVis = new boolean[inorder.length];

        int inIndex = 0;
        int preIndex = 0;
        while (inorder[inIndex] != preorder[preIndex]) {
            inIndex++;
        }
        return build(preorder, inorder, preIndex, inIndex, preVis, inVis);
    }

    private static TreeNode buildLeft(int[] pre, int[] in, int preIndex, int inIndex, boolean[] preVis, boolean[] inVis) {
        if (inIndex < 0 || inVis[inIndex] || preIndex >= pre.length) {
            return null;
        }
        while (pre[preIndex] != in[inIndex]) {
            inIndex--;
            if (inIndex < 0 || inVis[inIndex]) {
                return null;
            }
        }
        return build(pre, in, preIndex, inIndex, preVis, inVis);
    }

    private static TreeNode buildRight(int[] pre, int[] in, int preIndex, int inIndex, boolean[] preVis, boolean[] inVis) {
        if (preIndex >= pre.length || inIndex >= in.length || inVis[inIndex]) {
            return null;
        }
        while (in[inIndex] != pre[preIndex]) {
            inIndex++;
            if (inIndex >= in.length || inVis[inIndex]) {
                return null;
            }
        }
        return build(pre, in, preIndex, inIndex, preVis, inVis);
    }

    private static TreeNode build(int[] pre, int[] in, int preIndex, int inIndex, boolean[] preVis, boolean[] inVis){
        TreeNode node = new TreeNode(in[inIndex]);
        inVis[inIndex] = true;
        preVis[preIndex] = true;
        node.left = buildLeft(pre, in, preIndex + 1, inIndex - 1, preVis, inVis);
        while (preIndex < pre.length && preVis[preIndex]) {
            preIndex++;
        }
        node.right = buildRight(pre, in, preIndex, inIndex + 1, preVis, inVis);
        return node;
    }
}
