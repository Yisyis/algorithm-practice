package com.yis.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * LIFO
 * last input first output
 *
 * @author YeShuai
 * @date 2021/2/3
 */
public class MyStack {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        // javaStack.push(1);
        // javaStack.push(2);
        // javaStack.push(3);
        // javaStack.push(4);
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());

    }

    private List<Integer> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
    }

    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        data.remove(data.size() - 1);
        return true;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return data.get(data.size() - 1);
    }

}
