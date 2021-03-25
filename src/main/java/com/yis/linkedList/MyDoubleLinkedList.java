package com.yis.linkedList;


/**
 * 双向链表
 *
 * @author YeShuai
 * @date 2021/3/25
 */
public class MyDoubleLinkedList {

    ListNode head;

    ListNode tail;

    int size;

    public MyDoubleLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = head;
        // +1 是因为有模拟头节点
        if (index + 1 < size - index) {
            for (int i = 0; i <= index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = 0; i < size - index; i++) {
                curr = curr.prev;
            }
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        // 超出链表范围
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        // 加入节点的前节点和后继节点
        ListNode pred;
        ListNode succ;
        // 在链表的前半段添加
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next;
        }
        // 在链表的后半段添加
        else {
            succ = tail;
            for (int i = 0; i < size - index; i++) {
                succ = succ.prev;
            }
            pred = succ.prev;
        }
        size++;
        ListNode curr = new ListNode(val);
        pred.next = curr;
        succ.prev = curr;
        curr.prev = pred;
        curr.next = succ;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode pred;
        ListNode succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index - 1; i++) {
                succ = succ.prev;
            }
            pred = succ.prev.prev;
        }
        size--;
        pred.next = succ;
        succ.prev = pred;
    }

}
