package com.mustafaburakkilic.methodsandclasses;

public class Simspons {
    private String name;
    private int age;
    private String job;

    public Simspons(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }
    //getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }
    //setter

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
