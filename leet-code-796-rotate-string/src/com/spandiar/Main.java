package com.spandiar;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		String source = "abcdefg";
		String target = "defgabc";
		
//		boolean result = rotateStringAndCompare(source, target);
		boolean alternateResult = rotateStringAndCompareAlternate(source, target);
		System.out.println("Result is: " + alternateResult);

	}

	private static boolean rotateStringAndCompareAlternate(String source, String target) {
		
		return(source.length() == target.length() && (source+source).contains(target));
		
	}

	private static boolean rotateStringAndCompare(String source, String target) {
		
		char temp = ' ';
		int i=0;
		char[] sourceCharArray = source.toCharArray();
		
		if(source.length() != target.length()) {
			System.out.println("Invalid length");
			return false;
		}

		if(source.contentEquals(target)) {
			System.out.println("Direct match");
			return true;
		}
		
		while(i < source.length()) {
			for(int j=0; j<sourceCharArray.length;j++) {
				if(j==0) {
					temp = sourceCharArray[0];
				}
				
				if(j == sourceCharArray.length - 1) {
					sourceCharArray[j] = temp;
				} else {
					sourceCharArray[j] = sourceCharArray[j+1];
				}
			}
			System.out.println("Char Array is: " + Arrays.toString(sourceCharArray));
			if(target.contentEquals(new String(sourceCharArray))) {
				return true;
			}
			i++;
		}
		
		return false;
	}

}
