package com.yis.labuladong.binaryTree02;

/**
 * 236. 二叉树的最近公共祖先
 * @author YeShuai
 * @date 2021/4/12
 */
public class LowestCommonAncestor {

    /**
     * 遇到任何递归型的问题，无非就是灵魂三问： 「定义」「状态」「选择」，
     * 1、这个函数是干嘛的？
     * 2、这个函数参数中的变量是什么的是什么？
     * 3、得到函数的递归结果，你应该干什么
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件2：叶子节点为null
        if (root == null) {
            return null;
        }
        // 终止条件1：发现p q 返回该节点 （故此，没有该节点的分支，向上返回都是null）
        if (root == p || root == q) {
            return root;
        }

        // 1. 后序遍历框架，从下往上
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 情况1：p q 都在该root下
        if (left != null && right != null) {
            return root;
        }
        // 情况2：p q 都不在该root下
        if (left == null && right == null) {
            return null;
        }
        // 情况3：p q 只在root下的一边
        return left == null ? right : left;

    }
}
