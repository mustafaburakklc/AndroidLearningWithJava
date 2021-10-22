package com.mustafaburakkilic.methodsandclasses;

public class Musicians {
    //attributes
    String name;
    String instrument;
    int age;
    //constructor
    public Musicians(String name, String instrument, int age) {
        this.name = name;
        this.instrument = instrument;
        this.age = age;
        System.out.println("constructor called");
    }
}
