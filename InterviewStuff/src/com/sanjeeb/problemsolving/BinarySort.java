package com.sanjeeb.problemsolving;

import java.util.Arrays;

public class BinarySort {
	public static void main(String[] args) {
//		int[] leftArr = null;
//		int[] rightArr = new int[]{1, 3, 5};
//		int[] resultantArr = mergeSortedArray(leftArr, rightArr);
//		displayArr(resultantArr);
		int[] arr = new int[]{23, 4, 546, 76, 87, 8, 2, 34, 6, 687, 32};
		displayArr(arr);
		int[] mergedArr = sortArray(arr);
		displayArr(mergedArr);
	}
	
	public static int[]sortArray(int[] arr) {
		if(arr == null || arr.length == 0) throw new IllegalArgumentException();
		if(arr.length < 2) return arr;
		int[] leftArr = sortArray(Arrays.copyOfRange(arr, 0, arr.length/2));
		int[] rightArr = sortArray(Arrays.copyOfRange(arr,arr.length/2, arr.length)); 
		int[] mergedArray = mergeSortedArray(leftArr, rightArr);
		return mergedArray;
	}
	
	
	private static int[] mergeSortedArray(int[] leftArr, int rightArr[]) {
		if(isArrEmpty(leftArr) && isArrEmpty(rightArr)) 
			throw new IllegalArgumentException();
		if(isArrEmpty(leftArr)) {
			return Arrays.copyOfRange(rightArr, 0, rightArr.length);
		} else if(isArrEmpty(rightArr)) {
			return Arrays.copyOfRange(leftArr, 0, leftArr.length);
		} else {
			int lengthOfNewArr = leftArr.length + rightArr.length;
			int[] resultantArr = new int[lengthOfNewArr];
			int pointerOnLeftArr=0, pointerOnRightArr=0;
			for(int i = 0; i < lengthOfNewArr; ++i) {
				//System.out.println("i/leftPointer/rightPointer : " + i + "/" + pointerOnLeftArr + "/" + pointerOnRightArr);
				if(pointerOnLeftArr == leftArr.length) {
					resultantArr[i] = rightArr[pointerOnRightArr++];
				} else if (pointerOnRightArr == rightArr.length) {
					resultantArr[i] = leftArr[pointerOnLeftArr++];
				} else {
					if(leftArr[pointerOnLeftArr] < rightArr[pointerOnRightArr]) {
						resultantArr[i] = leftArr[pointerOnLeftArr++];
					} else if(leftArr[pointerOnLeftArr] > rightArr[pointerOnRightArr]) {
						resultantArr[i] = rightArr[pointerOnRightArr++];
					} else {
						resultantArr[i] = leftArr[pointerOnLeftArr++];
						resultantArr[++i] = rightArr[pointerOnRightArr++];
					}
				}
			}
			return resultantArr;
		}
	}
	
	private static boolean isArrEmpty(int[] arr) {
		return (arr == null || arr.length == 0); 
	}
	private static void displayArr(int[] arr) {
		for(int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
}
