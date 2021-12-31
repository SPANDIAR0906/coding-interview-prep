/*
 * 
 * You are given an integer array height of length n. There are n vertical lines drawn such 
 * that the two end points of the i-th line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container 
 * contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * */


package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		int[] height = {1,8,6,2,5,4,8,3,7,9};
		
		int result = maxArea(height);
		
		System.out.println("Max area is: " + result);
		
	}

	private static int maxArea(int[] height) {
		
		int left = 0;
		int right = height.length - 1;
		int area = 0;
		
		while(left < right) {
			
			if(height[left] < height[right]) {
				area = Math.max(area, (height[left] * (right - left)));
				left += 1;
			} else {
				area = Math.max(area, (height[right] * (right - left)));
				right -= 1;
			}
			
		}
		
		return area;
	}

}
