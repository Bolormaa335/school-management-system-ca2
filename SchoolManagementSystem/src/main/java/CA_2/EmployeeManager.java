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

    


    

