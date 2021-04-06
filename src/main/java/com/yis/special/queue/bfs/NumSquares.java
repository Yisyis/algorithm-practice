package com.yis.special.queue.bfs;

import java.util.*;

/**
 *  279 完全平方数
 *  BFS + 贪心算法
 * @author YeShuai
 * @date 2021/1/25
 */
public class NumSquares {

    public int BFS(int n) {
        List<Integer> num_square = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            num_square.add(i * i);
        }
        int level = 0;
        Set<Integer> queue = new HashSet<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            level += 1;
            Set<Integer> next_queue = new HashSet<>();
            for (Integer num : queue) {
                for (Integer square : num_square) {
                    if (num.equals(square)) {
                        return level;
                    } else if (square > num) {
                        break;
                    } else {
                        next_queue.add(num - square);
                    }
                }
            }
            queue = next_queue;
        }
        return -1;
    }

}
