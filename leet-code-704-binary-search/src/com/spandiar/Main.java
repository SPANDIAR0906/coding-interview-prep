package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
//		int[] source = new int[] {4, 9, 11, 16, 24, 26, 30, 33, 37, 42, 45, 51, 56, 62, 71};
		int[] source = new int[] {-1, 0, 3, 5, 9, 12};

		int findVal = 13;
		
		int index = binarySearch(source, 0, (source.length - 1), findVal);
		System.out.println("Index is: " + index);
		
	}

	private static int binarySearch(int[] source, int left, int right, int findVal) {
		
		int pivot = (left + ((right - left) / 2));
		
		System.out.println("left is: " + left + " right is " + right);
//		System.out.println("Pivot is: " + pivot + " pivot item is: " + source[pivot] );
		
		if(left > right) {
			return -1;
		}
		
		if(source[pivot] == findVal) {
			return pivot;
		}
		
		if(findVal > source[pivot]) {
			// move right
			return binarySearch(source, pivot+1, right, findVal);
		} else {
			// move left
			return binarySearch(source, left, pivot-1, findVal);
		}
			
	}

}
