package com.spandiar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {

		int[][] bombLocation = { { 0, 0 }, { 1, 1 }, { 2, 3 }};
		int[][] sweeperBoard = drawSweeperBoard(bombLocation, 5, 4);
		System.out.println(clickToSweep(sweeperBoard, 3, 1));
//		System.out.println(clickToSweep(sweeperBoard, 0, 3));
//		System.out.println(clickToSweep(sweeperBoard, 2, 3));

	}

	private static int[][] drawSweeperBoard(int[][] bombLocation, int rowSize, int columnSize) {

		int[][] sweeperBoard = new int[rowSize][columnSize];

		for (int i = 0; i < bombLocation.length; i++) {
			int[] row = bombLocation[i];
			sweeperBoard[row[0]][row[1]] = -1;
		}

		//		System.out.println(Arrays.deepToString(sweeperBoard));

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				if (sweeperBoard[i][j] == -1)
					continue;
				else {
					sweeperBoard[i][j] = getSurroundingMineCount(sweeperBoard, i, j);
				}
			}
		}

		System.out.println(Arrays.deepToString(sweeperBoard));

		return sweeperBoard;

	}

	private static int getSurroundingMineCount(int[][] sweeperBoard, int row, int col) {

		int mineCounter = 0;

		for (int i = 0; i < sweeperBoard.length; i++) {
			for (int j = 0; j < sweeperBoard[i].length; j++) {
				if (checkIfAdjacentCell(row, col, i, j)) {
					if (sweeperBoard[i][j] == -1) {
						++mineCounter;
					}
				}
			}
		}

		return mineCounter;
	}

	private static boolean checkIfAdjacentCell(int row, int col, int i, int j) {
		return ((i - row) == -1 || (i - row) == 0 || (i - row) == 1)
				&& ((j - col) == -1 || (j - col) == 0 || (j - col) == 1);
	}
	

	private static String clickToSweep(int[][] sweeperBoard, int row, int col) {

		String message = null;
		int mineCount = sweeperBoard[row][col];

		switch (mineCount) {
		case -1:
			message = "Stepped on a mine. You are busted";
			break;
		case 0:
			revealSurroundingZeros(sweeperBoard, row, col);
			message = "Surrounding Zeros are revealed";
			break;
		default:
			message = String.format("There are %s mines around you", mineCount);
		}
		
		System.out.println(Arrays.deepToString(sweeperBoard));
		return message;
	}

	private static void revealSurroundingZeros(int[][] sweeperBoard, int row, int col) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{row, col});
		
		while(!queue.isEmpty()) {
			int[] rowItem = queue.poll();
			if(sweeperBoard[rowItem[0]][rowItem[1]] == 0) {
				sweeperBoard[rowItem[0]][rowItem[1]] = 9;
				populateAdjacentCells(sweeperBoard, rowItem[0], rowItem[1], queue);
			}
		}
	}

	private static void populateAdjacentCells(int[][] sweeperBoard, int row, int col, Queue<int[]> queue) {
		
		for(int i = row-1; i <= row+1; i++) {
			for(int j = col-1; j<= col+1; j++) {
				if(i >= 0 && i < sweeperBoard.length && j >=0 && j < sweeperBoard[i].length) {
					if(sweeperBoard[i][j] == 0)
						queue.add(new int[]{i, j});
				}
			}
		}
	}
	
}
