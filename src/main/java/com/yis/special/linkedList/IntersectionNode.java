package com.yis.special.linkedList;

/**
 * 相交链表
 *
 * 输入的skipA /skipB 表示之前的节点即使值一样，但是 是new 在堆上的 地址会不一样，而后续节点是通过引用进行连接的链表；
 * =》所以题目可以表述为在两个链表中找到共有的 引用链表的头结点；
 *
 * 相当于都遍历了 A+B，最后同时达到末尾退出，即 null == null（找不到的情况），N = null，如下
 * [4,1,8,4,5],Null,5,0,1,8,4,5,Null
 * [5,0,1,8,4,5],Null,4,1,8,4,5,Null
 *
 * @author YeShuai
 * @date 2021/3/23
 */
public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;
        while (pointA != pointB) {
            pointA = (pointA == null)? headB : pointA.next;
            pointB = (pointB == null)? headA : pointB.next;
        }
        return pointA;
    }

}
