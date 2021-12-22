/*
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, 
 * find two numbers such that they add up to a specific target number. 
 * 
 * Let these two numbers be numbers[index1] and numbers[index2] 
 * where 1 <= index1 < index2 <= numbers.length.Return the indices of the two numbers, 
 * index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * 
 * */
package com.spandiar;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		int[] source = new int[] {1, 4, 5, 8, 13, 19, 24};
		int target = 45;
		
		int[] result = findTwoSum(source, target);
		
		System.out.println("Result is: " + Arrays.toString(result));

	}

	private static int[] findTwoSum(int[] source, int target) {
		
		int pointerA = 0;
		int pointerB = source.length - 1;
		
		while(pointerA <= pointerB) {
			
			if(source[pointerA] + source[pointerB] > target) {
				pointerB -= 1;
			} else if(source[pointerA] + source[pointerB] < target) {
				pointerA += 1;
			} else {
				return new int[] {pointerA+1, pointerB+1};
			}
			
		}
		
		return new int[] {-1, -1};
		
	}

}
