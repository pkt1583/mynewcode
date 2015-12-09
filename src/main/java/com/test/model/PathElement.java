package com.test.model;

/**
 * Created by pankaj on 09-12-2015.
 */
public final class PathElement {
    private Node nodeInPath;
    private PathElement nextElementInPath;

    public PathElement(Node nodeInPath) {
        this.nodeInPath = nodeInPath;
    }

    @Override
    public String toString() {
        return "PathElement{" +
                "nodeInPath=" + nodeInPath +
                ", nextElementInPath=" + nextElementInPath +
                '}';
    }

    public Node getNodeInPath() {
        return nodeInPath;
    }

    public PathElement getNextElementInPath() {
        return nextElementInPath;
    }

    public void setNextElementInPath(PathElement nextElementInPath) {
        this.nextElementInPath = nextElementInPath;
    }
}
