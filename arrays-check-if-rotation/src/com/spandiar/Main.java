package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		int[] array1 = {1, 2, 4, 3, 5, 6, 7};
		int[] array2 = {5, 6, 7, 1, 2, 4, 3};
		
		boolean result = isRotation(array1, array2);
		
		System.out.println("Are the arrays in rotation: " + result);

	}

	private static boolean isRotation(int[] array1, int[] array2) {
		
		int length1 = array1.length;
		int length2 = array2.length;
		int i=0;
		int j=0;
		boolean result = false;
		boolean initialMatchFound = false;
		
		if(length1 != length2) {
			return result;
		}
		
		while(i < length1) {
			if(array1[i] == array2[j]) {
				initialMatchFound = true;
				i++;
				j = ( j < (length2 - 1) ) ? ++j : 0;
				result = true;
				continue;
			} else if (initialMatchFound) {
				result = false;
				return result;
			}
			else {
				j = ( j < (length2 - 1) ) ? ++j : 0;
			}
		}
		
		return result;
	}

}
