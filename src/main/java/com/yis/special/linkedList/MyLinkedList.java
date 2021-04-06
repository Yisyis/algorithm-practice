package com.yis.special.linkedList;

/**
 * 单链表
 * 前提： 创建对象模拟 链表单节点，head为链表的头
 * 添加、删除、查找
 * 遍历到index，修改前节点，当前节点的next
 * 注意边界条件
 *
 * @author YeShuai
 * @date 2021/3/22
 */
public class MyLinkedList {

    int size;

    ListNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode pred = head;
        for (int i = 0; i <= index - 1; i++) {
            pred = pred.next;
        }
        ListNode add = new ListNode(val);
        add.next = pred.next;
        pred.next = add;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pred = head;
        for (int i = 0; i <= index - 1; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }

}
