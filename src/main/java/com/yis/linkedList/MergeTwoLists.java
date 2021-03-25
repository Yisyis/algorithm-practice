package com.yis.linkedList;

/**
 * 合并两个有序链表
 * @author YeShuai
 * @date 2021/3/25
 */
public class MergeTwoLists {

    /**
     * 迭代法
     * 1. 创建头和指针
     * 2. 相等或小于，加入小的，小的+1
     *    大于，加入小的，小的+1
     * 3. 指针+1
     * 4. 不为null的补在指针后面，返回头
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode pre = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2: l1;
        return newHead.next;
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val >= l2.val){
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }
    }

}
