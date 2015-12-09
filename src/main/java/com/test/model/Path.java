package com.test.model;

/**
 * Created by pankaj on 09-12-2015.
 */
public final class Path {
    private Node startNode;
    private Node endNode;
    private PathElement pathElement;
    private boolean noPath;

    public Path(Node startNode, Node endNode) {
        this.startNode = startNode;
        this.endNode = endNode;
    }

    public boolean isNoPath() {
        return noPath;
    }

    public void setNoPath(boolean noPath) {
        this.noPath = noPath;
    }

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    @Override
    public String toString() {
        return "Path{" +
                "startNode=" + startNode +
                ", endNode=" + endNode +
                ", pathElement=" + pathElement +
                ", noPath=" + noPath +
                '}';
    }

    public Node getEndNode() {
        return endNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }

    public PathElement getPathElement() {
        return pathElement;
    }

    public void setPathElement(PathElement pathElement) {
        this.pathElement = pathElement;
    }
}
