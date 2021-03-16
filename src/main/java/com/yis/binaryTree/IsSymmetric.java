package com.yis.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 * @author YeShuai
 * @date 2021/3/16
 */
public class IsSymmetric {

    /**
     *  递归
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isMirror(root.left, root.right);
    }


    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    /**
     *  迭代
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isMirror1(root.left, root.right);
    }

    public boolean isMirror1(TreeNode left, TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()) {
            left = queue.poll();
            right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if ((left == null || right == null) || (left.val != right.val)) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }








    // [1,2,2,3,4,4,3]
    public static void main(String[] args) {
        IsSymmetric symmetric = new IsSymmetric();
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(15);
        TreeNode treeNode1 = new TreeNode(20, treeNode5,treeNode6);
        TreeNode treeNode2 = new TreeNode(20, treeNode3,treeNode4);
        TreeNode treeNode = new TreeNode(1, treeNode1, treeNode2);
        boolean b = symmetric.isSymmetric(treeNode);
        System.out.println(b);
    }
}
