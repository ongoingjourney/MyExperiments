package com.sanjeeb.problemsolving.generics;

public class Driver {
	public static void main(String[] args) {
		driverForBTree();
		//driverForLinkedList();
	}
	
	static void driverForBTree(){
		BTreeTree tree = new BTreeTree();
		int[] arr = new int[] {40, 12, 60, 13, 7, 64, 48, 46, 55, 45, 44, 43, 54, 53};
        for(int i : arr) {
            tree.insert(i);
        }
//		tree.insert(46);
//		tree.insert(23);
//		tree.insert(96);
//		tree.insert(13);
//		tree.insert(27);
//		tree.insert(7);
//		tree.insert(9);
//		tree.insert(2);
//		tree.insert(1);
		
//		System.out.print("Depth first - ");
//		tree.displayPreOrder();
//		System.out.println();
		System.out.print("Breadth first - ");
		tree.displayBreadthFirst();
		System.out.println();
	}
	
	static void driverForLinkedList(){
		LinkedListList<Integer> list = new LinkedListList<>();
		list.insert(2);
		list.insert(5);
		list.insert(44);
		list.insert(3);
		list.insert(2333);
		list.displayList();
	}
}