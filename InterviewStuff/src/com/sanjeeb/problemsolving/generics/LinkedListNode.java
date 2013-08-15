package com.sanjeeb.problemsolving.generics;

public class LinkedListNode<T> {
	T data;
	LinkedListNode<T> left;
	LinkedListNode<T> right;
	
	public LinkedListNode(T aData){
		this.data = aData;
	}
	
	public LinkedListNode<T> getRight() {
		return this.right;
	}
	
	public void setRight(LinkedListNode<T> node) {
		this.right = node;
	}
	
	public LinkedListNode<T> getLeft() {
		return this.left;
	}
	
	
	public T getData() {
		return this.data;
	}
}