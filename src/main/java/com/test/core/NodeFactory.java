package com.test.core;

import com.test.model.Node;
import com.test.model.Path;
import com.test.model.PathElement;
import com.test.model.PathKey;

import java.util.HashMap;
import java.util.Map;

public enum NodeFactory {
    INSTANCE;

    Map<PathKey, Path> paths = new HashMap<>();
    private Map<String, Node> nodeCache = new HashMap<String, Node>();

    public Node getNode(String name) {
        Node nodeFromCache = nodeCache.get(name);
        if (nodeFromCache == null) {
            nodeFromCache = new Node(name);
            nodeCache.put(name, nodeFromCache);
        }
        return nodeFromCache;
    }

    public int getTotalNodes() {
        return nodeCache.size();
    }

    public Node getCommonNode(String find1, String find2) {
        Node node = getNode(find1);
        Node anotherNode = getNode(find2);
        for (Node parent : node.getParents()) {
          /*  if(parent.canReachTo(anotherNode)){
                return parent;
            }*/
        }
        return null;
    }

    public Path getPath(Node sourceNode, Node targetNode) {
        PathKey probablePathKey = new PathKey(sourceNode, targetNode);
        Path path = paths.get(probablePathKey);
        if (path != null) {
            return path;
        } else {
            path = new Path(sourceNode, targetNode);
            path.setPathElement(new PathElement(sourceNode));
            paths.put(probablePathKey, path);
            return path;
        }

    }


}