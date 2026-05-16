/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author Acer
 */
// Employee class stores one school staff record
public class Employee {
    
    // Employee full name
    private String name;

    // Employee school role
    private String role;

    // Employee department
    private String department;

    // Constructor to create an employee object
    public Employee(String name, String role, String department) {
        this.name = name;
        this.role = role;
        this.department = department;
    }

    // Return employee name
    public String getName() {
        return name;
    }

    // Return employee role
    public String getRole() {
        return role;
    }

    // Return employee department
    public String getDepartment() {
        return department;
    }

    // Display employee information as text
    
    @Override
    public String toString() {
        return name + " | " + role + " | " + department;
    }
}
    
    

