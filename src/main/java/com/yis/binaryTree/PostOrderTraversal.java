package com.yis.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *  后序遍历 ： 左 - 右 - 根
 */
public class PostOrderTraversal {

    /**
     *  递归方法
     */
    List<Integer> result = new ArrayList<>();
    public List<Integer> postOrderTraversal(TreeNode root) {
        if (null == root) {
            return result;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        result.add(root.val);
        return result;
    }

    /**
     *  迭代方法
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

}
