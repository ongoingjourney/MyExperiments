package com.san.java.generics.linkedListRevisited;

public class LinkedList<T> {
    Node<T> listHeader;

    public void add(T nodeVal) {
        Node node = new Node(nodeVal);
        if (listHeader == null) {
            listHeader = node;
        } else {
            add(node);
        }
    }

    private void add(Node<T> node) {
        Node<T> runner = listHeader;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = node;
    }

    public void displayList() {
        Node<T> runner = listHeader;
        while (runner != null) {
            System.out.println(runner.value);
            runner = runner.next;
        }
    }
}
