package com.yis.special.linkedList;

/**
 * 移除链表元素
 * @author YeShuai
 * @date 2021/3/24
 */
public class RemoveElements {

    /**
     * 哨兵节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1, head);
        ListNode pre = newHead;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = pre.next;
            }
            head = head.next;
        }
        return newHead.next;
    }

}
