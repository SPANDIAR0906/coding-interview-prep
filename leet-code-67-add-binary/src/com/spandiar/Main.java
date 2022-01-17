/*
 * Given two binary strings a and b, return their sum as a binary string.
 * */

package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		String a = "110";
		String b = "11";
		
		String result = sumOfBinary(a, b);

	}

	private static String sumOfBinary(String a, String b) {
		
		int aPointer = a.length() - 1;
		int bPointer = b.length() - 1;
		int carryOver = 0;
		int sumOfDigits = 0;
		int one = 0;
		int two = 0;
		StringBuilder sum = new StringBuilder();
		
		
		while(aPointer >= 0 || bPointer >= 0) {
			
			one = 0;
			two = 0;
			
			if(aPointer >= 0) {
				one = a.charAt(aPointer) - '0';
			}
			if(bPointer >= 0) {
				two = b.charAt(bPointer) - '0';
			}
			
			sumOfDigits = one + two + carryOver;
			
			sum = sum.append(sumOfDigits % 2);
			carryOver = sumOfDigits / 2;
			
			aPointer --;
			bPointer --;
			
		}
		
		sum = sum.append(carryOver);
		
		return sum.reverse().toString();
	}

}
