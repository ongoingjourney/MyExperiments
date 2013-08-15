package com.sanjeeb.problemsolving.generics;

public class BTreeTree {
	BTreeNode<Integer> root;
	
	public void displayPreOrder()
	{
		displayPreOrder(root);
	}
	
	private void displayPreOrder(BTreeNode<Integer> node) {
		if(node.getLeft() == null)
		{
			if(node.getRight() == null) {
				System.out.print(node.getValue() + " ");
				return;
			}
		} else {
			displayPreOrder(node.getLeft());
		}

		System.out.print(node.getValue() + " ");
		
		if(node.getRight() == null) {
			if(node.getLeft() == null) {
				System.out.print(node.getValue() + " ");
				return;
			}
		} else 
			displayPreOrder(node.getRight());
	}
	
	public void displayBreadthFirst() {
		//check root.
		System.out.print(root.getValue() + " ");
		displayBreadthFirst(root);
	}
	
	private void displayBreadthFirst(BTreeNode<Integer> node) {
		if(node.getLeft() != null) {
			System.out.print(node.getLeft().getValue() + " ");
		}
		if(node.getRight() != null) {
			System.out.print(node.getRight().getValue() + " ");
		}
		
		if(node.getLeft() != null)
			displayBreadthFirst(node.getLeft());

		if(node.getRight() != null)
			displayBreadthFirst(node.getRight());
	}
	
	public void insert(Integer nodeVal) {
		if(root == null) {
			root = new BTreeNode<Integer>(nodeVal);
			return;
		} else 
			insert(nodeVal, root);
	}
	
	private void insert(Integer nodeVal, BTreeNode<Integer> node) {
		if(nodeVal < node.getValue()) {
			if(node.getLeft() == null)
			{
				node.setLeft(new BTreeNode<>(nodeVal));
			} else {
				insert(nodeVal, node.getLeft());
			}
		} else if(nodeVal > node.getValue())
		{
			if(node.getRight() == null)
			{
				node.setRight(new BTreeNode<>(nodeVal));
			} else {
				insert(nodeVal, node.getRight());
			}
		} else
		{
			System.out.println("Already exists");
		}
	}
}