Book Table of Contents Manager (Linked List Implementation)

This project implements a hierarchical "Table of Contents" management system using Java. It stores headings and sub-headings using a custom Linked List data structure, without relying on pre-made collection classes (like java.util.LinkedList).
Project Overview

The main goal of this project is to model the hierarchical structure of a book using dynamic memory allocation. Each node in the structure represents a heading and contains:

   The heading text.

   A pointer to its parent heading.

   A linked list containing its sub-headings (children).

Features

The program accepts commands from the console to build and display the tree structure.
1. Adding a Heading (Add)

You can insert a new heading at a specific hierarchical position. Format: Add, [Position], [Heading Name]

  Logic: The program parses the position string (e.g., 2.2.1) and navigates the tree to insert the node.

  Rules & Constraints:

  Duplicate Check: If a heading with the same name exists at the target level, the insertion is blocked.

  Empty Level: If the target list is empty, the node is inserted at the 1st position regardless of the requested index.

  Index Out of Bounds: If the requested position is larger than the list size (e.g., requesting index 7 in a list of 3 items), the node is added to the end of the list.

  Missing Parent: If the parent path (e.g., 2.1) does not exist, the program cannot add a child (e.g., 2.1.1) and returns an error.

2. Printing the Structure (print)

Displays the entire Table of Contents in a readable, indented format showing the hierarchy (e.g., 1.2.1. Heading Name).
Usage Examples

Input:
Plaintext

Add, 1, Data Structures
Add, 1.1, What is Data Structure
Add, 2, Sorting
Add, 2.1, Bubble Sort
Add, 2.2, Quick Sort
print

Expected Output:
Plaintext

1. Data Structures
1.1. What is Data Structure
2. Sorting
2.1. Bubble Sort
2.2. Quick Sort

Technical Details

   Language: Java

   Data Structure: Doubly or Singly Linked List (Custom Implementation).

   Recursive Logic: Used to navigate through the depth of the headings.

How to Run

  1-)  Clone the repository
  2-)  Compile the Java files
  3-)  javac Main.java
  4-)  Run the application
  5-)  java Main
