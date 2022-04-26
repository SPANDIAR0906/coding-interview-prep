package com.spandiar;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		String source = "fshghsafgusfyw";
		int result1 = lengthOfLongestSubstring(source);
		int result2 = lengthOfLongestSubstringAlternate(source);
		System.out.println("Result is: " + result1 + " & " + result2 );

	}

	private static int lengthOfLongestSubstring(String source) {
		
		if(source == null) {
			return 0;
		}
		
		int currentLength = 0;
		int maxLength = 0;
		int counter = 0;
		char[] charArray = source.toCharArray();
		
		while(counter < source.length()) {
			
			Set<Character> dictionary = new HashSet<>();
			currentLength = 0;
			
			for(int i=counter; i<charArray.length; i++) {
			
				if(dictionary.contains(charArray[i])) {
					break;
				} else {
					currentLength++;
					dictionary.add(charArray[i]);
				}
				maxLength = Math.max(maxLength, currentLength);
			}
			counter++;
		}
		
		return Math.max(maxLength, currentLength);
	}
	
	private static int lengthOfLongestSubstringAlternate(String source){
		
//		"abcbca";
		
		int pointerA=0;
		int pointerB = 0;
		int maxLength = 0;
		Set<Character> dataSet = new HashSet<>();
		
		while(pointerB < source.length()) {
			
			if(dataSet.contains(source.charAt(pointerB))) {
				dataSet.remove(source.charAt(pointerA));
				pointerA++;
			} else {
				dataSet.add(source.charAt(pointerB));
				pointerB++;
			}
			maxLength = Math.max(maxLength, dataSet.size());
		}
		
		return Math.max(maxLength, dataSet.size());
	}

}
