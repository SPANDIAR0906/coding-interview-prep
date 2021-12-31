/*
 * 
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters 
 * and removing all non-alphanumeric characters, it reads the same forward and backward. 
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * */

package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		String source = "A man, a plan, a canal: Panama";
		
		boolean result = checkifPalindrome(source);
		
		System.out.println("result is: " + result);

	}

	private static boolean checkifPalindrome(String source) {
		
		
		String formatted = source.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
		char[] sourceString = formatted.toCharArray();
		int begin = 0;
		int end = sourceString.length - 1;
		
		while(begin < end) {
			if(sourceString[begin] != sourceString[end]) {
				return false;
			}
			begin++;
			end--;
		}
		
		return true;
	}

}
