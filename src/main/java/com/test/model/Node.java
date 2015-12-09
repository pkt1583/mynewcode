package com.test.model;

import com.test.core.NodeFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by pankaj on 09-12-2015.
 */
public final class Node {
    private final String nodeName;

    private LinkedList<Node> parentNodes = new LinkedList<Node>();

    private LinkedList<Node> childNodes=new LinkedList<>();

    private Map<PathKey, Path> allPathsFromThisNode = new HashMap<>(); //careful with cycle

    public Node(String nodeName) {
        this.nodeName = nodeName;
    }

    public void addToPath(PathKey pathKey, PathElement pathElement) {
        Path path = this.allPathsFromThisNode.get(pathKey);
        path.getPathElement().setNextElementInPath(pathElement);
    }

    public String getNodeName() {
        return nodeName;
    }

    public void addParents(String... parents) {
        if (parents != null) {
            for (String parentNode : parents) {
                if (parentNode != null) {
                    Node parent=NodeFactory.INSTANCE.getNode(parentNode);
                    this.parentNodes.add(parent);
                    parent.childNodes.add(this);
                }
            }
        }
    }

    public List<Node> getAllChildrens(){
        List<Node> returnChildrenNodes=new LinkedList<>();
        for(Node childNode:this.childNodes){
            returnChildrenNodes.add(childNode);
            returnChildrenNodes.addAll(childNode.getAllChildrens());
        }
        return returnChildrenNodes;
    }

    public List<Node> getAllParents(){
        List<Node> returnParentNodes=new LinkedList<>();
        for(Node parentNode:this.parentNodes){
            returnParentNodes.add(parentNode);
            returnParentNodes.addAll(parentNode.getAllParents());
        }
        return returnParentNodes;
    }

    public List<Node> getParents() {
        return parentNodes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return nodeName != null ? nodeName.equals(node.nodeName) : node.nodeName == null;

    }

    @Override
    public int hashCode() {
        return nodeName != null ? nodeName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Node "+nodeName+" has parent "+printAll(parentNodes)+" and Children "+printAll(childNodes);
    }

    private String printAll(LinkedList<Node> childNodes) {
        StringBuilder sb=new StringBuilder();
        for(Node node:childNodes){
            sb.append(node.getNodeName()+"   ");
        }
        return sb.toString();
    }


    public boolean canReachTo(Node anotherNode) {
        List<Node> anotherNodeParent = this.getParents();
        if (anotherNodeParent != null && anotherNodeParent.size() > 0) {
            for (Node node : anotherNodeParent) {
                if (node.getNodeName().equals(anotherNode.getNodeName())) {
                    return true;
                } else {
                    return node.canReachTo(anotherNode);
                }
            }
        } else {
            return false;

        }
        return false;
    }

    public Map<PathKey, Path> getAllPathsFromThisNode() {
        return allPathsFromThisNode;
    }

    public void setAllPathsFromThisNode(Map<PathKey, Path> allPathsFromThisNode) {
        this.allPathsFromThisNode = allPathsFromThisNode;
    }

    /*public boolean isParent(Node parentOfWhat){
        for(Node oneParent:this.getParents()){
            if()
        }
    }*/
}
