package com.yis.linkedList;


import com.yis.special.linkedList.ListNode;

/**
 * 旋转链表
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        tail.next = head;

        for (int i = 0; i < n - k % n; i++) {
            tail = tail.next;
        }
        ListNode res = tail.next;
        tail.next = null;
        return res;
    }

}
