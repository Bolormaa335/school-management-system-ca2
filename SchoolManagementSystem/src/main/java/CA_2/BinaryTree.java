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
public class BinaryTree {
     // Node class
    static class Node {

        Employee employee;

        Node left;
        Node right;

        // Constructor
        Node(Employee employee) {

            this.employee = employee;

            left = null;
            right = null;
        }
    }

    // Root node
    Node root;

    // Constructor
    public BinaryTree() {

        root = null;
    }

    // Insert using level-order
    public void insert(Employee employee) {

        // Create new node
        Node newNode = new Node(employee);

        // If tree empty
        if (root == null) {

            root = newNode;
            return;
        }

        // Queue using ArrayList
        ArrayList<Node> queue = new ArrayList<Node>();

        // Add root
        queue.add(root);

        // Loop until inserted
        while (!queue.isEmpty()) {

            // Get first node
            Node current = queue.remove(0);

            // Insert left
            if (current.left == null) {

                current.left = newNode;
                return;

            } else {

                queue.add(current.left);
            }

            // Insert right
            if (current.right == null) {

                current.right = newNode;
                return;

            } else {

                queue.add(current.right);
            }
        }
    }
    // Display tree using level-order traversal
public void displayLevelOrder() {

    if (root == null) {
        System.out.println("Tree is empty.");
        return;
    }

    ArrayList<Node> queue = new ArrayList<Node>();
    queue.add(root);

    System.out.println("Employee hierarchy level-order:");

    while (!queue.isEmpty()) {

        Node current = queue.remove(0);

        System.out.println(current.employee);

        if (current.left != null) {
            queue.add(current.left);
        }

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

// Recursive visual hierarchy display with level number
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
// Count total nodes
public int countNodes(Node node) {

    if (node == null) {
        return 0;
    }

    return 1 + countNodes(node.left) + countNodes(node.right);
}

// Calculate tree height
public int height(Node node) {

    if (node == null) {
        return 0;
    }

    int leftHeight = height(node.left);
    int rightHeight = height(node.right);

    if (leftHeight > rightHeight) {
        return leftHeight + 1;
    } else {
        return rightHeight + 1;
    }
}

// Display tree statistics
public void displayTreeStatistics() {

    System.out.println("Total nodes: " + countNodes(root));
    System.out.println("Tree height: " + height(root));
}
    
}
