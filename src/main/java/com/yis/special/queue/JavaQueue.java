package com.yis.special.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Java内置队列方法的使用
 *      FIFO： first input first output
 * @author YeShuai
 * @date 2021/1/22
 */
public class JavaQueue {

    public static void main(String[] args) {
        // 1. 初始化queue
        Queue<Integer> queue = new LinkedList<>();
        // 2. 返回第一元素，为null则为空队列
        System.out.println(queue.peek());
        // 3. 压入  空间受限时，offer返回null（优先使用），add报非法状态异常
        queue.offer(5);
        queue.add(13);
        queue.add(14);
        queue.offer(15);
        // 4. 弹出元素
        queue.poll();
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
