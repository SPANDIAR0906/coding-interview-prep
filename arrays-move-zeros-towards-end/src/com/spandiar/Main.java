package com.spandiar;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		int[] source = {0, 1, 0, 4, 0, 5, 6, 7, 0, 8, 11, 3, 0};
		
		moveZerosTowardsEndOfArray(source);
		System.out.println(Arrays.toString(source));

	}

	private static int[] moveZerosTowardsEndOfArray(int[] source) {
		
		if(source.length <= 1) {
			return source;
		}
		
		int pointerA = 0;
		int pointerB = 1;
		
		while(pointerB < source.length) {
			
			if(source[pointerA] == 0 && source[pointerB] != 0) {
				swapElements(source, pointerA, pointerB);
				pointerA += 1;
				pointerB += 1;
			} else if (source[pointerA] == 0 && source[pointerB] == 0) {
				pointerB += 1;
			} else {
				return source;
			}
			
		}
		
		return source;
	}

	private static void swapElements(int[] source, int pointerA, int pointerB) {
		
		int temp = source[pointerB];
		source[pointerB] = source[pointerA];
		source[pointerA] = temp;
		
	}

}
