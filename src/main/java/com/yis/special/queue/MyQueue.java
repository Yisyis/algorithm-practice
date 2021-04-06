package com.yis.special.queue;

import java.util.Stack;

/**
 *  用栈实现队列
 * @author YeShuai
 * @date 2021/2/19
 */
public class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> stack1;
    private int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        stack1 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (stack.empty()) {
            front = x;
        }
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack1.empty()) {
            while(!stack.empty()) {
                stack1.push(stack.pop());
            }
        }
        return stack1.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!stack1.empty()) {
            return stack1.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty() && stack1.empty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return fals
    }
}