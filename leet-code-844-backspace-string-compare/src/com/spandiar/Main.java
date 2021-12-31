/*
 * Leet Code #844
 * 
 * Given two strings s and t, return true if they are equal when both are typed into empty text 
 * editors. '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * */

package com.spandiar;

public class Main {

	public static void main(String[] args) {

		String s1 = "ab##";
		String s2 = "c#d#";

//		boolean result = compareStrings(s1, s2);
		boolean result = compareStringsAlternate(s1, s2);

		System.out.println("Result is: " + result);

	}

	private static boolean compareStringsAlternate(String s1, String s2) {

		int s1Pointer = s1.length()-1;
		int s2Pointer = s2.length()-1;
		int s1SkipCounter = 0;
		int s2SkipCounter = 0;

		while(s1Pointer >= 0 || s2Pointer >= 0) {

			if((s1Pointer < 0 && ((s2Pointer >= 0) && (s2.charAt(s2Pointer) != '#'))) 
					|| (s2Pointer < 0 && (s1Pointer >= 0) && (s1.charAt(s1Pointer) != '#'))) {
				return false;
			}
			
			while((s1Pointer >= 0) && (s1.charAt(s1Pointer) == '#')) {
				s1SkipCounter++;
				s1Pointer -= 1;
			}

			while((s2Pointer >= 0) && (s2.charAt(s2Pointer) == '#')) {
				s2SkipCounter++;
				s2Pointer -= 1;
			}

			while(s1SkipCounter > 0 && s1Pointer >= 0 && s1.charAt(s1Pointer) != '#') {
				s1Pointer -= 1;
				s1SkipCounter -= 1;
			}

			while(s2SkipCounter > 0 && s2Pointer >= 0 && s2.charAt(s2Pointer) != '#') {
				s2Pointer -= 1;
				s2SkipCounter -= 1;
			}
			

			if(s1Pointer >= 0 && s2Pointer >= 0 
					&& s1.charAt(s1Pointer) != '#' && s2.charAt(s2Pointer) != '#') {
							if(s1.charAt(s1Pointer) == s2.charAt(s2Pointer)) {
								s1Pointer -= 1;
								s2Pointer -= 1;
							}
							else {
								return false;
							}
			}

		}

		return true;

	}

	private static boolean compareStrings(String s1, String s2) {

		StringBuilder sb1 = new StringBuilder(s1);
		StringBuilder sb2 = new StringBuilder(s2);

		removeBackspace(sb1);
		removeBackspace(sb2);

		System.out.println("sb1 is: " + sb1);
		System.out.println("sb2 is: " + sb2);

		s1 = sb1.toString();
		s2 = sb2.toString();

		return (s1.equals(s2));
	}

	private static void removeBackspace(StringBuilder sb) {
		while (sb.indexOf("#") >= 0) {
			if (sb.indexOf("#") == 0) {
				sb.deleteCharAt(0);
			} else {
				sb.delete(sb.indexOf("#") - 1, sb.indexOf("#") + 1);
			}
		}
	}

}
