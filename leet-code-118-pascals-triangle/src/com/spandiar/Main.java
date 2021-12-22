package com.spandiar;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * 
 * */
public class Main {
	
	final static int ROWS = 7;

	public static void main(String[] args) {
		
		List<List<Integer>> pascalsTriangle = drawPascalsTriangle(ROWS);
		System.out.println(pascalsTriangle);

	}

	private static List<List<Integer>> drawPascalsTriangle(int rows) {
		
		List<List<Integer>> triangle = new ArrayList<>();
		
		if(rows == 0) return triangle;
		
		for (int i=1; i<= rows; i++) {
			
			List<Integer> currentRow = new ArrayList<>();
			
			for (int j=1; j<= i; j++) {
				if(j == 1 || j == i) {
					currentRow.add(1);
				} else {
					List<Integer> prevRow = triangle.get(i-2);
					currentRow.add(prevRow.get(j-2) + prevRow.get(j-1));
				}
			}
			triangle.add(currentRow);
		}
		return triangle;
	}

}
