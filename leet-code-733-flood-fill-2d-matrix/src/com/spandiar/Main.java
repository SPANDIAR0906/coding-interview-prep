package com.spandiar;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		int[][] image = new int[][] {{1,1,1}, {1,1,0}, {1,0,1}};
		
//		{1,1,1}, 
//		{1,1,0}, 
//		{1,0,1}
		
//		[[2, 2, 2], 
//		 [2, 2, 0], 
//		 [2, 0, 1]]
		
		floodFill(image, 1, 1, 2);
		System.out.println(Arrays.deepToString(image));

	}

	private static int[][] floodFill(int[][] image, int row, int col, int newColor) {
		
		refreshImage(image, image[row][col], newColor, row, col);
		return image;
		
	}

	private static void refreshImage(int[][] image, int originalColor, int newColor, int row, int col) {
		
		if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != originalColor) {
			return;
		}
		
		image[row][col] = newColor;
		refreshImage(image,  originalColor,  newColor,  row + 1,  col);
		refreshImage(image,  originalColor,  newColor,  row - 1,  col);
		refreshImage(image,  originalColor,  newColor,  row,  col + 1);
		refreshImage(image,  originalColor,  newColor,  row,  col - 1);
		
	}

}
