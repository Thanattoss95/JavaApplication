package com.main;

import java.util.ArrayList;

public class Role {

    private String name;
    private ArrayList<skills> expectedSkills;
    private Person assignEmployee;

    public Role(String name){
        this.name = name;
        assignEmployee = null;
        expectedSkills = new ArrayList<>();
    }
    public void addSkills(skills s){
        expectedSkills.add(s);
    }
    public String getName(){
        return this.name;
    }
    public void setEmployee(Person p){
        this.assignEmployee = p;
    }
    public boolean getRole(Person p){
        //System.out.print("test" +assignEmployee.getName());
       return p == assignEmployee;
    }
}
