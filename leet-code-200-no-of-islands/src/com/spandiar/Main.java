package com.spandiar;

import java.util.Arrays;

/*
 * 
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), 
 * return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally 
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 * 
 * */

public class Main {

	public static void main(String[] args) {
		
		int[][] landMass = new int[][] {{1,1,0,1,1},{0,1,0,0,1},{0,0,0,1,1},{1,1,0,1,0}};
		
		int islandCount = findIslandCount(landMass);
		System.out.println("Island count is: " + islandCount);

	}

	private static int findIslandCount(int[][] landMass) {
		
		if(landMass == null) {
			return 0;
		}
		
		int islandCount = 0;
		
		for(int row = 0; row < landMass.length; row++) {
			for(int col = 0; col < landMass[row].length; col++) {
				if(landMass[row][col] == 1) {
					islandCount++;
					checkAdjacentCells(landMass, row, col);
				}
			}
		}
		
		return islandCount;
	}

	private static void checkAdjacentCells(int[][] landMass, int row, int col) {
		
		if(row < 0 || row >= landMass.length || col < 0 || col >= landMass[row].length) {
			return;
		}
		
		if(landMass[row][col] == 1) {
			landMass[row][col] = 9;
			checkAdjacentCells(landMass, row, col+1);
			checkAdjacentCells(landMass, row, col-1);
			checkAdjacentCells(landMass, row+1, col);
			checkAdjacentCells(landMass, row-1, col);
		} else {
			return;
		}
		
	}



}
