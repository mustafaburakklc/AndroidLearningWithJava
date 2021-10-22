package com.mustafaburakkilic.javalearning;

public class Variables {
    public static void main(String[] args) {
        //system out
        System.out.println("Hello Java");
        //Variables
        //Integer
        int age=20;
        System.out.println(10*age);
        int x=5;
        int y=10;
        System.out.println(y/x);
        //Double-Float
        double z=5.0;
        float a=5.0f;
        System.out.println(z/a);
        //circumference of the circle
        double pi =3.14; //pi constant
        int r=5; //radius
        System.out.println(2*pi*r);
        //String
        String name = "James";
        String surname = "Hetfield";
        System.out.println("Name:"+name+" Surname:"+surname);
        String fullName = name + " "+surname;
        System.out.println(fullName);
        //Boolean
        boolean isAlive = true;
        isAlive = false;
        System.out.println(isAlive);
        //Final
        int myInteger = 5;
        myInteger=4;//if i want,i can change value of myInteger
        final int myFinalInteger=0; //with final tag, i can have an unchangeable value
        //Arrays


    }
}
