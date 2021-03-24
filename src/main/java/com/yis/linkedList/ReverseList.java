package com.yis.linkedList;

/**
 * 反转链表
 *
 * @author YeShuai
 * @date 2021/3/24
 */
public class ReverseList {

    /**
     * 迭代法
     * 解法： 将头两个节点交换，存储到pre中
     * next节点 指向 pre，再将自己存储到pre中
     * 最后返回pre
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归法:   花了1个小时半
     * 解法：
     * 遇到递归终止条件后，newHead 始终指向原链表的末尾元素，也就是新链表的头节点。
     * 自从 origin 状态器，该链表就已被隐形的分为了两条叉，分别是 head, newHead
     *
     * 每一个"插入"操作，都可以理解为是从"正序部分"链表中取出其尾元素，
     * 插入至"逆序部分"的尾部。
     *
     * origin:
     * 1 -> 2 -> 3 -> 4 -> 5 -> nil
     * 				^	^
     * 			  head	newHead
     *
     * first:
     * 1 -> 2 -> 3         5 -> 4 -> nil
     *           ^--------------^
     *           ^          ^
     *         head         newHead
     *
     * second:
     * 1 -> 2              5 -> 4 -> 3 -> nil
     *      ^------------------------^
     *      ^               ^
     *    head              newHead
     *
     * third:
     * 1      				5 -> 4 -> 3 -> 2 -> nil
     * ^----------------------------------^
     * ^                     ^
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 当newHead=5时, head=4->5,  这里 5 的引用地址是同一个引用地址
        ListNode newHead = reverseList2(head.next);
        // head=4->5->4, newHead=5->4, 5和4 都是同一条链表的同一个引用地址
        head.next.next = head;
        // head=4->null, newHead=5->4->null
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ReverseList reverse = new ReverseList();
        ListNode node = reverse.reverseList2(node1);
        System.out.println(node);
    }

}
