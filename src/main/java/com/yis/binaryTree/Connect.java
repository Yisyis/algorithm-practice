package com.yis.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * 序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 *
 * @author YeShuai
 * @date 2021/3/18
 */
public class Connect {

    /**
     * 完美二叉树
     *     思路： 递归， 也可以采用层级遍历，参考下题
     *     由于是完美二叉树，每个非叶子节点的左右子节点都存在
     *     递归时，左右子节点的下一次递归组合会有3种(left.left, left.right)，(left.right, right.left)，(right.left, right.right)
     *     终止条件：左子节点不存在，或者 左右子节点以及关联过
     *
     * @param root
     * @return
     */
    public TreeNode connect(TreeNode root) {
        if (root != null) {
            helper(root.left, root.right);
        }
        return root;
    }

    public void helper(TreeNode left, TreeNode right) {
        if (left == null || left.next == right) {
            return;
        }
        left.next = right;
        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }

    /**
     * 非完美二叉树
     *      思路： 层级遍历
     *      设定一个next指针，在遍历每层节点时，修改next指针为前一个弹出值，指向当前弹出值
     * @param root
     * @return
     */
    public TreeNode connect1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode lastNode = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (null != poll.left) {
                    queue.offer(poll.left);
                }
                if (null != poll.right) {
                    queue.offer(poll.right);
                }
                if (i!=0) {
                    lastNode.next = poll;
                }
                lastNode = poll;
            }
        }
        return root;
    }
}
