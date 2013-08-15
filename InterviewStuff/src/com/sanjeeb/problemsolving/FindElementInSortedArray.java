package com.sanjeeb.problemsolving;

import java.util.Arrays;

public class FindElementInSortedArray {
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,4,23,34,56,67,89,99,100,234};
		//int[] arr = new int[]{12,22,33,34};
		//int[] arr = new int[]{33,34};
		int numToFind = 100;
		FindElementInSortedArray tool = new FindElementInSortedArray();
		System.out.println(numToFind + " is at the position " + tool.find(arr, numToFind));
	}
	
	public int find(int[] arr, int num) {
		return find(arr, 0, num);
	}
	
	private int find(int[] arr, int leftIndex, int num){
		if(arr.length == 0) return -1;
		if(arr.length == 1) {
			if(arr[0] == num) {
				return leftIndex;
			} else {
				return -1;
			}
		}
		int[] leftArr = Arrays.copyOfRange(arr, 0, arr.length/2);
		int[] rightArr = Arrays.copyOfRange(arr, arr.length/2, arr.length);
		
		if(num <= leftArr[leftArr.length-1]){
			return find(leftArr, leftIndex, num);
		}
		if(num >= rightArr[0]) {
			return find(rightArr, leftIndex+leftArr.length, num);
		}
		return -1;
	}
}