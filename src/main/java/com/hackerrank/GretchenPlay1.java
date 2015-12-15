package com.hackerrank;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pankaj on 15-12-2015.
 */
public class GretchenPlay1 {
   // static List<Integer> output=new LinkedList<>();
    static String lineSep=System.lineSeparator();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) {
        //Map<Integer,Integer>  actScene=new HashMap<>();
        Scanner scanner=new Scanner(System.in);
        int numberOfScenes=scanner.nextInt();
        int numberOfActors=scanner.nextInt();
        int[] actors=new int[numberOfActors];
        int numberOfActions=scanner.nextInt();

        for(int i=0;i<numberOfScenes;i++){
            int index=scanner.nextInt();
            actors[index]=actors[index]+1;
        }

        for(int i=0;i<numberOfActions;i++){
            int actionCode=scanner.nextInt();
            if(actionCode==2){
                printActorAllocation(scanner.nextInt(),actors);
            }else{
                int fromNode=scanner.nextInt();
                int toNode=scanner.nextInt();
                changeAllocation(fromNode,toNode,actors);
            }
        }
        print();
    }

    private static void print() {
       // System.out.println(sb.toString());
    }

    private static void changeAllocation(int fromNode, int toNode,int[] actors) {
        int currentAllocation=actors[fromNode];
        if(currentAllocation!=0) {
            actors[fromNode] = actors[fromNode] - 1;
        }
        actors[toNode]=actors[toNode]+1;
    }

    private static void printActorAllocation(int countAct,int[] actors) {
        int count=0;
        for(int i=0;i<actors.length;i++){
            if(actors[i]<=countAct && actors[i]!=0) {
                count = count + 1;
            }
        }
     //   output.add(count);
        System.out.println(count);
        sb.append(count).append(lineSep);
    }
}
