package com.yis.linkedList;

/**
 * 链表节点
 * 单链表 + 双向链表
 *
 * @author YeShuai
 * @date 2021/3/22
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
        prev = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
