package com.yis.linkedList;

/**
 * 回文链表    labuladong有提及新的递归解法
 * @author YeShuai
 * @date 2021/3/24
 */
public class Palindrome {

    /**
     * 快慢针
     * 解法：
     * 1.找到中间位置，快慢指针，快两步，慢一步
     * 2.对后半段进行反转
     * 3.比较值
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseSecondHalf(firstHalfEnd.next);

        // 比较值
        ListNode first = head;
        ListNode second = secondHalfStart;
        boolean result = true;
        while (result && second != null) {
            if (first.val != second.val) {
                result = false;
            }
            first = first.next;
            second = second.next;
        }
        // 还原链表
        firstHalfEnd.next = reverseSecondHalf(secondHalfStart);
        return result;
    }

    /**
     * 中间位置
      */
    public ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // null 1 2 3 4 5
    public ListNode reverseSecondHalf(ListNode head) {
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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Palindrome reverse = new Palindrome();
        boolean node = reverse.isPalindrome(node1);
        System.out.println(node);
    }


}
