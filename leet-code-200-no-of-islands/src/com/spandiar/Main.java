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
		
		int[][] landMass = new int[][] {{1,1,0,0,0},{0,1,0,0,1},{0,0,0,1,1},{1,1,0,1,0}};
		
		int islandCount = findNoOfIslands(landMass);
		
		System.out.println("Island count is: " + islandCount);

	}

	private static int findNoOfIslands(int[][] landMass) {
		
		int islandCounter=0;
		
		for(int i=0; i < landMass.length; i++) {
			for(int j=0; j< landMass[i].length; j++) {
				if(landMass[i][j] == 1) {
					islandCounter++;
					resetNeighbour(landMass, i, j);
				}
			}
		}
		
		return islandCounter;
	}

	private static void resetNeighbour(int[][] landMass, int i, int j) {
		
		if(i>=0 && j>= 0 && i < landMass.length && j < landMass[i].length) {
			
			if(landMass[i][j] == 1) {
				
				landMass[i][j] = 0;
				System.out.println(String.format("i is %s j is %s landMass is %s ", i, j, Arrays.deepToString(landMass)));
				resetNeighbour(landMass, i, j-1);
				resetNeighbour(landMass, i, j+1);
				resetNeighbour(landMass, i-1, j);
				resetNeighbour(landMass, i+1, j);
				
			}
		}
		
	}

}
