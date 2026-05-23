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
// BinaryTree class is used to create and manage and the employee hierarchy structure using a binary tree.
 //Each employee is stored inside a tree node.
public class BinaryTree {
     
    
    // Node class represents one tree node
    // Each node stores one employee object
    // and links to left and right child nodes
    static class Node {

         // Store employee object inside the node
        Employee employee;
        
       // Reference to left child node    
        Node left;
        // Reference to right child node
        Node right;

        // Constructor creates a node using employee data
        Node(Employee employee) {

            this.employee = employee;

            left = null;
            right = null;
        }
    }

    // Root node represents the top of the binary tree
    Node root;

    
    // Constructor creates an empty binary tree
    public BinaryTree() {

        root = null;
    }

    // Insert employee into tree using level-order insertion
    // This fills the tree from left to right level by level
    public void insert(Employee employee) {

        // Create new node
        Node newNode = new Node(employee);

        // If tree is empty,
        // new node becomes the root node
        if (root == null) {

            root = newNode;
            return;
        }

        // Queue used for level-order insertion
        ArrayList<Node> queue = new ArrayList<Node>();

        // Add root node into queue
        queue.add(root);

        // Continue searching until node is inserted
        while (!queue.isEmpty()) {

            // Remove first node from queue
            Node current = queue.remove(0);

             // Insert new node as left child if empty
            if (current.left == null) {

                current.left = newNode;
                return;

            } else {
               // Add left child into queue
                queue.add(current.left);
            }

            // Insert new node as right child if empty
            if (current.right == null) {

                current.right = newNode;
                return;

            } else {
              // Add right child into queue
                queue.add(current.right);
            }
        }
    }
     // Display tree using level-order traversal
    // Employees are displayed level by level
public void displayLevelOrder() {
    
     // Check if tree is empty
    if (root == null) {
        System.out.println("Tree is empty.");
        return;
    }
    
       // Queue used for traversal  
    ArrayList<Node> queue = new ArrayList<Node>();
    
    // Add root node into queue
    queue.add(root);

    System.out.println("Employee hierarchy level-order:");

    // Continue until all nodes are displayed
    while (!queue.isEmpty()) {
        
        
        // Remove first node from queue
        Node current = queue.remove(0);

        // Display current employee
        System.out.println(current.employee);

          // Add left child into queue
        if (current.left != null) {
            queue.add(current.left);
        }
        
        // Add right child into queue
        if (current.right != null) {
            queue.add(current.right);
        }
    }
}

// Display hierarchy with levels
public void displayHierarchy() {

    // Empty tree check
    if (root == null) {

        System.out.println("Tree is empty.");
        return;
    }

    // Display tree starting from root at level 1  
    displayTree(root, "", true, 1);
}

// Recursive method displays hierarchy structure visually
 // including level numbers and branch symbolsr
private void displayTree(Node node,
                         String indent,
                         boolean last,
                         int level) {

    // Stop if node is empty
    if (node == null) {

        return;
    }

    // Print current employee with level number
    System.out.println(
            indent
            + (last ? "\\-- " : "|-- ")
            + "Level " + level + ": "
            + node.employee
    );

    // Update indentation for next level
    indent += last ? "    " : "|   ";

    // Display left child
    displayTree(node.left, indent, false, level + 1);

    // Display right child
    displayTree(node.right, indent, true, level + 1);
}
 // Count total number of nodes inside the tree
public int countNodes(Node node) {

    // Base case: empty node
    if (node == null) {
        return 0;
    }
    
// Count current node and child nodes recursively
    return 1 + countNodes(node.left) + countNodes(node.right);
}

// Calculate tree height
public int height(Node node) {

    if (node == null) {
        return 0;
    }
    // Calculate height of left subtree
    int leftHeight = height(node.left);
    // Calculate height of right subtree
    int rightHeight = height(node.right);

    if (leftHeight > rightHeight) {
        return leftHeight + 1;
    } else {
        return rightHeight + 1;
    }
}

// Display binary tree statistics
// including total nodes and tree height
public void displayTreeStatistics() {

    System.out.println("Total nodes: " + countNodes(root));
    System.out.println("Tree height: " + height(root));
}
    
}
