package com.model;

/**
 * Created by pankaj on 08-12-2015.
 */
public class TestClass {
    public static void main(String[] args) {
       NodeFactory.INSTANCE.getNode("A").addParents("F","D");
        NodeFactory.INSTANCE.getNode("F").addParents("E");
        NodeFactory.INSTANCE.getNode("E").addParents("B");
        NodeFactory.INSTANCE.getNode("D").addParents("C");
        NodeFactory.INSTANCE.getNode("C").addParents("B");
        NodeFactory.INSTANCE.getNode("B").addParents("A");
        NodeFactory.INSTANCE.getNode("A").addParents(null);
        System.out.println(NodeFactory.INSTANCE.getTotalNodes());
    }
}
