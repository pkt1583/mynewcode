package com.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by pankaj on 08-12-2015.
 */
public enum  NodeFactory {
    INSTANCE;

    private Map<String,Node> nodeCache=new HashMap<String, Node>();

    public Node getNode(String name){
        Node nodeFromCache=nodeCache.get(name);
        if(nodeFromCache==null){
            nodeFromCache=new Node(name);
        }
        return nodeFromCache;
    }

    public int getTotalNodes(){
        return nodeCache.size();
    }



    public final class Node {


        private final String nodeName;
        private LinkedList<Node> parentNode=new LinkedList<Node>();

        public Node(String nodeName) {
            this.nodeName = nodeName;
        }

       public void addParents(String ... parents){
           if(parents!=null) {
               for (String parentNode : parents) {
                   if (parentNode != null) {


                       this.parentNode.add(INSTANCE.getNode(parentNode));
                   }
               }
           }
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

    }
}
