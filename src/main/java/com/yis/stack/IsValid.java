package com.yis.stack;

import java.util.*;

/**
 * @author YeShuai
 * @date 2021/2/3
 */
public class IsValid {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();
        Stack<Character> newStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if (newStack.size() != 0 && newStack.peek().equals(map.get(stack.peek()))) {
                stack.pop();
                newStack.pop();
                // i++;
                continue;
            }
            newStack.push(stack.pop());
        }

        if (stack.size() == 0 && newStack.size() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        // String s = "()[]{}";
        String s = "()[({})]";
        System.out.println(isValid.isValid(s));
    }
}
