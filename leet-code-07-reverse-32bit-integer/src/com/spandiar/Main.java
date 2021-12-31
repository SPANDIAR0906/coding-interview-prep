/*
 * Leet Code # 7 - Reverse Integer
 * 
 * Given a signed 32-bit integer x, return x with its digits reversed. 
 * If reversing x causes the value to go outside the signed 32-bit integer range 
 * [-231, 231 - 1], then return 0.
 * 
 * */

package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		int source = -146384413;
		int reversedInt = 0;
		
		System.out.println("Integer Max Value - " + Integer.MAX_VALUE );
		System.out.println("Integer Min Value - " + Integer.MIN_VALUE );
		
		
//		reversedInt = reverseInteger(source);
		reversedInt = reverseIntegerAlternate(source);
		System.out.println(reversedInt);

	}

	private static int reverseIntegerAlternate(int source) {
		/* Leet Code Solution - Nick White */ 
		
		int reversed = 0;
		int pop = 0;
		
		while(source != 0) {
			
			pop = source % 10;
			source = source / 10;
			
			if(reversed > (Integer.MAX_VALUE / 10) || 
					((reversed == Integer.MAX_VALUE/10) && pop > 7)) {
				System.out.println("exceeded max value");
				return 0;
			}
			if(reversed < (Integer.MIN_VALUE / 10) || 
					((reversed == (Integer.MIN_VALUE / 10) && pop < 8))) {
				System.out.println("exceeded minvalue");
				return 0;
			}
			reversed = (reversed * 10) + pop;
		}
		return reversed;
	}

	private static int reverseInteger(int source) {
		
		long reversedInt = 0;
		boolean negativeInt = false;
		
		if(source == 0) return 0;
		
		if(source < 0) {
			negativeInt = true;
			source = source * -1;
		}
		
		while((source > 0) && (source % 10 >= 0)) {
			int pop = source % 10;
			reversedInt = (reversedInt * 10) + pop;
			source = source / 10;
		}
		
		if(reversedInt > Integer.MAX_VALUE) return 0;
		
		if(negativeInt) {
			reversedInt = reversedInt * -1;
		}
		
		return (int) reversedInt;
	}

}
