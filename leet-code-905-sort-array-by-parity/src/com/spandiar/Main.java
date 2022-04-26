package com.spandiar;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		int[] nums = {3, 4, 1, 5, 2, 7, 8};
		int[] sortedNums = sortArrayByParity(nums);
		
		System.out.println("Result is: " + Arrays.toString(sortedNums));

	}

	private static int[] sortArrayByParity(int[] nums) {
		
		if(nums.length <= 0) return nums;
		
		int left = 0;
		int right = nums.length - 1;
		
		sortByOddEven(nums, left, right);
		
		return nums;
	}

	private static int[] sortByOddEven(int[] nums, int left, int right) {
		
		while(left <= right) {
			
			if(nums[left] % 2 != 0 && nums[right] % 2 == 0) {
				swapElements(nums, left, right);
				left++;
				right--;
			} else if(nums[left] % 2 == 0 && nums[right] % 2 == 1) {
				left++;
				right--;
			} else if(nums[left] % 2 == 0) {
				left++;
			} else if(nums[right] % 2 == 1) {
				right--;
			}
			
		}
		
		return nums;
	}

	private static void swapElements(int[] nums, int left, int right) {
		
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
		
	}

}
