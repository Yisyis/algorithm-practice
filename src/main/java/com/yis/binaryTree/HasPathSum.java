package com.yis.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 路径总和
 * @author YeShuai
 * @date 2021/3/16
 */
public class HasPathSum {

    /**
     *  递归
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * BFS
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        queueNode.offer(root);
        queueVal.offer(root.val);
        while (!queueNode.isEmpty()) {
            TreeNode poll = queueNode.poll();
            Integer sum = queueVal.poll();
            if (poll.left == null && poll.right == null) {
                if (sum == targetSum) {
                    return true;
                }
                continue;
            }
            if (poll.left != null) {
                queueNode.offer(poll.left);
                queueVal.offer(poll.left.val + sum);
            }
            if (poll.right != null) {
                queueNode.offer(poll.right);
                queueVal.offer(poll.right.val + sum);
            }
        }
        return false;
    }
}
