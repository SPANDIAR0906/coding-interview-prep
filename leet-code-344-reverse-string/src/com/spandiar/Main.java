package com.spandiar;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		String source = "";
		
		reverseString(source.toCharArray());

	}

	private static void reverseString(char[] sourceString) {
		
		int front = 0;
		int end = sourceString.length - 1;
		
		while(front < end) {
			swapChar(sourceString, front, end);
			front ++;
			end --;
		}
		
		System.out.println("Reversed string is: " + Arrays.toString(sourceString));
		
	}

	private static void swapChar(char[] sourceString, int front, int end) {
		
		char a = sourceString[front];
		sourceString[front] = sourceString[end];
		sourceString[end] = a;
		
	}

}
