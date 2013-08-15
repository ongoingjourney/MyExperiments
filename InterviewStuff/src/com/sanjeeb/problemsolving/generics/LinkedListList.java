package com.sanjeeb.problemsolving.generics;

public class LinkedListList<T> {
	LinkedListNode<T> head;
	
	public LinkedListNode<T> getHead() {
		return this.head;
	}
	public void insert(T data) {
		LinkedListNode<T> newNode = new LinkedListNode(data);
		if(head == null) {
			head = newNode;
		}else{
			LinkedListNode<T> node = head;
			while(node.right != null) {
				node = node.right;
			}
			node.right = newNode;
			newNode.left = node;
		}
	}
	public void displayList(){
		//check if head is null
		LinkedListNode<T> node = head;
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}
	
	public LinkedListNode<T> getFirstMatch(T data) {
		if(head == null) {
			return null;
		}
		LinkedListNode<T> runner = head;
		while(runner != null && !runner.getData().equals(data))
			runner = runner.getRight();
		return runner;
	}
}