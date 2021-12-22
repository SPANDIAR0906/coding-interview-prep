package com.spandiar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that 
 * they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same 
 * element twice.
 * 
 * Example 1
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * */

public class Main {

	public static void main(String[] args) {
		
		int[] nums = new int[] {3, 5, 7, 11, 25};
		int target = 33;
		
		int[] twoSumResult = twoSum(nums, target);
		
		System.out.println("Array elements are at indexes " + Arrays.toString(twoSumResult) + " adding to " + target);
		
	}
	
	public static int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> elementsMap = new HashMap<>();
		int[] result = new int[2];
		boolean matchFound = false;
		
		for(int i=0; i<nums.length; i++) {
			
			int delta = target - nums[i];
			
			if(elementsMap.containsKey(delta)) {
				
				matchFound = true;
				result[0] = elementsMap.get(delta);
				result[1] = i;
				
			} else {
				
				elementsMap.put(nums[i], i);
				
			}
			
		}
		
		return (matchFound) ?  result : new int[] {-1, -1};
		
	}

}
