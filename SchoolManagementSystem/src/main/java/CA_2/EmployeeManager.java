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

//EmployeeManager class manages employee input, validation and saving new employee records to file.
public class EmployeeManager {
    
     // List of valid school roles
    // The user can only select one of these roles
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
    
    // List of valid school departments
    // These departments are used to check user input
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
    
    // Validate school role entered or selected by the user
    public static boolean isValidRole(String role) {

        // Loop through valid roles
        for (String validRole : validRoles) {

            // Compare user role with valid role
            // equalsIgnoreCase ignores uppercase/lowercase differences
            if (validRole.equalsIgnoreCase(role)) {

                return true;
            }
        }

        //Return false if role is not found
        return false;
    }

    // Validate department entered by the user
    public static boolean isValidDepartment(String department) {

        // Loop through valid departments
        for (String validDepartment : validDepartments) {

            // Compare user department with valid department
            if (validDepartment.equalsIgnoreCase(department)) {

                return true;
            }
        }

        // Invalid department
        return false;
    }

    // Validate employee name
    // Name must not be empty and must contain letters and spaces only
    public static boolean isValidName(String name) {

        // Check if name is empty after removing spaces
        if (name.trim().isEmpty()) {

            return false;
        }

        // Check every character in thee name
        for (int i = 0; i < name.length(); i++) {

            // Store current character
            char ch = name.charAt(i);

            // Reject name if character is not a letter or space
            if (!Character.isLetter(ch)
                    && ch != ' ') {

                return false;
            }
        }

        // name is valid 
        return true;
    }

    // Add a new employee record
    // This method validates data, creates Employee object,
    // stores it in the ArrayList and saves it to text file
    public static Employee addEmployee(
            ArrayList<Employee> employees,
            String name,
            String role,
            String department) {

        // Validate all inputs
        if (isValidName(name)&& isValidRole(role)&& isValidDepartment(department)) {

             // Create new Employee object using valid input
            Employee employee = new Employee(
                    name,
                    role,
                    department
            );

            // Add employee to list
            employees.add(employee);
            // Save employee record to text file
             saveEmployeeToFile(employee);

            // Success message
            System.out.println( name + " added successfully." );
 
            // Return created employee object
            return employee;

        } else {

            // Invalid input message
            System.out.println( "Invalid name, role or department." );

            return null;
        }
    }
    
    // Save new employee record to Applicants_Form.txt
    // FileWriter is opened in append mode, so new records
    // are added to the end of the file
 
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

        // Confirm that employee was saved to file
        System.out.println( "Employee saved to file.");

    } catch (IOException e) {

        // Error message
        System.out.println( "Error saving employee to file." );
    }
}
}


    

