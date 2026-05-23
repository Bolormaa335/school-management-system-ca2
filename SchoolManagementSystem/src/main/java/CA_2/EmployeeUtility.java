package CA_2;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */


public class EmployeeUtility {
    
    // Recursive merge sort method
    // This method sorts employee records alphabetically by name
     public static void mergeSort(ArrayList<Employee> employees) {

    
     // If the list has 0 or 1 employee, it is already sorted
    if (employees.size() <= 1) {
        return;
    }

    // Find middle point of the employee list
    int middle = employees.size() / 2;

    // Create a list to store the left half of employees
    ArrayList<Employee> left = new ArrayList<Employee>();

    // Create a list to store the right half of employees
    ArrayList<Employee> right = new ArrayList<Employee>();

    // Copy employees from the start of the list to the middle
    // into the left list
    for (int i = 0; i < middle; i++) {
        left.add(employees.get(i));
    }

    // Copy employees from the start of the list to the middle
     // into the left list
    for (int i = middle; i < employees.size(); i++) {
        right.add(employees.get(i));
    }

    // Recursive call for left half
    mergeSort(left);

    // Recursive call for right half
    mergeSort(right);

   // Merge the two sorted halves back into the original list
    merge(employees, left, right);

}

       // Merge method combines two sorted lists into one sorted list
    // Employees are compared by their names alphabetically
public static void merge(ArrayList<Employee> employees,
                         ArrayList<Employee> left,
                         ArrayList<Employee> right) {

    // Left index
    int i = 0;

    // Right index
    int j = 0;

    // Main array index
    int k = 0;

      // Compare employees from both left and right lists
      // until one of the lists becomes empty
    while (i < left.size() && j < right.size()) {

       // Compare employee names without case sensitivity
        if (left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) <= 0) {

               // Place the employee from the left list into the main list
            employees.set(k, left.get(i));
          // Move to the next employee in the left list
            i++;

        } else {

            // Place the employee from the right list into the main list
            employees.set(k, right.get(j));
            
            // Move to the next employee in the right list
            j++;
        }
        // Move to the next position in the main list
        k++;
    }

     // Add any remaining employees from the left list
    while (i < left.size()) {

        employees.set(k, left.get(i));

        i++;
        k++;
    }

    // Add any remaining employees from the right list
    while (j < right.size()) {

        employees.set(k, right.get(j));

        j++;
        k++;
    }
}
    // Recursive Binary Search method
    // This method searches for an employee by name
    // The employee list must be sorted before using binary search
public static int binarySearch(ArrayList<Employee> employees, String targetName, int left, int right) {

        // Base case:
        // If left index becomes greater than right index,
        // the employee name was not found
    if (left > right) {
        return -1;
    }

   // Find the middle index of the current search range
    int middle = (left + right) / 2;

    // Get the employee name stored at the middle index
    String middleName = employees.get(middle).getName();

     // Compare the search name with the middle employee name
     // ignoring uppercase and lowercase differences
    int comparison = targetName.compareToIgnoreCase(middleName);

      // If both names match, return the index of the employee

    if (comparison == 0) {
        return middle;
    }

     // If the target name comes before the middle name alphabetically,
     // search the left half of the list
    if (comparison < 0) {
        return binarySearch(employees, targetName, left, middle - 1);
    }

     // If the target name comes after the middle name alphabetically,
      // search the right half of the list
    return binarySearch(employees, targetName, middle + 1, right);
}
    
}
