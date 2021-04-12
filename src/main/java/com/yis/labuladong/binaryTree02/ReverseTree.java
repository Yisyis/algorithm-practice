package com.yis.labuladong.binaryTree02;


import java.util.*;

/**
 * 二叉树
 * 递归思想练习：
 * 1. 先搞清楚当前 root 节点该做什么；
 * 2. 然后根据函数定义递归调用子节点，递归调用会让孩子节点做相同的事情；
 * 3. 绝不要跳入递归的细节。
 *
 * @author YeShuai
 * @date 2021/4/7
 */
public class ReverseTree {

    /**
     * 1. 统计二叉树节点个数
     * 后序
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 1.1.优化版
     * 时间复杂度 O(logN) ~ O(logN*logN)
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {
        TreeNode l = root, r = root;
        // 记录左、右子树的高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // 如果左右子树的高度相同，则是一棵满二叉树
        if (hl == hr) {
            return (int)Math.pow(2, hl) - 1; // 可改位运算 1<<hl - 1
        }
        // 如果左右高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }

    /**
     * 2. 反转二叉树
     * 前序，后序
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    /**
     * 3. 填充每个节点的下一个右侧节点指针
     * 前序
     * 当一级无法实现时，想着二级去实现逻辑
     *
     * @param root
     * @return
     */
    public TreeNode connectTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root.left, root.right);
        return root;
    }

    public void helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;

        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }

    /**
     * 4. 二叉树展开为链表
     * 后续、 中序也可，在right赋值前
     * 将左链表 接到 右链表的后面
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        // 后序
        // 1. 左右子树当前被拉成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2. 将左子树 作为 右子树
        root.left = null;
        root.right = left;

        // 3. 将右子树接到当前右子树末梢
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    /**
     * 5. 最大二叉树
     * 前序
     * 1. 遍历当前数组，取最大值作为当前节点的值
     * 2. 取最大值索引 作为分割数组的范围
     * 3. 递归左右数组 分别作为 左右子节点
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return constructTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // 找到最大值和其索引位置
        int index = start;
        int maxValue = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);

        root.left = constructTree(nums, start, index - 1);
        root.right = constructTree(nums, index + 1, end);
        return root;
    }

    /**
     * 6. 从前序与中序遍历序列构造二叉树
     * 前序
     * 1. 前序数组： 首个数是根，中间一批是左边节点, 最后一批是右侧节点
     * 2. 中序数组： 根数的左右分别是树的左右边节点
     * 3. 分别递归左右子节点
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // 前序框架
        // 1. 前序， 首个数是根  中序，根的左右分别是树的左右节点
        // 2. 分别递归左右子节点
        if (inStart > inEnd) {
            return null;
        }
        int index = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(preorder[preStart]);

        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

    /**
     * 7. 从后序与中序遍历序列构造二叉树
     * 前序
     * 1. 前序数组： 最后一个数是根，中间一批是右边节点, 最后一批是左侧节点
     * 2. 中序数组： 根数的左右分别是树的左右边节点
     * 3. 分别递归左右子节点
     *
     * @param postorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree1(int[] postorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        return build1(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build1(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootValue = postorder[postEnd];
        int index = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                index = i;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootValue);
        root.left = build1(postorder, postStart, postStart + leftSize - 1, inorder, inStart, index - 1);
        root.right = build1(postorder, postStart + leftSize, postEnd - 1, inorder, index + 1, inEnd);
        return root;
    }

    /**
     * 8.寻找重复子树
     * 后序
     * 1. 序列化当前二叉树（可以后、前、中序）
     * 2. 借助一个list存储结果，一个hashmap存储二叉树序列串
     * 3. 当hashmap中存在，list加入
     * 4. list作为结果返回
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return null;
        }
        findSubtrees(root);
        return res;
    }

    LinkedList<TreeNode> res = new LinkedList<>();
    Map<String, Integer> nodeMap = new HashMap<>();
    public String findSubtrees(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = findSubtrees(root.left);
        String right = findSubtrees(root.right);

        String node = left + "," + right + "," + root.val;

        int freq = nodeMap.getOrDefault(node, 0);
        if (freq == 1) {
            res.add(root);
        }
        nodeMap.put(node, freq + 1);
        return node;
    }


}
