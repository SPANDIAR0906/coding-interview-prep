package com.spandiar;

/*
 * Revision
 * */

public class Main {

	public static void main(String[] args) {
		
		int searchVal = 112;
		int[] source = new int[] {3, 5, 17, 26, 39, 54, 83, 112, 139, 145, 221};
		int index = binarySearch(source, searchVal);
		System.out.println("Index is: " + index);
	}

	private static int binarySearch(int[] source, int searchVal) {
		
		int left = 0;
		int right = source.length - 1;
		
		while(left <= right) {
			
			int median = left + (right-left)/2;
			
			if(source[median] == searchVal) {
				return median;
			} else if(source[median] > searchVal) {
				right = median - 1;
			} else {
				left = median + 1;
			}
			
		}
		
		
		return -1;
	}

}
