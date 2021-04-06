package com.yis.special.stack.dfs;

import org.w3c.dom.Node;

import java.util.Set;

/**
 * @author YeShuai
 * @date 2021/2/4
 */
public class ShortestLength {

        private boolean DFS(Node cur, Node target, Set<Node> visited) {
            if (cur.equals(target)) {
                return true;
            }
            for (int i = 0; i < cur.getChildNodes().getLength() ; i++) {
                Node next = cur.getChildNodes().item(i);
                // 判断该节点是否已遍历
                if (!visited.contains(next)) {
                    visited.add(next);
                    if (DFS(next, target, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

}
