package com.san.java.generics.linkedListRevisited;

public class Node<T> {
    T value;
    Node<T> next;
    Node<T> previous;

    public Node(T nodeValue) {
        this.value = nodeValue;
    }
}
