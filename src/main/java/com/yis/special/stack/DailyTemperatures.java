package com.yis.special.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * @author YeShuai
 * @date 2021/2/3
 */
public class DailyTemperatures {

    private int[] temperatures(int[] T) {
        int[] res = new int[T.length];
        // for (int i = 0; i < T.length; i++) {
        //     for (int j = i + 1; j < T.length; j++) {
        //         if (T[j] > T[i]) {
        //             res[i] = j - i;
        //             break;
        //         }
        //     }
        // }
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < T.length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }


        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] temperatures1 = dailyTemperatures.temperatures(temperatures);
        System.out.println(temperatures1);
    }
}
