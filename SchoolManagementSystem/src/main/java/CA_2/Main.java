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
                        break;

                    case SEARCH:
                        System.out.println("SEARCH selected");
                        break;

                    case ADD_RECORD:
                        System.out.println("ADD RECORD selected");
                        break;

                    case CREATE_BINARY_TREE:
                        System.out.println("CREATE BINARY TREE selected");
                        break;

                    case DISPLAY_RECORDS:
                        System.out.println("DISPLAY RECORDS selected");

                        for (Employee employee : employees) {
                            System.out.println(employee);
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
        
    
    

