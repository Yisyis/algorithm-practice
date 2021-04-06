package com.yis.special.linkedList;

/**
 * 奇偶链表
 *
 * @author YeShuai
 * @date 2021/3/24
 */
public class OddEvenList {

    // head evenHead
    //   1,   2,   3,   4
    //            odd

    /**
     * 分离节点后合并
     * 解法：
     * 如果链表为空，则直接返回链表。
     * 维护两个指针odd和even分别指向奇节点和偶节点，通过迭代的方式将奇数节点和偶数节点分离成两个链表
     * 最后将奇数链表和偶数链表合并
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = head.next;
        // odd和even 维护的指针
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            // 两个相邻的奇数节点相连，将odd指针指向新的奇数节点
            odd.next = even.next;
            odd = odd.next;
            // 上面被跳过的偶数节点 和 下个偶节点 相连，将even指针指向新的偶数节点
            even.next = odd.next;
            even = even.next;
        }
        // 合并两个链表
        odd.next = evenHead;
        return head;
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
        OddEvenList oddEvenList = new OddEvenList();
        ListNode node = oddEvenList.oddEvenList(node1);
        System.out.println(node);
    }
}
