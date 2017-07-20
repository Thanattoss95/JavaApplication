package com.test;

import com.main.Company;
import com.main.Department;
import com.main.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCreatingCompany {
    private Company c;
    @Test
    public void testCreatingCompanyAndDepartments(){
        //Create company object
        c = new Company("Microsoft");
        //Create department objects
        c.createDepartment("Innovation","Software development");

        Department d = c.getDepartmentByName("Innovation");
        assertEquals(d.getName(),"Innovation");
    }

    @Test
    public void testAddingStaffToCompany(){
        c = new Company("Microsoft");
        Person p = new Person("Steve Rodgers", 96);
        c.employPerson(p);
        assertEquals(c.getEmployees().contains(p),true);
    }
    @Test
    public void testFiringStaffToCompany(){
        c = new Company("Microsoft");
        Person p = new Person("Steve Rodgers", 96);
        c.employPerson(p);
        c.fireEmployee(p);
        assertEquals(c.getEmployees().contains(p),false);
    }
}
