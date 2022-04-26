package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		int sourceToReverse = 1438302568;
		int result = reverseInteger(sourceToReverse);
		
		System.out.println("Result is " + result);

	}

	private static int reverseInteger(int sourceToReverse) {
		
		int reversedInteger = 0;
		
		while(sourceToReverse > 0) {
			reversedInteger = reversedInteger * 10 + (sourceToReverse % 10);
			sourceToReverse = sourceToReverse / 10;
		}
		
		return reversedInteger;
	}

}
