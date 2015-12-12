package com.test.core;

import com.sun.javafx.sg.prism.NGNode;
import com.test.model.Node;
import com.test.model.Path;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class NodeFactoryTest {

    Node ANode=NodeFactory.INSTANCE.getNode("A");
    Node BNode=NodeFactory.INSTANCE.getNode("B");
    Node CNode=NodeFactory.INSTANCE.getNode("C");
    Node DNode=NodeFactory.INSTANCE.getNode("D");
    Node ENode=NodeFactory.INSTANCE.getNode("E");
    Node FNode=NodeFactory.INSTANCE.getNode("F");
    Node GNode=NodeFactory.INSTANCE.getNode("G");

    @Before
    public void setUp()throws Exception{
        GNode.addParents("F","D");
        FNode.addParents("E");
        ENode.addParents("B");
        DNode.addParents("C");
        CNode.addParents("B");
        BNode.addParents("A");
        ANode.addParents(null);
    }


    @Test
    public void testGetNode() throws Exception {
        List<Node> parentNodes= NodeFactory.INSTANCE.getNode("G").getParents();
        System.out.println(parentNodes);
    }

    @Test
    public void testChildren()throws Exception{
        System.out.println(ANode.getAllChildrens());
    }

    @Test
    public void testParent()throws Exception{

        LinkedList<Node> dnodes= (LinkedList<Node>) DNode.getAllParents();

        System.out.println("****************************************");

        LinkedList<Node> fnodes= (LinkedList<Node>) FNode.getAllParents();


    }

    @Test
    public void testGetCommonNode()throws Exception{
        String find1="D",find2="F";
        Node commonNode= NodeFactory.INSTANCE.getCommonNode(find1, find2);
        assertEquals("B", commonNode.getNodeName());
    }

    @Test
    public void testChild() throws Exception{

    }

    @Test
    public void testReachable()throws Exception{
        Node sourceNode= NodeFactory.INSTANCE.getNode("D");
        Node targetNode=NodeFactory.INSTANCE.getNode("A");
        Path path=  NodeFactory.INSTANCE.getPath(sourceNode,targetNode);
        System.out.println(sourceNode.canReachTo(targetNode));
        //   assertEquals(true,sourceNode.canReachTo(NodeFactory.INSTANCE.getNode("A")));

        sourceNode= NodeFactory.INSTANCE.getNode("G");
        //  assertEquals(true,sourceNode.canReachTo(NodeFactory.INSTANCE.getNode("A")));
    }

    @Test
    public void testGetTotalNodes() throws Exception {
        int totalNodes=NodeFactory.INSTANCE.getTotalNodes();
        System.out.println(totalNodes);
        assertEquals(7,totalNodes);
    }
}