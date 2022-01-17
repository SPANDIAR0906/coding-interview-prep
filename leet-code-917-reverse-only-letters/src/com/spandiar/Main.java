package com.spandiar;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		String source = "Test1ng-Leet=code-Q!";
		String result = reverseOnlyLetters(source);
		String resultAlt1 = reverseOnlyLettersUsingStack(source);
		System.out.println("Result is: " + result + " alternate is :" + resultAlt1);

	}
	
	

	private static String reverseOnlyLettersUsingStack(String source) {
		
		Stack<Character> reversedSource  = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < source.length(); i++) {
			if(Character.isLetter(source.charAt(i))) {
				reversedSource.push(source.charAt(i));
			}
		}
		
		for(int i=0; i < source.length(); i++) {
			if(Character.isLetter(source.charAt(i))) {
				sb.append(reversedSource.pop());
			} else {
				sb.append(source.charAt(i));
			}
		}
		
		return sb.toString();
	}



	private static String reverseOnlyLetters(String source) {
		
		int aPointer = 0;
		int bPointer = source.length() - 1;
		char[] reversedCharArray = new char[source.length()];
		
		while(aPointer <= bPointer) {
			
			if(Character.isAlphabetic(source.charAt(aPointer)) && 
					Character.isAlphabetic(source.charAt(bPointer))) {
				swapChar(source, reversedCharArray, aPointer, bPointer);
				aPointer++;
				bPointer--;
			} else if(!Character.isAlphabetic(source.charAt(aPointer)) &&
							Character.isAlphabetic(source.charAt(bPointer))) {
				reversedCharArray[aPointer] = source.charAt(aPointer);
				aPointer++;
				
			} else if(Character.isAlphabetic(source.charAt(aPointer)) &&
							!Character.isAlphabetic(source.charAt(bPointer))) {
				reversedCharArray[bPointer] = source.charAt(bPointer);
				bPointer--;
			} else {
				reversedCharArray[aPointer] = source.charAt(bPointer);
				aPointer++;
				bPointer--;
			}
			
		}
		
		return String.valueOf(reversedCharArray);
	}

	private static void swapChar(String source, char[] reversedCharArray, int aPointer, int bPointer) {
		
		reversedCharArray[aPointer] = source.charAt(bPointer);
		reversedCharArray[bPointer] = source.charAt(aPointer);
		
	}

}
