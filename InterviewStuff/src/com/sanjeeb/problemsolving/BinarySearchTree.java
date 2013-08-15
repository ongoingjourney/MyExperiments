package com.sanjeeb.problemsolving;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
	public static void main(String args[]) {
		int[] arr = new int[]{21, 10, 36, 8, 15, 7, 6, 5, 4, 99, 109};
//		int[] arr = new int[]{21, 10, 33};
//		int[] arr = new int[]{21, 36, 99}; 
		BST<Integer> bst = new BST<>();
		for(int i : arr) {
			bst.insert(i);
		}
//		List<String> pathList = bst.getAllPath(bst.root);
//		for(String str : pathList)
//			System.out.println(str);
//		bst.depthFirstTraversal("preorder");
//		bst.depthFirstTraversal("inorder");
//		bst.depthFirstTraversal("postorder");
		bst.breadthFirstTraversal();
	}
}

class BST<T extends Comparable<T>> {
	Item<T> root;
	
	public void breadthFirstTraversal() {
		if(root == null) throw new IllegalStateException();
		Queue<Item> queue = new LinkedList<>();
		queue.add(root);
		breadthFirstTraversal(queue);
	}
	
	private void breadthFirstTraversal(Queue<Item> queue) {
		Iterator<Item> ite = queue.iterator();
		Queue<Item> newQueue = new LinkedList<>();
		while(ite.hasNext()) {
			Item currentItem = ite.next();
			if (currentItem.getLeft() != null) 
				newQueue.add(currentItem.getLeft());
			if (currentItem.getRight() != null) 
				newQueue.add(currentItem.getRight());
			System.out.print(currentItem.getVal() + "\t");
		}
		System.out.println();
		if(newQueue.isEmpty()) {
			return;
		}
		breadthFirstTraversal(newQueue);
	}
 	
	public void depthFirstTraversal(String order) {
		if(root == null) throw new IllegalStateException();
		depthFirstTraversal(root, order);
		System.out.println();
	}
	
	private void depthFirstTraversal(Item<T> node, String order) {
		switch (order) {
			case "preorder" : {
				if(node.getLeft() != null) {
					depthFirstTraversal(node.getLeft(), order);
				}
				System.out.print(node.getVal() + "\t");
				if(node.getRight() != null) {
					depthFirstTraversal(node.getRight(), order);
				}
				break;
			}
			case "inorder"  : {
				System.out.print(node.getVal() + "\t");
				if(node.getLeft() != null) {
					depthFirstTraversal(node.getLeft(), order);
				}
				if(node.getRight() != null) {
					depthFirstTraversal(node.getRight(), order);
				}
				break;
			}
			case "postorder"  : {
				if(node.getRight() != null) {
					depthFirstTraversal(node.getRight(), order);
				}
				System.out.print(node.getVal() + "\t");
				if(node.getLeft() != null) {
					depthFirstTraversal(node.getLeft(), order);
				}
				break;
			}
			default : {
				throw new IllegalArgumentException("unsupported ordering");
			}
		}
	}
	
	public List<String> getAllPath(Item<T> parentItem) {
		if(parentItem == null) throw new IllegalArgumentException();
		List<String> pathList = new LinkedList<>();
		getAllPath(parentItem, "", pathList);
		return pathList;
	}
	
	private void getAllPath(Item<T> parentItem, String currentString, List<String> pathList) {
		currentString = currentString+parentItem.getVal().toString()+".";
		if(parentItem.getLeft() == null && parentItem.getRight() == null) {
			pathList.add(currentString);
			return;
		}
		if(parentItem.getLeft() != null) {
			getAllPath(parentItem.getLeft(), currentString, pathList);
		} 
		if(parentItem.getRight() != null) {
			getAllPath(parentItem.getRight(), currentString, pathList);
		}
	}
	
	public void insert(T itemVal) {
		Item<T> newItem = new Item<>(itemVal);
		if(root == null) {
			root = newItem;
			return;
		}
		insert(root, newItem);
	} 
	private void insert(Item<T> parentItem, Item<T> newItem) {
		if(parentItem.getVal().compareTo(newItem.getVal()) > 0) {
			if(parentItem.getLeft() == null) {
				parentItem.setLeft(newItem);
			} else {
				insert(parentItem.getLeft(), newItem);
			}
		}
		if(parentItem.getVal().compareTo(newItem.getVal()) < 0) {
			if(parentItem.getRight() == null) {
				parentItem.setRight(newItem);
			} else {
				insert(parentItem.getRight(), newItem);
			}
		}
	}
}

class Item<T> {
	Item<T> left;
	Item<T> right;
	T val;
	public Item(T val) {
		this.val = val;
	}
	public Item<T> getLeft() {
		return left;
	}
	public void setLeft(Item<T> left) {
		this.left = left;
	}
	public Item<T> getRight() {
		return right;
	}
	public void setRight(Item<T> right) {
		this.right = right;
	}
	public T getVal() {
		return val;
	}
	public void setVal(T val) {
		this.val = val;
	}
}
