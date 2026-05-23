/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author Acer
 */
// Employee class stores one employee record
// Each employee object contains employee name,
// school role and department information

public class Employee {
    
    //  Stores Employee full name
    private String name;

    // Stores Employee school role
    private String role;

    //  Stores Employee department
    private String department;

    // Constructor used to create a new employee object
    // The constructor receives employee name,
    // role and department as parameters
    public Employee(String name, String role, String department) {
          
        
       // Assign parameter values to object variables
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
    
    

