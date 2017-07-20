package com.main;

import java.util.ArrayList;

public class Company {
    //Attributes
    private ArrayList<Department> departments;
    private ArrayList<Person> employees;
    private String companyName;

    //constructor
    public Company(String companyName){
        this.companyName = companyName;
        this.departments = new ArrayList<>();
        this.employees = new ArrayList<>();
    }
    public String getName(){
        return this.companyName;
    }
    public void employPerson(Person p){
        this.employees.add(p);
    }
    public void fireEmployee(Person p){
        this.employees.remove(p);
        for(Department d : this.departments){
            d.removeEmployee(p);
        }
    }
    public ArrayList<Person> getEmployees(){
        return this.employees;
    }
    public void printAllEmployees() {
        System.out.println(this.companyName + " has " + this.employees.size() + " number of employees. Members are: ");

        for(Person p : this.employees){
            System.out.println(p.getName());
        }
    }
    public void createDepartment(String name, String operation){
        Department d = new Department(name,operation);
        this.departments.add((d));
    }
    public void getAllDepartments(){
        for(Department d : this.departments){
            d.getEmployeesForDepartment();
        }
    }
    public Department getDepartmentByName(String name){
        for(Department d : this.departments){
            if(d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }
    public void moveEmployeeToDepartment(Person p, Department d) {
        if(d != null) {
            if (isPersonStaff(p) && doesDepartmentExist(d)) {
                d.moveEmployeeToDepartment(p);
            } else if (!doesDepartmentExist(d)) {
                System.out.println("Department doesn't exist in the company");
            } else {
                System.out.println("Person does not work for the company");
            }
        }
        else{
            System.out.println("Department not found");
        }

    }
    public boolean isPersonStaff(Person p){
        return this.employees.contains(p);
    }
    public boolean doesDepartmentExist(Department d){
        return this.departments.contains(d);
    }

    private ArrayList<Person> remaindingStaff(){
        ArrayList<Person> bench = new ArrayList<>();
        for(Person p : this.employees){
            boolean isNotBenched = false;
            for(Department d: this.departments){
                if(d.isInDepartment(p)){
                    isNotBenched = true;
                }
            }
            if(!isNotBenched){
                bench.add(p);
            }
        }
        return bench;
    }
    public void getBenchedEmployees(){
        ArrayList<Person> bench = remaindingStaff();
        if(bench.size() == 0){
            System.out.print("No staff are on the bench! This is great");
        }
        else{
            System.out.println("People on the bench: ");
            for(Person p : bench){
                System.out.println(p.getName());
            }
        }
    }
}
