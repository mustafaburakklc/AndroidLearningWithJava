package com.mustafaburakkilic.methodsandclasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate called");
        testMethod();
        System.out.println(newMethod("mustafa"));
        makeMusicians();
        makeSimpsons();
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause called");
    }

    public void testMethod(){
        int x = 4+4;
        System.out.println("value of x: "+x);
    }

    public int math(int a,int b){
        return a+b;
    }

    public String newMethod(String string){
        return string +" new method";
    }

    public void makeMusicians(){
        Musicians james = new Musicians("James","Guitar",50);

    }
    public void makeSimpsons(){
        Simspons homer = new Simspons("Homer",50,"Nuclear");
        homer.setAge(51);
        System.out.println(homer.getAge());
    }
}