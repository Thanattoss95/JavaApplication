package com.main;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Department{

    //Object/Class attributes
    private String name;
    private String operation;
    private ArrayList<Person> employees;
    private ArrayList<Role> roles;

    //Constructor
    public Department(String name, String operation){
        this.employees = new ArrayList<>();
        this.roles = new ArrayList<>();
        this.name = name;
        this.operation = operation;
    }

    public void moveEmployeeToDepartment(Person p){
            this.employees.add(p);

    }
    public String getName(){
        return this.name;
    }
    public void getEmployeesForDepartment(){
       System.out.println( "The " + this.name + " department. They operate in " + this.operation);
       System.out.println( "Team members include: ");
       loop1: for(Person p : employees){
           for(Role r : roles){
               if(r.getRole(p)){
                   System.out.println(r.getName() + ": " +p.getName());
                   continue loop1;
               }
           }
       }
    }
    public boolean isInDepartment(Person p){
        return this.employees.contains(p);
    }
    public void removeEmployee(Person p){
        this.employees.remove(p);
    }
    public void createRole(String name, ArrayList<skills> skills){
        Role r = new Role(name);
        this.roles.add(r);
    }
    private Role getRoleByName(String name){
        for(Role r : this.roles){
            if(r.getName().equals(name)){
                return r;
            }
        }
        return null;
    }
    public void assignRole(Person p, String roleName){
        Role r = getRoleByName(roleName);
        if(r != null && isInDepartment(p)) {
            r.setEmployee(p);
        }
    }
}
