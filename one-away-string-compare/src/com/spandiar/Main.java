package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		String one = "apples";
		String two = "alpes";
		
		boolean result = checkIfOneAway(one, two);
		System.out.println("Result of the computation is: " + result);

	}

	private static boolean checkIfOneAway(String one, String two) {
		
		int counterOne = 0;
		int counterTwo = 0;
		boolean result = true;
		boolean mismatchFound = false;
		
		if(!(one.length() == two.length() + 1)) {
			return false;
		}
		
		while(counterOne < one.length()) {
			
			if(one.charAt(counterOne) == two.charAt(counterTwo)) {
				counterOne++;
				counterTwo++;
			} else if(one.charAt(counterOne) != two.charAt(counterTwo) && !mismatchFound) {
				counterOne++;
				mismatchFound = true;
			} else {
				return false;
			}
			
		}
		
		return result;
	}

}
