package com.spandiar;

import java.util.Arrays;

/*
 * Transpose a matrix - meaning, replace the rows and columns of a n dimensional array 
 * */

public class Main {

	public static void main(String[] args) {

		int[][] sourceMatrix = { { 2, 4, -1 }, { -10, 5, 11 }, { 18, -7, 6 } };

		int[][] targetMatrix = transpose(sourceMatrix);

		System.out.println("Source is: " + Arrays.deepToString(sourceMatrix));
		System.out.println("\n\n");
		System.out.println("Result is: " + Arrays.deepToString(targetMatrix));

	}

	private static int[][] transpose(int[][] sourceMatrix) {

		int rows = sourceMatrix.length;
		int cols = sourceMatrix[0].length;
		int[][] targetMatrix = new int[cols][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				targetMatrix[j][i] = sourceMatrix[i][j];
			}
		}

		return targetMatrix;
	}

}
