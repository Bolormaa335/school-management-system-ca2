/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.io.FileWriter;
import java.io.IOException;
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
   // Validate role
    public static boolean isValidRole(String role) {

        // Loop through valid roles
        for (String validRole : validRoles) {

            // Compare roles
            if (validRole.equalsIgnoreCase(role)) {

                return true;
            }
        }

        // Invalid role
        return false;
    }

    // Validate department
    public static boolean isValidDepartment(String department) {

        // Loop through valid departments
        for (String validDepartment : validDepartments) {

            // Compare departments
            if (validDepartment.equalsIgnoreCase(department)) {

                return true;
            }
        }

        // Invalid department
        return false;
    }

    // Validate employee name
    public static boolean isValidName(String name) {

        // Empty name check
        if (name.trim().isEmpty()) {

            return false;
        }

        // Check every character
        for (int i = 0; i < name.length(); i++) {

            // Get character
            char ch = name.charAt(i);

            // Check letters and spaces only
            if (!Character.isLetter(ch)
                    && ch != ' ') {

                return false;
            }
        }

        // Valid name
        return true;
    }

    // Add employee
    public static Employee addEmployee(
            ArrayList<Employee> employees,
            String name,
            String role,
            String department) {

        // Validate all inputs
        if (isValidName(name)
                && isValidRole(role)
                && isValidDepartment(department)) {

            // Create employee object
            Employee employee = new Employee(
                    name,
                    role,
                    department
            );

            // Add employee to list
            employees.add(employee);
            // Save employee to file
             saveEmployeeToFile(employee);

            // Success message
            System.out.println(
                    name + " added successfully."
            );

            return employee;

        } else {

            // Invalid input message
            System.out.println(
                    "Invalid name, role or department."
            );

            return null;
        }
    }
    // Save new employee to text file
// Save new employee to text file
public static void saveEmployeeToFile(Employee employee) {

    try {

        // Open file in append mode
        FileWriter writer = new FileWriter(
                "Applicants_Form.txt",
                true
        );

        // Write employee data
        writer.write(
                System.lineSeparator()
                + employee.getName() + ","
                + employee.getRole() + ","
                + employee.getDepartment()
        );

        // Close writer
        writer.close();

        // Success message
        System.out.println(
                "Employee saved to file."
        );

    } catch (IOException e) {

        // Error message
        System.out.println(
                "Error saving employee to file."
        );
    }
}
}


    

