package com.yis.linkedList;

/**
 * 两数相加
 *
 * @author YeShuai
 * @date 2021/3/25
 */
public class AddTwoNumbers {

    /**
     * 模拟法
     * 1. 同步+1，相加两个节点值
     * 2. 两个个位数相加，不会超过20，故而进位最多+1 （添加个flag标识 是否进位）
     * 3. 当短链表为空时，需要判断短链表的指针不再取值
     * 4. 判断最后一位是否有进位，是，结果链表在加个1
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode(0);
        ListNode pre = sumList;
        ListNode node1 = l1;
        ListNode node2 = l2;
        boolean carryBit = false;
        while (node1 != null || node2 != null) {
            int val1 = node1 == null ? 0 : node1.val;
            int val2 = node2 == null ? 0 : node2.val;
            int sum;
            int unitsDigit;
            if (carryBit) {
                sum = val1 + val2 + 1;
            } else {
                sum = val1 + val2;
            }
            if (sum >= 10) {
                unitsDigit = sum % 10;
                carryBit = true;
            } else {
                unitsDigit = sum;
                carryBit = false;
            }
            pre.next = new ListNode(unitsDigit);
            pre = pre.next;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        if (carryBit) {
            pre.next = new ListNode(1);
        }
        return sumList.next;
    }

    /**
     * 官方 模拟法
     * 优点：
     * 减少代码和遍历
     * 结果链表，定义开头和结尾，开头用于返回，结尾用来添加后进节点
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

}
