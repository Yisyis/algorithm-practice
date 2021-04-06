package com.yis.special.stack;

import java.util.Stack;

/**
 * @author YeShuai
 * @date 2021/2/3
 */
public class JavaStack {

    public static void main(String[] args) {
        Stack<Integer> javaStack = new Stack<>();

        System.out.println(javaStack.isEmpty());
        javaStack.empty();

        javaStack.push(1);
        System.out.println(javaStack.pop());
        System.out.println(javaStack.peek());


    }


}
