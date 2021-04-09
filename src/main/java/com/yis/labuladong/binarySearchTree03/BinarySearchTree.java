package com.yis.labuladong.binarySearchTree03;

/**
 * 二叉搜索树 BST
 *
 * @author YeShuai
 * @date 2021/4/9
 */
public class BinarySearchTree {

    /**
     * 二叉搜索树中第K小的元素
     * 思路：
     * 1.左小右大
     * 2.中序遍历的倒序
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        minTraverse(root, k);
        return res;
    }

    int res = 0;
    int rank = 0;

    public void minTraverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        minTraverse(root.left, k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        minTraverse(root.right, k);
    }

    /**
     * 538.1038. 把二叉搜索树转换为累加树
     * 思路：
     * 1.前序遍历框架的后续遍历；
     * 2.从最后一个元素开始累加，赋值给当前元素的val
     *
     * @param root
     * @return
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    /**
     * 98.验证二叉搜索树
     * 思路： 根据BST左小右大特性
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, Long min ,Long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, Long.valueOf(root.val)) && isValidBST(root.right, Long.valueOf(root.val), max);
    }

}
