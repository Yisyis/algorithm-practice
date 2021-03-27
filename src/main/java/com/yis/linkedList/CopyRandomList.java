package com.yis.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 */
public class CopyRandomList {

    Map<Node, Node> visitedMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 3. 当遇见访问过的节点，返回对应的node
        if (visitedMap.containsKey(head)) {
            return visitedMap.get(head);
        }
        // 1. 拷贝node
        Node node = new Node(head.val, null, null);
        // 访问过的节点保存到visitMap中
        visitedMap.put(head, node);

        // 2. 先接next，再接random
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}
