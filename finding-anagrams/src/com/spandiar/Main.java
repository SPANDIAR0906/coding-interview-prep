package com.spandiar;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		String source = "yotoser";
		String target = "stroroy";
		
		boolean result = checkIfAnagram(source, target);
		
		System.out.println("Anagram check returned: " + result);

	}

	private static boolean checkIfAnagram(String source, String target) {
		
		if(source.length() != target.length()) {
			return false;
		}
		
		Map<Character, Integer> sourceMap = new HashMap<>();
		Map<Character, Integer> targetMap = new HashMap<>();

		populateStringIntoMap(source, sourceMap);
		populateStringIntoMap(target, targetMap);

		return sourceMap.equals(targetMap);
	}

	private static void populateStringIntoMap(String source, final Map<Character, Integer> sourceMap) {
		for(char c : source.toCharArray()) {
			if(sourceMap.containsKey(c)) {
				int counter = sourceMap.get(c);
				sourceMap.put(c, counter+1);
			} else {
				sourceMap.put(c, 1);
			}
		}
	}

}
