package com.yis.queue.bfs;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *     广度优先搜索 模板
 *  求最短路径
 * BFS: breadth first search
 *
 * @author YeShuai
 * @date 2021/1/22
 */
public class ShortestLength {

    /**
     方法1
     */
    int BFS(Node root, Node target) {
        Queue<Node> queue = new LinkedList<>();
        int step = 0;
        queue.offer(root);
        // BFS
        while (!queue.isEmpty()) {
            step = step + 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.peek();
                if (cur.equals(target)) {
                    return step;
                }
                for (int j = 0; j < cur.getChildNodes().getLength(); j++) {
                    Node item = cur.getChildNodes().item(j);
                    queue.offer(item);
                }
                queue.poll();
            }
        }
        return -1;
    }

    /**
     * 方法2 备忘录存储-已遍历节点
      */
    int BFS2(Node root, Node target) {
        Queue<Node> queue = new LinkedList<>();
        // 存储已遍历节点
        Set<Node> usedNode = null;
        queue.offer(root);
        usedNode.add(root);
        int step = 0;
        while (!queue.isEmpty()) {
            step = step + 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.peek();
                if (cur.equals(target)) {
                    return step;
                }
                for (int j = 0; j < cur.getChildNodes().getLength(); j++) {
                    Node item = cur.getChildNodes().item(j);
                    // 判断该节点是否已遍历
                    if (!usedNode.contains(item)) {
                        queue.offer(item);
                        usedNode.add(item);
                    }
                }
                queue.poll();
            }
        }
        return -1;
    }

}
