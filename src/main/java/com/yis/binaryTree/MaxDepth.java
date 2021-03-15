package com.yis.binaryTree;

public class MaxDepth {

    /**
     * 自底向上
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left)+1, maxDepth1(root.right)+1);
    }

    // [3,9,20,null,null,15,7]
    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(20, treeNode3,treeNode4);
        TreeNode treeNode = new TreeNode(3, treeNode1, treeNode2);
        maxDepth.maxDepth1(treeNode);
    }
}
