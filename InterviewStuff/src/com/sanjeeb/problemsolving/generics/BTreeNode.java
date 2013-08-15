package com.sanjeeb.problemsolving.generics;

public class BTreeNode<T>{
	BTreeNode<T> left;
	BTreeNode<T> right;
	T value;
	
	public BTreeNode(T val) {
		this.value = val;
	}
	
	public BTreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(BTreeNode<T> left) {
		this.left = left;
	}
	public BTreeNode<T> getRight() {
		return right;
	}
	public void setRight(BTreeNode<T> right) {
		this.right = right;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}