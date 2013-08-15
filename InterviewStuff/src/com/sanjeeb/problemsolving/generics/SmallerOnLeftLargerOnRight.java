package com.sanjeeb.problemsolving.generics;

public class SmallerOnLeftLargerOnRight {
	public static void main(String[] args) {
		LinkedListList<Integer> list = new LinkedListList<>();
		
		list.insert(2);
		list.insert(1);
		list.insert(12);
		list.insert(67);
		list.insert(-1);
		list.insert(4);
		
		list.displayList();
		
		sortArr(list.getHead(), list.getHead(), findPivotNode(list, -1 ));
		
		list.displayList();
		
	}
	
	private static void sortArr(LinkedListNode<Integer> head, LinkedListNode<Integer> nodeBefore, LinkedListNode<Integer> pivotNode) {
		if (nodeBefore == null) {
			if(head.getData() > pivotNode.getData()) {
				appendRight(pivotNode, head);
			}
		}
		
		if(nodeBefore.getRight() == null) {
			if ( nodeBefore.getData() < pivotNode.getData()) {
				appendLeft(head, nodeBefore);
				return;
			}
		}
		
		sortArr(head, nodeBefore.getRight(), pivotNode);
	}
	
	private static void appendLeft(LinkedListNode<Integer> head, LinkedListNode<Integer> prevNode) {
		LinkedListNode<Integer> dataNode = prevNode.getRight();
		prevNode.setRight(prevNode.getRight().getRight());
		dataNode.setRight(head);
	}
	
	private static void appendRight(LinkedListNode<Integer> pivotNode, LinkedListNode<Integer> prevNode) {
		LinkedListNode<Integer> dataNode = prevNode.getRight();
		prevNode.setRight(dataNode.getRight());
		
		LinkedListNode<Integer> nodeNextToPivot = pivotNode.getRight();
		pivotNode.setRight(dataNode);
		dataNode.setRight(nodeNextToPivot);
	}
	private static LinkedListNode<Integer> findPivotNode(LinkedListList<Integer> list, Integer nodeVal) {
		LinkedListNode<Integer> pivotNode = list.getHead();
		System.out.println("\n");
		while(pivotNode != null && pivotNode.getData() != nodeVal) {
			pivotNode = pivotNode.getRight();
		}
		return pivotNode;
	}
	
}