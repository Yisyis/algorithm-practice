package com.yis.special.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YeShuai
 * @date 2021/2/19
 */
public class MyStack2 {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack2() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // int n = q1.size();
        // q1.offer(x);
        // for (int i = 0; i < n; i++) {
        //     q1.offer(q1.poll());
        // }
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack2 myStack = new MyStack2();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop(); // 返回 2
        myStack.pop(); // 返回 2
        myStack.pop(); // 返回 2
        myStack.empty(); // 返回 False

    }
}
