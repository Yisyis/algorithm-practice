package com.yis.linkedList;

/**
 * 环形链表
 * 龟兔赛跑
 * 设置慢指针 和 快指针，快指针以2步的速度前进，慢指针以1步的速度前进，当快指针重新遇到慢指针，则为闭环
 *
 * @author YeShuai
 * @date 2021/3/22
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode slowPoint = head;
        ListNode fastPoint = head.next;
        while (slowPoint != fastPoint) {
            if (fastPoint == null || fastPoint.next == null) {
                return false;
            }
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
        }
        return true;
    }

}
