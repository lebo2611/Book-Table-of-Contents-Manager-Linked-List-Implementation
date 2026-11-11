# Book Table of Contents Manager (Linked List Implementation)

A Java console application that manages a book's table of contents as a hierarchy of headings and sub-headings. The hierarchy is stored in a custom linked structure written from scratch, without Java's built-in collection classes (such as `java.util.LinkedList`).

## How it works

The table of contents is a tree stored as linked lists (a "first child / next sibling" representation). Each `Node` holds:

- the heading text,
- a reference to its **next sibling** (the next heading on the same level),
- a reference to its **first child** (the first sub-heading below it).

So every level of the hierarchy is a singly linked list of siblings, and each heading can start a new list for its sub-headings. Navigating to a position such as `2.2.1` and printing the whole structure are done recursively.

## Commands

The program starts with a sample table of contents already loaded (in Turkish) and prints it. After that it reads commands from the console:

| Command | Format | What it does |
|---|---|---|
| Add | `Add, <position>, <heading>` | Inserts a heading at a position such as `2.2.1` |
| Print | `Print` or `print` | Prints the whole table of contents, indented by level |
| Exit | `Exit` | Ends the program |

### Rules for `Add`

- **Duplicate check:** if a heading with the same name already exists at the target level, the insertion is rejected.
- **Empty level:** if the target level has no headings yet, the new heading becomes the first one, whatever index was requested.
- **Index out of range:** if the requested index is larger than the number of headings at that level (for example index 7 in a list of 3), the heading is added at the end.
- **Missing parent:** if the parent position (for example `2.1`) does not exist, a child such as `2.1.1` cannot be added and an error is shown.

## Example

Input:

```text
Add, 5, Graphs
Add, 5.1, What is a Graph
print
Exit
```

End of the list printed by `print`:

```text
4. Agaclar
    4.1. Agac Nedir
5. Graphs
    5.1. What is a Graph
---------------
```

## How to run

Requires a JDK (Java 15 or newer, because the code uses text blocks).

```bash
git clone https://github.com/lebo2611/Book-Table-of-Contents-Manager-Linked-List-Implementation.git
cd Book-Table-of-Contents-Manager-Linked-List-Implementation
javac -d out src/datastructureandalgorithmsproject/*.java
java -cp out datastructureandalgorithmsproject.DataStructureAndAlgorithmsProject
```

It is also a NetBeans project (`nbproject/`, `build.xml`), so you can open the folder in NetBeans and run it from there.

## Project structure

```text
src/datastructureandalgorithmsproject/
├── DataStructureAndAlgorithmsProject.java   # entry point and command loop
├── List.java                                # the hierarchy: add, search and recursive print
├── Node.java                                # heading, next sibling, first child
└── Methods.java                             # command parsing helpers
```
