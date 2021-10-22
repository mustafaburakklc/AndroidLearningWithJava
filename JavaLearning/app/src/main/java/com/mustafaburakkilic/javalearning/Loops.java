package com.mustafaburakkilic.javalearning;

public class Loops {
    public static void main(String[] args) {
        //for loop
        int[] myNumbers = {12,15,18,21,24};
        for (int i=0;i<myNumbers.length;i++){
            int x= myNumbers[i]/3*5;
            System.out.println(x);
        }
        //for with arrays

        for(int number : myNumbers){
            int x=number/3*5;
            System.out.println(x);
        }

        for(int i=0;i<10;i++){
            int b=i*10;
            System.out.println(b);
        }

        //while loop
        int j=0;
        while(j<10){
            System.out.println("test");
            j++;
        }
    }
}
