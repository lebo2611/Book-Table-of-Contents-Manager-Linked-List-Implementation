# Book Table of Contents Manager (Linked List Implementation)

A Java console application that models a book's table of contents as a hierarchy of headings and sub-headings (for example `2.2.1`). The hierarchy is built on a custom linked structure written from scratch: the program does not use `java.util` collections, and even helpers such as string length and string comparison are implemented by hand.

## How it works

Each heading is a `Node` with three fields:

- `heading`: the heading text
- `child`: a reference to its first sub-heading
- `sibling`: a reference to the next heading on the same level

Every level of the table of contents is therefore a singly linked list of siblings, and the `child` references link the levels into a tree (a first-child / next-sibling tree). Positions such as `2.2.1` are parsed digit by digit to walk down the tree, and the structure is printed with a recursive traversal.

| File | Role |
|------|------|
| `Node.java` | A heading with its `child` and `sibling` references |
| `List.java` | Path navigation, insertion rules and recursive printing |
| `Methods.java` | Hand-written string helpers: command parsing, length, comparison, dot counting |
| `DataStructureAndAlgorithmsProject.java` | Entry point: loads a sample table of contents and runs the command loop |

## Commands

When the program starts, it loads and prints a sample table of contents (a data structures course outline in Turkish). You can then type:

| Command | Effect |
|---------|--------|
| `Add, <position>, <heading>` | Inserts a heading at the given position, e.g. `Add, 2.2.4, Merge Sort` |
| `print` | Prints the whole table of contents |
| `Exit` | Ends the program |

Separate the parts of an `Add` command with a comma followed by a space.

### Insertion rules

- **Duplicate check:** a heading with the same name cannot be added twice to the same level.
- **Empty level:** if the target level has no headings yet, the new heading becomes the first one, whatever index was requested.
- **Index out of range:** if the requested index is larger than the level's size, the heading is added to the end of the level.
- **Missing parent:** if the parent position does not exist (for example adding `5.1` when there is no heading `5`), the insertion is rejected with an error.
- **Shifting:** inserting at an occupied position moves the existing heading and the ones after it down by one.

## Example

```text
Enter Command:
Add, 3.1, Linear Search
Heading Succesfully added

Enter Command:
Add, 2.2.4, Merge Sort
Heading Succesfully added

Enter Command:
Add, 5.1, Heap
Error: The heading does not exist in the hierarchy, so the insertion cannot be performed

Enter Command:
Add, 3.1, Linear Search
Error: Heading Already exist

Enter Command:
print
----- LIST -----
...
2. Sıralama
    2.1. Siralama Nedir
    2.2. Siralama Algoritmalari
        2.2.1. Araya Sokma Siralamasi
        2.2.2. Secmeli Sıralama
        2.2.3. Kabarcik Siralama
        2.2.4. Merge Sort
3. Arama
    3.1. Linear Search
4. Agaclar
    4.1. Agac Nedir
---------------
```

(The listing is shortened; `2.2.1` has sub-headings of its own in the sample data.)

## How to run

Requires JDK 15 or later (the code uses text blocks). Tested with JDK 21.

```bash
git clone https://github.com/lebo2611/Book-Table-of-Contents-Manager-Linked-List-Implementation.git
cd Book-Table-of-Contents-Manager-Linked-List-Implementation
javac -d out src/datastructureandalgorithmsproject/*.java
java -cp out datastructureandalgorithmsproject.DataStructureAndAlgorithmsProject
```

You can also open the folder as a NetBeans project (it includes the Ant `build.xml`).
