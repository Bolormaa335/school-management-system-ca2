/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.util.ArrayList;

/**
 *
 * @author Acer
 */


public class EmployeeManager {
    public static String[] validRoles ={
        "Principal",
        "Assistant Principal",
        "Head Teacher",
        "Teacher",
        "Teaching Assistant",
        "Coordinator",
        "Manager",
        "Officer",
        "Assistant"
    };
    // Valid school departments
    public static String[] validDepartments = {
        "IT Department",
        "HR Office",
        "Finance Office",
        "Admissions Office",
        "Marketing Office",
        "Student Services",
        "Operations Office",
        "Accounts Office",
        "IT Support"
    };
    // Check valid role
    public static boolean isValidRole(String role) {

        for (String validRole : validRoles) {

            if (validRole.equalsIgnoreCase(role)) {
                return true;
            }
        }

        return false;
    }

    // Check valid department
    public static boolean isValidDepartment(String department) {

        for (String validDepartment : validDepartments) {

            if (validDepartment.equalsIgnoreCase(department)) {
                return true;
            }
        }

        return false;
    }
    // Add employee
    public static Employee addEmployee(
            ArrayList<Employee> employees,
            String name,
            String role,
            String department) {

        // Validate inputs
        if (isValidRole(role) && isValidDepartment(department)) {
            
            

            // Create employee object
            Employee employee =
                    new Employee(name, role, department);

            // Add employee to list
            employees.add(employee);

            System.out.println(
                    name + " added successfully.");
            return employee;

        } else {

            System.out.println(
                    "Invalid role or department.");
            return null;
        }
    }
    // Validate employee name
public static boolean isValidName(String name) {

    if (name.trim().isEmpty()) {
        return false;
    }

    for (int i = 0; i < name.length(); i++) {

        char ch = name.charAt(i);

        if (!Character.isLetter(ch) && ch != ' ') {
            return false;
        }
    }

    return true;
}
}

    


    

