/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructureandalgorithmsproject;

/**
 *
 * @author evrim
 */
public class Node {

    private String heading;
    private Node sibling;
    private Node child;

    public Node(String heading) {
        this.heading = heading;
        this.sibling = null;
        this.child = null;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Node getSibling() {
        return sibling;
    }

    public void setSibling(Node nextSibling) {
        this.sibling = nextSibling;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

}
