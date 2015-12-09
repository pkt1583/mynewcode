package com.test.model;

import com.test.model.Node;

/**
 * Created by pankaj on 09-12-2015.
 */
public final class PathKey {
    private Node startNode;
    private Node endNode;

    public PathKey(Node startNode, Node endNode) {
        this.startNode = startNode;
        this.endNode = endNode;
    }
}
