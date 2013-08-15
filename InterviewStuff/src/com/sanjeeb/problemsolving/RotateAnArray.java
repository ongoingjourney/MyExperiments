package com.sanjeeb.problemsolving;

public class RotateAnArray {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{11,12,13,14},{15,16,17,18},{19,20,21,22},{23,24,25,26}};
		displayMatrix(matrix);
		rotateMatrix(matrix);
		System.out.println();
		displayMatrix(matrix);
	}

	public static void rotateMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; ++i) {
			int j = i; 
			while(j < matrix[0].length) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
				++j;
			}
		}
	}
	
	public static void displayMatrix(int[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;
		for(int i = 0; i < rowCount; ++i) { 
			for(int j = 0; j < colCount; ++j) 
				System.out.print(matrix[i][j] + "  ");
			System.out.println();		
		}			
	}
}