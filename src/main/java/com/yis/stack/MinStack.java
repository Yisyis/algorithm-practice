package com.yis.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeShuai
 * @date 2021/2/3
 */
public class MinStack {

    private List<Integer> data;

    public MinStack() {
        data = new ArrayList<>();
    }

    public boolean isEmpty() {
        return data.isEmpty();
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

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        int min = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            if (min > data.get(i)) {
                min = data.get(i);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.pop();
    }
}
