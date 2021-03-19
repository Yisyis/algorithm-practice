package com.yis.binaryTree;


/**
 * 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 解法：
 * 节点p和节点q只有两种关系:父子关系 兄弟关系
 * 父子关系:
 *       1.节点p是节点q的子孙节点,即节点p出现在节点q的左或右子树中;返回q即可;
 *       2.节点q是节点p的子孙节点,即节点q出现在节点p的左或右子树中;返回p即可;
 * 兄弟关系:
 *       节点p,q分别出现在某节点的左子树或右子树中;返回该节点即可;
 *
 *       终止条件：
 *          1. 发现目标节点，返回目标节点
 *          2. 没发现目标节点，继续递归子节点
 *              三种情形：
 *              2.1 左右子节点为null，表示该分支下没有目标节点，返回null
 *              2.2 左右子节点不为null， 表示目标节点在左右子树下面，返回父节点
 *              2.3 左右子节点有一个为null，返回不为null的节点
 * @author YeShuai
 * @date 2021/3/19
 */
public class CommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

}
