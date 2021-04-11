package com.yis.labuladong.binaryTree02;

import com.sun.tools.javac.util.StringUtils;

import java.time.temporal.Temporal;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 297 二叉树的序列化和反序列化
 * 1. 前序框架
 * 2. 后序框架
 * 3. 迭代，层序遍历框架
 *
 * @Author yeshuai
 * @Date 2021/4/11
 */
public class SerializeTree {

    String SEP = ",";
    String NULL = "#";

    /**
     * 1. 前序遍历 序列化
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeTree(root, sb);
        return sb.toString();
    }

    public void serializeTree(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        /****** 前序遍历位置 ******/
        sb.append(root.val).append(SEP);
        serializeTree(root.left, sb);
        serializeTree(root.right, sb);
    }

    /**
     * 1. 前序遍历 反序列化
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        // 将字符串转化成列表
        String[] nodes = data.split(SEP);
        LinkedList<String> nodeList = new LinkedList();
        for (String node : nodes) {
            nodeList.add(node);
        }
        TreeNode root = new TreeNode();
        root = deserializeTree(nodeList);
        return root;
    }

    public TreeNode deserializeTree(LinkedList<String> nodeList) {
        if (nodeList.isEmpty()) {
            return null;
        }
        /****** 前序遍历位置 ******/
        // 列表最左侧就是根节点
        String nodeVal = nodeList.removeFirst();
        if (nodeVal.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodeVal));
        root.left = deserializeTree(nodeList);
        root.right = deserializeTree(nodeList);
        return root;
    }

    /**
     * 2. 后序遍历 序列化
     *
     * @param root
     * @return
     */
    public String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeTree1(root, sb);
        return sb.toString();
    }

    public void serializeTree1(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        serializeTree1(root.left, sb);
        serializeTree1(root.right, sb);
        /****** 后序遍历位置 ******/
        sb.append(root.val).append(SEP);
    }

    /**
     * 2. 后序遍历 反序列化
     *
     * @param data
     * @return
     */
    /* 主函数，将字符串反序列化为二叉树结构 */
    public TreeNode deserialize1(String data) {
        String[] split = data.split(SEP);
        LinkedList<String> list = new LinkedList<>();
        for (String nodeVal : split) {
            list.add(nodeVal);
        }
        TreeNode root = deserialize1Tree(list);
        return root;
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    public TreeNode deserialize1Tree(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        // 从后往前取出元素
        String last = list.removeLast();
        if (last.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(last));
        // 限构造右子树，后构造左子树
        root.right = deserialize1Tree(list);
        root.left = deserialize1Tree(list);
        return root;
    }

    /**
     * 3. 层序遍历 序列化
     *
     * @param root
     * @return
     */
    /** 将二叉树序列化为字符串 **/
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        // 初始化队列，将 root 加入队列
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            /** 层级遍历代码位置 **/
            if (poll == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(root.val).append(SEP);
            /*****************/
            queue.offer(poll.left);
            queue.offer(poll.right);
        }
        return sb.toString();
    }

    /**
     * 3. 层序遍历 反序列化
     *
     * @param data
     * @return
     */
    /** 将字符串反序列化为二叉树结构 **/
    public TreeNode deserialize2(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(SEP);
        // 第一个元素就是 root 的值
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        // 队列 q 记录父节点，将 root 加入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < nodes.length; ) {
            // 队列中存的都是父节点
            TreeNode poll = queue.poll();
            // 父节点对应的左侧子节点的值
            String left = nodes[i++];
            if (left.equals(NULL)) {
                poll.left = null;
            } else {
                poll.left = new TreeNode(Integer.parseInt(left));
                queue.offer(poll.left);
            }
            // 父节点对应的右侧子节点的值
            String right = nodes[i++];
            if (right.equals(NULL)) {
                poll.right = null;
            } else {
                poll.right = new TreeNode(Integer.parseInt(right));
                queue.offer(poll.right);
            }

        }
        return root;

    }
}
