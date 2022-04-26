package com.spandiar;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> result = new ArrayList<>();
		
		result = selfDividingNumbers(1, 25);
		
		System.out.println("Result is: " + result);

	}

	private static List<Integer> selfDividingNumbers(int left, int right) {
		
		List<Integer> result = new ArrayList<>();
		
		for(int i=left; i<=right; i++) {
			if(isSelfDividing(i)) {
				result.add(i);
			}
		}
		
		return result;
		
	}

	private static boolean isSelfDividing(int num) {
		
		int next = num;
		int digit = 0;
		
		if(next % 10 == 0) {
			return false;
		}
		
		while(next > 0 && (next % 10 >= 0)) {
			
			digit = next % 10;
			
			if(digit == 0 || num % digit != 0) {
				return false;
			} else {
				next = next / 10;
			}
			
		}
		
		return true;
	}


}
