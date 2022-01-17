package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		int[] source = {2, 14, 16, 15, 9, 3, 1};
		
		int index = peakIndexInMountainArray(source);
		
		System.out.println("result is: " + index);
	}

	private static int peakIndexInMountainArray(int[] source) {
		
		int left = 0;
		int right = source.length - 1;
		
		while(left < right) {
			int middle = left + ((right - left) / 2);
			if(source[middle] < source[middle+1]) {
				// move right
				left = middle + 1;
			} else {
				// move left
				right = middle;
			}
			
		}
		
		return right;
		
	}
}
