package com.yis.linkedList;

/**
 * @author YeShuai
 * @date 2021/3/26
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node random;

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
