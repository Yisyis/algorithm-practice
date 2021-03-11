package com.yis.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  字符串解码
 * @author YeShuai
 * @date 2021/2/19
 */
public class decodeString {

    int i;

    public String decodeString(String s) {
        i = 0;
        Deque<String> stack = new LinkedList<>();
        while (i< s.length()) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                String digits = getDigits(s);
                stack.push(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                stack.push(String.valueOf(s.charAt(i++)));
            } else {
                i++;
                StringBuilder str = new StringBuilder();
                while (!"[".equals(stack.peek())) {
                    str.insert(0, stack.pop());
                }
                StringBuilder str1 = new StringBuilder();
                stack.pop();
                int n = Integer.parseInt(stack.pop());
                for (int j = 0; j < n; j++) {
                    str1.append(str.toString());
                }
                stack.push(str1.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

    public String getDigits(String s) {
        StringBuilder ret = new StringBuilder();
        while (Character.isDigit(s.charAt(i))) {
            ret.append(s.charAt(i++));
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        decodeString s = new decodeString();
        String string = s.decodeString("30[a]20[bc]");
        System.out.println(string);
    }
}
