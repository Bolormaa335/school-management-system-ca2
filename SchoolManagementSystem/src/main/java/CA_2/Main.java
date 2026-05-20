/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Main {
   
   
    // Read employee records from Applicants_Form.txt
    public static ArrayList<Employee> readEmployeesFromFile() {

        // Create empty employee list
        ArrayList<Employee> employees = new ArrayList<Employee>();

        try {
            // Open the file
            File file = new File("Applicants_Form.txt");

            // Scanner reads the file
            Scanner fileReader = new Scanner(file);

            // Read until file ends
            while (fileReader.hasNextLine()) {

                // Read one line
                String line = fileReader.nextLine();

                // Split line into 3 parts
                String[] parts = line.split(",");
                
                // Make sure the line has name, role, department
                if (parts.length == 3) {

                    // First part is name
                    String name = parts[0];

                    // Second part is role
                    String role = parts[1];

                    // Third part is department
                    String department = parts[2];

                    // Create employee object
                    Employee employee = new Employee(name, role, department);

                    // Add employee to list
                    employees.add(employee);
                }
            }

            // Close file scanner
            fileReader.close();

            // Success message
            System.out.println("File read successfully.");

        } catch (FileNotFoundException e) {

            // Error if file is missing
            System.out.println("File not found.");
        }

        // Return employee list
        return employees;
    }
    // Display console menu
    public static void displayMenu() {
        System.out.println("\n===== SCHOOL MANAGEMENT SYSTEM =====");
        System.out.println("1. SORT");
        System.out.println("2. SEARCH");
        System.out.println("3. ADD RECORD");
        System.out.println("4. CREATE BINARY TREE");
        System.out.println("5. DISPLAY RECORDS");
        System.out.println("6. EXIT");
        System.out.print("Choose option: ");
    }

    // Program starts here
    public static void main(String[] args) {

        // Scanner for keyboard input
        Scanner scanner = new Scanner(System.in);

        // Read employees from file
        ArrayList<Employee> employees = readEmployeesFromFile();
        
        ArrayList<Employee> newEmployees = new ArrayList<Employee>();

        // Store user menu choice
        int choice = 0;

        // Repeat menu until user chooses EXIT
        while (choice != 6) {

            // Show menu
            displayMenu();

            // Read number
            choice = scanner.nextInt();

            // Clear scanner line
            scanner.nextLine();

            // Check valid menu number
            if (choice >= 1 && choice <= 6) {

                // Convert number to enum
                MenuOption option = MenuOption.values()[choice - 1];

                // Use enum in switch
                switch (option) {

                    case SORT:
                        System.out.println("SORT selected");
                        // Sort employee list
                       EmployeeUtility.mergeSort(employees);

                    // Display first 20 sorted employees
                    for (Employee employee : employees) {
                     System.out.println(employee);
                              }
                        break;

                    case SEARCH:
                        
                        System.out.println("SEARCH selected");

                        // Sort list before binary search
                        EmployeeUtility.mergeSort(employees);

                        // Ask user for name
                         System.out.print("Enter employee name to search: ");
                         String searchName = scanner.nextLine().trim();

                         // Search employee by name
                         int index = EmployeeUtility.binarySearch(employees, searchName, 0, employees.size() - 1);

                         // Check result
                        if (index != -1) {
                         System.out.println("Employee found:");
                         System.out.println(employees.get(index));
                         } else {
                        System.out.println("Employee not found.");
}
                        break;

                        case ADD_RECORD:
                        // Print message
                       System.out.println("ADD RECORD selected");

                        // Ask for employee name
                       System.out.print("Enter employee name: ");
                       String newName = scanner.nextLine();

                      // Ask for role
                      System.out.println("Select role:");

                     for (int i = 0; i < EmployeeManager.validRoles.length; i++) {
                     System.out.println((i + 1) + ". " + EmployeeManager.validRoles[i]);
                         }

                      System.out.print("Choose role: ");
                       int roleChoice = scanner.nextInt();
                       scanner.nextLine();

                        String newRole = EmployeeManager.validRoles[roleChoice - 1];

                      // Ask for department
                      System.out.print("Enter department: ");
                      String newDepartment = scanner.nextLine();

                       // Call EmployeeManager class
                       Employee newEmployee = EmployeeManager.addEmployee(
                       employees,
                       newName,
                       newRole,
                       newDepartment
                          );

                      if (newEmployee != null) {
                      newEmployees.add(newEmployee);
                      }

                       break;

                    case CREATE_BINARY_TREE:

                  System.out.println("CREATE BINARY TREE selected");

                   // Read employees again from file to keep original hierarchy order
                   ArrayList<Employee> treeEmployees = readEmployeesFromFile();

                   // Add newly added employees at the end of the hierarchy
                   for (Employee employee : newEmployees) {
                    treeEmployees.add(employee);
                      }

                   // Create binary tree
                   BinaryTree tree = new BinaryTree();

                  // Insert employees using original file order
                    for (Employee employee : treeEmployees) {
                    tree.insert(employee);
                     }

                  // Display hierarchy
                  tree.displayHierarchy();
 
                    // Display tree statistics
                  tree.displayTreeStatistics();

                     break;

                     case DISPLAY_RECORDS:
                        System.out.println("DISPLAY RECORDS selected");

                         // Display all employees
                     for (Employee employee : employees) {

                     System.out.println(employee);
                      }

                      // Display newly added employees
                     System.out.println("\nNewly added records:");

                     // Check if empty
                     if (newEmployees.isEmpty()) {

                     System.out.println("No new records added yet.");

                    } else {

                     // Print new employees
                     for (Employee employee : newEmployees) {

                    System.out.println(employee);
                     }
                     }

                     break;
                    case EXIT:
                        System.out.println("Program ended.");
                        break;
                }

            } else {
                System.out.println("Invalid option.");
            }
        }

        // Close scanner
        scanner.close();
    }
}
        
    
    

