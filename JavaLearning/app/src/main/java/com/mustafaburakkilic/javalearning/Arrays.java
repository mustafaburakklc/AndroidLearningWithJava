package com.mustafaburakkilic.javalearning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Arrays {
    public static void main(String[] args) {
        //string array initialization
        String [] myStringArray = new String[3];
        myStringArray[0]="James";
        myStringArray[1]="Lars";
        myStringArray[2]="Kirk";

        System.out.println(myStringArray[0]);
        System.out.println(myStringArray[1]);
        System.out.println(myStringArray[2]);

        //integer array

        int [] myIntegerArray = new int[3];
        myIntegerArray[0]=50;
        myIntegerArray[1]=60;
        myIntegerArray[2]=70;

        int[] myNumberArray ={1,2,3,4,5,6,7,8};
        System.out.println("third number of array"+myNumberArray[2]);

        //Lists

        ArrayList<String> myMusicians = new ArrayList<>();

        myMusicians.add("James");
        myMusicians.add("Lars");
        myMusicians.add(1,"Kirk");
        myMusicians.add("Kirk");


        System.out.println(myMusicians.get(0));
        System.out.println(myMusicians.get(1));
        System.out.println(myMusicians.get(2));
        System.out.println(myMusicians.get(3));

        //Set

        HashSet<String> mySet = new HashSet<>();
        mySet.add("James");
        mySet.add("James");
        System.out.println(mySet.size());

        //HashMap

        HashMap<String,String> myHashMap = new HashMap<>();
        myHashMap.put("name","James");
        myHashMap.put("instrument","Guitar");

        System.out.println(myHashMap.get("name"));
        System.out.println(myHashMap.get("instrument"));

        HashMap<String,Integer> mySecondHashMap = new HashMap<>();

        mySecondHashMap.put("run",100);
        mySecondHashMap.put("basketball",200);

        System.out.println(mySecondHashMap.get("run"));


    }
}
