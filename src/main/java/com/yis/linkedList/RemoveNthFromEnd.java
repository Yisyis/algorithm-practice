package com.yis.linkedList;

/**
 * 删除链表的倒数第N个节点
 * <p>
 * 解法： 找到倒数第 n 个节点
 * 使用两个指针 first 和 second 同时对链表进行遍历， first比second的先走n个节点
 * 当 first 遍历到链表的末尾时，second 就恰好处于倒数第 n 个节点。
 * 边界条件：
 * remove 第 n 个节点，则在为n-1节点时，second.next = second.next.next;
 * first从 head出发
 * second从 head的前一个出发
 *
 * @author YeShuai
 * @date 2021/3/23
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
