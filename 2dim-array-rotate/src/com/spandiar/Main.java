package com.spandiar;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[][] sourceMatrix = new int[][] { {1, 2}, {3, 4}};

		System.out.println("Before Rotation");
		System.out.println(Arrays.deepToString(sourceMatrix));

		int[][] targetMatrix = rotateMatrixCyclic(sourceMatrix);

		System.out.println("After Rotation");
		System.out.println(Arrays.deepToString(targetMatrix));
	}

	
	private static int[][] rotateMatrixCyclic(int[][] sourceMatrix) {
		
		int[][] targetMatrix = new int[sourceMatrix.length][sourceMatrix.length];
		
		// 0,0 -> 0,2   1,0 -> 0,1  2,0 -> 0,0
		// 0,1 -> 1,2   1,1 -> 1,1  2,1 -> 1,0
		// 0,2 -> 2,2   1,2 -> 2,1  2,2 -> 2,0
		
		for(int i=0; i<sourceMatrix.length;i++) {
			for(int j=0; j<sourceMatrix[i].length; j++) {
				int[] newCoordinate = findNewCoordinates(i,j,sourceMatrix.length);
				targetMatrix[newCoordinate[0]][newCoordinate[1]] = sourceMatrix[i][j];
			}
		}
		return targetMatrix;
	}
	
	private static int[] findNewCoordinates(int i, int j, int length) {
		return new int[] {j, (length - 1 - i)};
	}

	private static int[][] rotateMatrixInPlace(int[][] sourceMatrix) {
		return sourceMatrix;
	}

}



