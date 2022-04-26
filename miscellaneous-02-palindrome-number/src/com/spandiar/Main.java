package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		int number = 963084;
		boolean result = checkIfPalindrome(number);
		System.out.println("Result is: " + result);
	}

	private static int reverseNumber(int number) {
		
		int reversedNumber = 0;
		
		while(number > 0) {
			int digit = number % 10;
			reversedNumber = (reversedNumber *  10) + digit;
			number = number / 10;
		}
		System.out.println("reversed number: " + reversedNumber);
		return reversedNumber;
	}
	
	private static boolean checkIfPalindrome(int number) {
		
		if(number < 0) {
			return false;
		}
		
		if(number == 0) {
			return true;
		}
		
		int reversedNumber = reverseNumber(number);
		return (reversedNumber == number);
	}

}
