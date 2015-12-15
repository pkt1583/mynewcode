package com.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pankaj on 15-12-2015.
 */
public class GretchenPlay {
    public static void main(String[] args) {
        //Map<Integer,Integer>  actScene=new HashMap<>();
        Scanner scanner=new Scanner(System.in);
        int numberOfScenes=scanner.nextInt();
        int numberOfActors=scanner.nextInt();
        int[] scenes=new int[numberOfScenes];
        int[] actors=new int[numberOfActors];
        int numberOfActions=scanner.nextInt();
        for(int i=0;i<scenes.length;i++){
            scenes[i]=scanner.nextInt();
        }

        for(int i=0;i<scenes.length;i++){
            actors[scenes[i]]=actors[scenes[i]]+1;
        }

        for(int i=0;i<numberOfActions;i++){
            int actionCode=scanner.nextInt();
            if(actionCode==2){
                printActorAllocation(scanner.nextInt(),actors,scenes);
            }else{
                int fromNode=scanner.nextInt();
                int toNode=scanner.nextInt();
                changeAllocation(fromNode,toNode,actors);
            }
        }
    }

    private static void changeAllocation(int fromNode, int toNode,int[] actors) {
        int currentAllocation=actors[fromNode];
        actors[fromNode]=actors[fromNode]-1;
        actors[toNode]=actors[toNode]+1;
    }

    private static void printActorAllocation(int countAct,int[] actors,int[] scenes) {
        int count=0;
        for(int i=0;i<actors.length;i++){
            if(actors[i]<countAct) {
                count = count + 1;
            }
        }
        System.out.println(count);
    }
}
