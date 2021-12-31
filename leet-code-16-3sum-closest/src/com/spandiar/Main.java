package com.spandiar;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		int[] nums = {0, 2, 1, -3};
		int target = 1;
		int result = 0;
		
		result = findClosestSum(nums, target);
		
		System.out.println(result);

	}

	private static int findClosestSum(int[] nums, int target) {
		
		int result = 0;
		int tempResult = 0;
		int aPointer = 0;
		int bPointer = 0;
		
		result = nums[0] + nums[1] + nums[nums.length - 1];
		Arrays.sort(nums);
		System.out.println("Source is: " + Arrays.toString(nums));
		
		for(int i = 0; i < nums.length - 2; i++) {
			
			System.out.println("i is " + i);
			
			aPointer = i+1;
			bPointer = (nums.length - 1);
			
			while(aPointer < bPointer) {
				tempResult = nums[i] + nums[aPointer] + nums[bPointer];
//				System.out.println(nums[i] + " - " + nums[aPointer] + " - " + nums[bPointer]);
				System.out.println("tempResult is: " + tempResult);
				
				if(tempResult > target) {
					bPointer -= 1;
				} else {
					aPointer += 1;
				}
				
				if(Math.abs(tempResult - target) < Math.abs(result - target)) {
					result = tempResult;
					System.out.println("Result is: " + result);
				}
				
			}
			
		}
		
		return result;
	}

}
