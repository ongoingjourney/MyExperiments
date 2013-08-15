package com.sanjeeb.problemsolving.generics;

public class DetectLoopInLinkedList {
	public static void main(String[] args) {
		LinkedListList<Integer> list = new LinkedListList<>();
		
		int intMakingLoop = 12;
		int pivotInt = 1;
		list.insert(2);
		list.insert(1);
		list.insert(12);
		list.insert(67);
		list.insert(-1);
		list.insert(4);
		
		//list.displayList();
		
		LinkedListNode<Integer> nodeMakingLoop = list.getFirstMatch(intMakingLoop);
		LinkedListNode<Integer> pivotNode = list.getFirstMatch(pivotInt);
		nodeMakingLoop.setRight(pivotNode);
		
		LinkedListNode<Integer> tortoise = list.getHead();
		LinkedListNode<Integer> bunny = list.getHead();
		do {
			bunny = bunny.getRight().getRight();
			tortoise = tortoise.getRight();
		}while (!bunny.equals(tortoise));
		System.out.println("Pivot node is " + bunny.getData());
		
	}
}
