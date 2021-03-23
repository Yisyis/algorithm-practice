package com.yis.linkedList;

/**
 * 链表节点
 *
 * @author YeShuai
 * @date 2021/3/22
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
