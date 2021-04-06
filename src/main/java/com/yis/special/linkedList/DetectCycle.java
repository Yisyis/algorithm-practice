package com.yis.special.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 * 找到闭环的起点
 * <p>
 * 1. hash表遍历法
 * 2. 龟兔赛跑
 *
 * @author YeShuai
 * @date 2021/3/22
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode curPoint = head;
        while (curPoint != null) {
            if (visited.contains(curPoint)) {
                return curPoint;
            } else {
                visited.add(curPoint);
            }
            curPoint = curPoint.next;
        }
        return null;
    }

    /**
     * 快慢指针
     * 设链表中环外部分的长度为 a。slow指针进入环后，又走了b的距离与fast相遇。
     * 此时，fast指针已经走完了环的n圈。
     * 因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nc
     *  任意时刻，fast指针走过的距离都为slow指针的2倍。因此，我们有
     *  a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
     *  从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离。
     *
     *  1. 在快慢指针 相聚时，根据上述公式
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode begin = head;
                while (begin != slow) {
                    begin = begin.next;
                    slow = slow.next;
                }
                return begin;
            }
        }
        return null;
    }
}
