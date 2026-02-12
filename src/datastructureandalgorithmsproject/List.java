/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructureandalgorithmsproject;

/**
 *
 * @author evrim
 */
public class List {

    Methods m1 = new Methods();

    Node head;

    Node parent;

    Node current;

    boolean pathValid;

    public List() {

        current = null;

        parent = null;

        head = null;

        pathValid = true;

    }

    private void goNextSibgling(int number) {

        if (this.current == null) {
            return;
        }

        for (int i = 0; i < number; i++) {

            if (this.current.getSibling() == null) {
                break;

            } else {
                this.current = this.current.getSibling();
            }

        }

    }

    private Node goNextChild(Node input) {

        if (input == null) {
            return null;
        }

        return input.getChild();
    }

    private int pathFinder(String path) {

        this.current = head;

        this.parent = head;

        int dotCounter = m1.dotCounter(path);

        int siblingCounter = 0;

        int counter = 0;

        pathValid = true;

        if (head == null) {
            return 0;
        }

        int num = 0;

        for (int i = 0; i < m1.getLength(path); i++) {

            if (path.charAt(i) == '.') {

                if (num > 0) {

                    if (current != null) {
                        while (current.getSibling() != null && siblingCounter < num - 1) {
                            current = current.getSibling();

                            siblingCounter++;
                        }
                    }

                    if (siblingCounter < num - 1 && m1.getLength(path) != 1) {
                        pathValid = false;
                        return num;
                    }

                    if (counter <= dotCounter - 1) {

                        parent = current;
                        current = goNextChild(current);

                    } else {
                        current = goNextChild(current);
                    }

                    num = 0;

                    siblingCounter = 0;

                    counter++;

                } else {
                    System.out.println("Error: Path is not appropriate");
                    break;
                }

            } else {

                num = (num * 10) + (path.charAt(i) - '0');
            }

        }
        return num;
    }

    private boolean isContainsSameText(String Heading) {

        Node temp = current;

        while (temp != null) {

            if (m1.isSameText(temp.getHeading(), Heading)) {
                return true;
            }

            temp = temp.getSibling();
        }

        return false;
    }

    public void add(String path, String heading) {

        Node newNode = new Node(heading);

        int num = pathFinder(path);

        int dotCount = m1.dotCounter(path);

        if (pathValid == false) {
            System.out.println("""
                               Error: The heading does not exist in the hierarchy, so the insertion cannot be performed""");
            return;
        }

        if (isContainsSameText(heading)) {
            System.out.println("Error: Heading Already exist");
            return;
        }
        if (head == null) {
            head = newNode;

            return;
        }

        if (dotCount == 0) {

            if (num == 1) {
                newNode.setSibling(head);
                head = newNode;
                return;
            }

            current = head;

            goNextSibgling(num - 2);

            newNode.setSibling(current.getSibling());

            current.setSibling(newNode);

            return;
        }

        if (num == 1) {

            if (parent.getChild() == null) {
                parent.setChild(newNode);
            } else {
                Node temp = parent.getChild();

                newNode.setSibling(temp);

                parent.setChild(newNode);
            }
        } else if (num == 2) {

            if (parent.getChild() != null) {
                newNode.setSibling(current.getSibling());

                current.setSibling(newNode);

            } else {
                parent.setChild(newNode);

                System.out.println("""
                                   Since there were no previously added headings at this level, it has
                                   been inserted in the first position""");
            }

        } else if (num > 2) {

            if (parent.getChild() != null) {

                int siblingCounter = 0;

                while (current.getSibling() != null && siblingCounter < num - 2) {
                    current = current.getSibling();
                    siblingCounter++;
                }

                if (siblingCounter < num - 2 && num != 1) {
                    System.out.println("""
                                       Since the requested number of headings does not
                                       exist at this level, it has been added to the last position""");
                }

            } else {
                parent.setChild(newNode);

                System.out.println("""
                                   Since there were no previously added headings at this level, it has
                                   been inserted in the first position""");

                return;
            }

            newNode.setSibling(current.getSibling());

            current.setSibling(newNode);

        }
        System.out.println();
        System.out.println("Heading Succesfully added");

    }

    public void print() {
        System.out.println("----- LIST -----");
        printRecursive(head, "", 0);
        System.out.println("---------------");
    }

    private void printRecursive(Node node, String parentPath, int level) {

        if (node == null) {
            return;
        }

        Node temp = node;

        int index = 1;

        while (temp != null) {

            String currentPath;

            if (m1.getLength(parentPath) == 0) {
                currentPath = Integer.toString(index);
            } else {
                currentPath = parentPath + "." + index;
            }

            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }

            System.out.println(currentPath + ". " + temp.getHeading());

            if (temp.getChild() != null) {
                printRecursive(temp.getChild(), currentPath, level + 1);
            }

            temp = temp.getSibling();
            index++;
        }
    }

}
