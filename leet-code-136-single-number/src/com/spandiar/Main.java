package com.spandiar;

import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		
		int[] nums = {3, 4, 5, 3, 7, 8, 4, 5, 8};
		int result = 0;
		
//		result = singleNumber(nums);
		result = singleNumberAlternate(nums);
		
		System.out.println("Result is: " + result);

	}

	private static int singleNumberAlternate(int[] nums) {
		
		// this solution uses bitwise operators
		int result = 0;
		
		for(int i=0; i < nums.length; i++) {
			
			result = result ^ nums[i];
			System.out.println("Num is: " + nums[i] + " Result is: " + result);
			
		}
		
		return result;
	}

	private static int singleNumber(int[] nums) {
		
		List<Integer> elements = new ArrayList<>();
		
		for(int i=0; i<nums.length; i++) {
			if(elements.contains(nums[i])) {
				int index = elements.indexOf(nums[i]);
				elements.remove(index);
			} else {
				elements.add(nums[i]);
			}
		}
		
		return elements.get(0);
		
	}

}
