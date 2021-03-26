package com.yis.linkedList;

/**
 * 扁平化多级双向链表
 * 应用场景： git 分支的简化版本
 * @author YeShuai
 * @date 2021/3/26
 */
public class Flatten {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node preUdoHead = new Node(0, null, head, null);
        flattenDFS(preUdoHead, head);
        preUdoHead.next.prev = null;
        return preUdoHead.next;
    }

    // 1,2,3,4,5
    //     6,7,8
    //         9
    // 翻转看成二叉树的前序遍历
    public Node flattenDFS(Node pre, Node curr) {
        // 把curr看成child，没有child，返回pre(一级节点)
        if (curr == null) {
            return pre;
        }
        // 父节点 连接 left
        curr.prev = pre;
        pre.next = curr;

        Node tempNext = curr.next;

        // left 左节点递归  进二级节点
        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;
        // right 右节点递归
        return flattenDFS(tail, tempNext);

    }

}
