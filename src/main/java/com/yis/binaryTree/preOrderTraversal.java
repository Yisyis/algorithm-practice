package com.yis.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历
 */
public class preOrderTraversal {

    /**
     *  迭代方法
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()) {
            while(root!=null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return list;
    }

    /**
     *  递归方法
     */
    List<Integer> list = new ArrayList<>();
    public List<Integer> preOrderTraversal2(TreeNode root) {
        if (null == root) {
            return list;
        }
        list.add(root.val);
        preOrderTraversal2(root.left);
        preOrderTraversal2(root.right);
        return list;
    }

}
