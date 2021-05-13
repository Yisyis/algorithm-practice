package com.yis.freqLeet.reverseList;



/**
 * 递归：
 * 1.反转链表
 * 2.反转链表 前N个节点
 * 3.反转链表 第M-N个节点
 *
 * 迭代：
 * 1.反转链表
 * 2.反转链表 区间内[a,n)的元素 不包括n
 * 3.k个一组反转链表
 *
 * 回文链表：
 * 1. O(n) O(n)
 * 2. O(n) O(1) 快慢指针，反转后半链表
 * @author YeShuai
 * @date 2021/4/6
 */
public class ReverseList {

    /**
     * （递归版）
     * 1. 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null ||head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        // 指向反转
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * （递归版）
     * 2. 反转链表 前K个节点
     *
     * @param head
     * @return
     */
    ListNode tail = null;
    public ListNode reverseN(ListNode head, int k) {
        // 记录后续不反转的链表
        if (k == 1) {
            tail = head.next;
            return head;
        }
        // 反转链表，将不反转的节点接在后面
        ListNode last = reverseN(head.next, k-1);
        head.next.next = head;
        head.next = tail;
        return last;
    }

    /**
     * (递归版)
     * 3. 反转链表 第m个到第n个节点
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseMN(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseMN(head.next, m - 1, n - 1);
        return head;
    }


    /**
     * （迭代）
     * 1. 反转链表
     * 1-2-3-4-5-null
     * @param head
     * @return
     */
    public ListNode reverseList01(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt;
        while (cur != null) {
            // 移动next指针
            nxt = cur.next;
            // 反转指向
            cur.next = pre;
            // 移动指针 pre、cur
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    /**
     * （迭代）
     *  2. 反转链表 区间内的元素，左闭右开
     *  1-2-3-4-5-null
     * @param a
     * @param b
     * @return
     */
    public ListNode reverseN01(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode nxt;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    /**
     * 3.k个一组反转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverseN01(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 1. 判断回文链表 O(n)
     * 后续递归找到倒序节点，逐一比较
     * @param head
     * @return
     */
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        // 后续遍历，开始比对值
        if (res && left.val == right.val) {
            left = left.next;
            return true;
        }
        return res;
    }

    /**
     * 2. 判断回文链表 O(n)
     * 快慢指针：中点反转
     * 1-2-3-4-5-6-null
     * @param head
     * @return
     */
    public boolean isPalindrome01(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 快慢指针找到中点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 记录最中、右指针位置
        ListNode right = reverseList(slow.next);
        boolean res = true;
        // 左半链表
        ListNode firstHalf = head;
        // 反转后半段链表
        ListNode secondHalf = right;
        // 逐步比对
        while (res && secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                res = false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        // 还原链表原始结构
        firstHalf.next = reverseList(right);
        return res;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        // ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node5;
        // node4.next = node5;
        node5.next = node6;
        ReverseList reverse = new ReverseList();
        boolean node = reverse.isPalindrome01(node1);
        System.out.println(node);
    }


}
