package com.yis.special.queue.bfs;

import java.util.*;

/**
 *  752 打开转盘锁
 * @author YeShuai
 * @date 2021/1/22
 */
public class OpenLock {

    public int BFS(String[] deadends, String target) {
        if (null == target || target.length() == 0) {
            return -1;
        }
        String start = "0000";
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        if (deads.contains(start) || deads.contains(target)) {
            return -1;
        }
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        int steps = 0;
        queue1.add(start);
        while (!queue1.isEmpty()) {
            String cur = queue1.poll();
            if (cur.equals(target)) {
                return steps;
            }
            List<String> nexts = getNeighbor(cur);
            for (String next : nexts) {
                if (!deads.contains(next) && !visited.contains(next)) {
                    queue2.offer(next);
                    visited.add(next);
                }
            }
            if (queue1.isEmpty()) {
                steps++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return -1;
    }

    public List<String> getNeighbor(String cur) {
        List<String> nexts = new LinkedList<>();
        for (int i = 0; i < cur.length(); i++) {
            char c = cur.charAt(i);
            char newC = c == '0' ? '9' : (char)(c - 1);
            StringBuilder next = new StringBuilder(cur);
            next.setCharAt(i, newC);
            nexts.add(next.toString());

            newC = c == '9' ? '0' : (char)(c + 1);
            next = new StringBuilder(cur);
            next.setCharAt(i, newC);
            nexts.add(next.toString());
        }
        return nexts;
    }
}
