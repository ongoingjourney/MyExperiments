package com.sanjeeb.problemsolving.concepts;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Temp {
	public static void main(String[] args) {
		testOrderingOfRemoveInQueue();
	}
	@SuppressWarnings("adf")
	private static void testOrderingOfRemoveInQueue() {
		Queue<String> queue = new LinkedList<>();
		queue.add("A");
		queue.add("B");
		queue.add("C");
		queue.add("D");
		System.out.println(queue.remove());
		queue.add("E");
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.isEmpty());
		
		
		
	}
}