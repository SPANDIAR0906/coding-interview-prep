package com.spandiar;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		generateMatrix(4);

	}

	private static int[][] generateMatrix(int size) {
		
		int rowBegin = 0;
		int rowEnd = size - 1;
		int colBegin = 0;
		int colEnd = size - 1;
		int counter = 1;
		int[][] matrix = new int[size][size];
		
		while(rowBegin <= rowEnd && colBegin <= colEnd) {
			
			for(int j = colBegin; j <= colEnd; j++) {
				matrix[rowBegin][j] = counter;
				counter++;
			}
			
			rowBegin++;
			
			for(int j=rowBegin; j <= rowEnd; j++) {
				matrix[j][colEnd] = counter;
				counter++;
			}
			
			colEnd--;
			
			for(int j=colEnd; j>=colBegin; j--) {
				matrix[rowEnd][j] = counter;
				counter++;
			}
			
			rowEnd--;
			
			for(int j=rowEnd; j>=rowBegin; j--) {
				matrix[j][colBegin] = counter;
				counter++;
			}
			
			colBegin++;
			
		}
		
		
//		System.out.println(Arrays.deepToString(matrix));
		return matrix;
		
	}

}
