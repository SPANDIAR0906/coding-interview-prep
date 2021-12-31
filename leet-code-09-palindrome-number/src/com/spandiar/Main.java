/*
 * 
 * Leet Code Problem # 9
 * Multiple approaches are available, but don't convert to string and reverse
 * Even if you are using a number reverse, just stick to reversing half of the integer and compare
 * 
 * */
package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		int source = 743212347;
		
		boolean result = reversedIntegerAlternate(source);
		System.out.println("Result is: " + result);

	}

	private static boolean reversedIntegerAlternate(int source) {
		
		int reverse = 0;
		
		if(source == 0) return true;
		if(source < 0) return false;
		
		while(source > reverse) {
			int pop = source % 10;
			reverse = (reverse * 10) + pop;
			source /= 10;
		}
		
		System.out.println("reversed integer is " + reverse);
		return (source == reverse || source == reverse/10);
	}

	private static boolean reversedInteger(int source) {
		
		int sourceCopy = source;
		int reverse = 0;
		
		if(source == 0) return true;
		if(source < 0) return false;
		
		while(source % 10 > 0) {
			int pop = source % 10;
			reverse = (reverse * 10) + pop;
			source /= 10;
		}
		
		System.out.println("reversed integer is " + reverse);
		return (reverse == sourceCopy);
	}

}
