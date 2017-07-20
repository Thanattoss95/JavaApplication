package com.main;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<skills> mySkills;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        this.mySkills = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }
    public void addSkills(skills s){
        mySkills.add(s);
    }

    public void setName(String name){
        this.name = name;
    }
}
