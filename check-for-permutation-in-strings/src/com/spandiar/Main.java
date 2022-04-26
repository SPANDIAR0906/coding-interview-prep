package com.spandiar;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		String one = "urbwegewjifb";
		String two = "uwrgewbjebfi";
		
		boolean result = checkIfPermutation(one, two);
		System.out.println("Result of the computation is: " + result);

	}

	private static boolean checkIfPermutation(String one, String two) {
		
		if(one.length() != two.length()) {
			return false;
		} 
		
		return (sort(one).equals(sort(two)));
	}

	private static String sort(String source) {
		
		char[] charArray = source.toCharArray();
		System.out.println("charArray is: " + Arrays.toString(charArray));
		Arrays.sort(charArray);
		System.out.println("Sorted string array is: " + Arrays.toString(charArray));
		return new String(charArray);
		
	}

}
