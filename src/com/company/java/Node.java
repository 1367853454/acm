package com.company.java;

public class Node {

    Node previous; //上一个节点
    Node next;  //下一个节点
    Object element;  //值

    public Node(Node previous, Node next, Object element) {

        super();
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        super();
        this.element = element;
    }
}
