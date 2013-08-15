package com.sanjeeb.problemsolving;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
//		int[] arrA = new int[]{1, 3, 7, 12, 40};
//		int[] arrB = new int[]{23, 34, 35, 36, 39};
//		int[] mergedArr = new int[arrA.length + arrB.length];
//		mergeSortedArray(arrA, arrB, mergedArr);
//		displayArray("arrA", arrA);
//		displayArray("arrB", arrB);
//		displayArray("mergedArr", mergedArr);
		int[] intArr = new int[]{3, 43, 1, 45, 6, 78, 100, 2, 0, 23};
		
//		int[] intArr = new int[] {7, 3, 5, 1};
		displayArray("Before merging", intArr);
		int[] mergedArray = applyMergeSort(intArr);
		displayArray("After  merging", mergedArray);
	}
	
	public static int[] applyMergeSort(int[] intArr) {
		//check input.
		if(intArr.length < 2) return intArr;
		int[] arrASorted = applyMergeSort(Arrays.copyOfRange(intArr, 0, intArr.length/2));
		int[] arrBSorted = applyMergeSort(Arrays.copyOfRange(intArr, intArr.length/2, intArr.length));
		int[] mergedArray = new int[intArr.length];
		mergeSortedArray(arrASorted, arrBSorted, mergedArray);
		return mergedArray;
	}
	
	private static void displayArray(String arrayName, int[] arr) {
		System.out.print(arrayName + " ");
		for(int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	private static void mergeSortedArray(int[] arrA, int[] arrB, int[] mergedAray ) {
		int lengthOfMergedArray = arrA.length + arrB.length;
		int pointerA = 0;
		int pointerB = 0;
		for(int i = 0; i < lengthOfMergedArray; ++i) { 
			if(pointerA == arrA.length && pointerB < arrB.length) {
				do {
					mergedAray[i++] = arrB[pointerB++];
				} while(pointerB<arrB.length);
				return;
			}
			if(pointerB == arrB.length && pointerA < arrA.length) {
				do {
					mergedAray[i++] = arrA[pointerA++];
				} while(pointerA<arrA.length);
				return;
			}
			if(arrA[pointerA] <= arrB[pointerB]) {
				mergedAray[i] = arrA[pointerA++];
			} else {
				mergedAray[i] = arrB[pointerB++];
			}
		}
	}
}