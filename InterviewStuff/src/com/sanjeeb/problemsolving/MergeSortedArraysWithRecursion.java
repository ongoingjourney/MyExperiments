package com.sanjeeb.problemsolving;

public class MergeSortedArraysWithRecursion {

	public static void main(String[] args) {
		int[] arrI = new int[]{1, 2, 13, 24, 35, 39, 40, 41, 42, 43, 44, 45};
		int[] arrJ = new int[]{0, 7, 20, 21, 32, 39};
		MergeSortedArraysWithRecursion merge = new MergeSortedArraysWithRecursion();
		int[] resultantArr = merge.mergeArray(arrI, arrJ);
		for(int num : arrI) {
			System.out.print(num + " ");
		}
		System.out.println();
		for(int num : arrJ) {
			System.out.print(num + " ");
		}
		System.out.println();
		for(int num : resultantArr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public int[] mergeArray(int[] arrI, int[] arrJ) {
		int[] resultantArr = new int[arrI.length+arrJ.length]; 
		mergeArray(arrI, 0, arrJ, 0, resultantArr);
		return resultantArr;
	}
	
	private void mergeArray(int[] arrI, int indexI, int[] arrJ, int indexJ, int[] resultantArr) {
		if(indexI == arrI.length) {
			for(int k = (indexI + indexJ); k < (arrI.length + arrJ.length); ++k){
				resultantArr[k]=arrJ[indexJ++];
			}
			return;
		}
		
		if(indexJ == arrJ.length) {
			for(int k = (indexJ + indexI); k < arrJ.length + arrI.length; ++k){
				resultantArr[k]=arrI[indexI++];
			}
			return;
		}
		
		if(arrI[indexI]<=arrJ[indexJ]) {
			resultantArr[indexI+indexJ] = arrI[indexI];
			mergeArray(arrI, ++indexI, arrJ, indexJ, resultantArr);
		} else
		{
			resultantArr[indexI+indexJ] = arrJ[indexJ];
			mergeArray(arrI, indexI, arrJ, ++indexJ, resultantArr);
		}
	}
}