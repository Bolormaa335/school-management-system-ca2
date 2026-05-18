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
public static void mergeSort(ArrayList<Employee> employees) {

    // Base case
    if (employees.size() <= 1) {
        return;
    }

    // Find middle index
    int middle = employees.size() / 2;

    // Create left half
    ArrayList<Employee> left = new ArrayList<Employee>();

    // Create right half
    ArrayList<Employee> right = new ArrayList<Employee>();

    // Fill left array
    for (int i = 0; i < middle; i++) {
        left.add(employees.get(i));
    }

    // Fill right array
    for (int i = middle; i < employees.size(); i++) {
        right.add(employees.get(i));
    }

    // Recursive call for left half
    mergeSort(left);

    // Recursive call for right half
    mergeSort(right);

    // Merge sorted halves
    merge(employees, left, right);

}
// Merge two sorted lists
public static void merge(ArrayList<Employee> employees,
                         ArrayList<Employee> left,
                         ArrayList<Employee> right) {

    // Left index
    int i = 0;

    // Right index
    int j = 0;

    // Main array index
    int k = 0;

    // Compare left and right lists
    while (i < left.size() && j < right.size()) {

        // Compare employee names alphabetically
        if (left.get(i).getName()
                .compareToIgnoreCase(right.get(j).getName()) <= 0) {

            // Add left employee
            employees.set(k, left.get(i));

            i++;

        } else {

            // Add right employee
            employees.set(k, right.get(j));

            j++;
        }

        k++;
    }

    // Add remaining left employees
    while (i < left.size()) {

        employees.set(k, left.get(i));

        i++;
        k++;
    }

    // Add remaining right employees
    while (j < right.size()) {

        employees.set(k, right.get(j));

        j++;
        k++;
    }
}
// Recursive binary search method
public static int binarySearch(ArrayList<Employee> employees, String targetName, int left, int right) {

    // Base case: name not found
    if (left > right) {
        return -1;
    }

    // Find middle index
    int middle = (left + right) / 2;

    // Get middle employee name
    String middleName = employees.get(middle).getName();

    // Compare target name with middle name
    int comparison = targetName.compareToIgnoreCase(middleName);

    // If names match, return index
    if (comparison == 0) {
        return middle;
    }

    // If target name comes before middle name, search left side
    if (comparison < 0) {
        return binarySearch(employees, targetName, left, middle - 1);
    }

    // Otherwise search right side
    return binarySearch(employees, targetName, middle + 1, right);
}
    
}
