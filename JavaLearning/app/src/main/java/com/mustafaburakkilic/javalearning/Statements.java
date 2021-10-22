package com.mustafaburakkilic.javalearning;

public class Statements {
    public static void main(String[] args) {
        int x =5;
        System.out.println(x);
        x=x+1;
        System.out.println(x);
        x++;
        System.out.println(x);
        x--;
        System.out.println(x);
        x=x*5;
        System.out.println(x);

        int y=4;
        System.out.println(x>y);
        System.out.println(y>x);

        y=30;
        System.out.println(x>y);

        System.out.println(x>=y);
        System.out.println(x==y);
        System.out.println(x!=y);

        //and  && ----  or ||

        x=3;
        y=4;
        int z=5;

        System.out.println(x<y && y<z);

        //if statements

        if (x<y){
            System.out.println("y is bigger than x");
        }
        else if(y<x){
            System.out.println("x is bigger than y");
        }
        else
            System.out.println("x is equal to y");

        //switch

        int day=1;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;

        }
    }
}
