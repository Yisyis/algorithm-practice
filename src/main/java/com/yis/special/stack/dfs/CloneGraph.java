package com.yis.special.stack.dfs;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author YeShuai
 * @date 2021/2/8
 */
public class CloneGraph {

    private HashMap<Node, Node> visited = new HashMap<>();

    public Node getGraph(Node node) {
        if (null == node) {
            return node;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode );
        for (Node neighborNode : node.neighbors) {
            cloneNode.neighbors.add(getGraph(neighborNode));
        }
        return cloneNode;
    }
}
