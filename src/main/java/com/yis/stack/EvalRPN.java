package com.yis.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 逆波兰表达式主要有以下两个优点：
 * <p>
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 * ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 *
 * @author YeShuai
 * @date 2021/2/4
 */
public class EvalRPN {

    private int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        Integer op1, op2;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op1 + op2);
                    break;
                case "-":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 - op1);
                    break;
                case "*":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op1 * op2);
                    break;
                case "/":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 / op1);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        String[] str = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN.evalRPN(str));

    }

}
