package com.yis.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  中序遍历
 */
public class inorderTraversal {

    /**
     * 迭代方法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            root = treeNode.right;
        }
        return list;
    }

    /**
     * 递归方法
     */
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal2(root.left);
        list.add(root.val);
        inorderTraversal2(root.right);
        return list;
    }
}
