package com.yis.binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的序列化与反序列化
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 思路：
 *      序列化： 序列化成 String字符串
 *          1. 前序遍历添加node值，逗号隔开
 *          终止条件： 为null时，添加node
 *      反序列化： String 还原成 List<node>
 *          1. 将String转换为list
 *          2. 前序装载node， 先装val，递归装 left， right
 *          终止条件： list弹出值为none时，返回空
 * @author YeShuai
 * @date 2021/3/19
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new LinkedList<>();
        list = codeSerialize(root, list);
        return String.join(",",list);
    }

    public List<String> codeSerialize(TreeNode root, List<String> str) {
        if (root == null) {
            str.add("None");
        } else {
            str.add(String.valueOf(root.val));
            str = codeSerialize(root.left, str);
            str = codeSerialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> nodeList = new LinkedList<>(Arrays.asList(split));
        return codeDeserialize(nodeList);
    }

    public TreeNode codeDeserialize(List<String> nodeList) {
        if (nodeList.get(0).equals("None")) {
            nodeList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodeList.get(0)));
        nodeList.remove(0);
        root.left = codeDeserialize(nodeList);
        root.right = codeDeserialize(nodeList);
        return root;
    }

}
