package com.spandiar;

import java.util.ArrayList;
import java.util.Arrays;
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

	private static List<List<Integer>> drawPascalsTriangle(int counter) {
		
		List<List<Integer>> triangle = new ArrayList<>();
		
		if(counter <= 0) {
			return triangle;
		}

		// add row 1
		triangle.add(List.of(1));
		
		for(int i = 1; i < counter; i++) {
			
			List<Integer> currentRow = new ArrayList<>();
			List<Integer> previousRow = triangle.get(i-1);
			int j = 1;

			currentRow.add(1);
			while(j < i) {
				currentRow.add(previousRow.get(j-1) + previousRow.get(j));
				j++;
			}
			currentRow.add(1);
			
			triangle.add(currentRow);
		}
		
		return triangle;
	}


}
