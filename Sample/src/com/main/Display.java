
package com.main;

import java.util.ArrayList;

public class Display {

    public static void main(String[] args){
       //Create company object
       Company c = new Company("Microsoft");

       //Create people objects
       Person john = new Person("John Smith",25);
       Person sarah = new Person("Sarah Jones", 37);
       Person zarha = new Person("Zarha James", 21);

       //Add skills to employees
       john.addSkills(skills.GITHUB);
       john.addSkills(skills.JAVASCRIPT);
       john.addSkills(skills.JAVA);

       sarah.addSkills(skills.HTML);
       sarah.addSkills(skills.CSS);
       sarah.addSkills(skills.SCALA);

       //Employ our people objects
       c.employPerson(john);
       c.employPerson(sarah);
       c.employPerson(zarha);

       //Check the staff in our company so far
       c.printAllEmployees();
       System.out.println();
       //Add new departments in the company object
       c.createDepartment("Innovation","Software development");
       c.createDepartment("Digital iForms","Networking");

       //Move out employees to the correct department (apart from Zarha
       // --> we could pass the department object directly since we have access it to it, however it is catered by searching for the department
       c.moveEmployeeToDepartment(john,c.getDepartmentByName("Innovation"));
       c.moveEmployeeToDepartment(sarah,c.getDepartmentByName("Digital iForms"));
       c.moveEmployeeToDepartment(zarha,c.getDepartmentByName("Digital iForms"));
       //Create new roles for the departments
       Department d = c.getDepartmentByName("Innovation");

       d.createRole("Designer",GenerateSkills());
       d.createRole("Developer",GenerateSkills());
       d.createRole("Tester",GenerateSkills());

       //Set staff to a role
       d.assignRole(john,"Developer");

       d = c.getDepartmentByName("Digital iForms");
       d.createRole("Designer", GenerateSkills());
       d.createRole("Developer", GenerateSkills());
       d.createRole("Tester", GenerateSkills());
       d.createRole("Product owner", GenerateSkills());

       d.assignRole(sarah,"Product owner");
       d.assignRole(zarha,"Designer");
       //Lets see who belongs in which department
       c.getAllDepartments();
       System.out.println();
       //Lets check if any members are on the bench
       c.getBenchedEmployees();
       System.out.println();
    }

    public static ArrayList<skills> GenerateSkills(){
        ArrayList<skills> s = new ArrayList<>();
        s.add(skills.CSS);
        s.add(skills.HTML);
        s.add(skills.JAVA);
        return s;
    }
}