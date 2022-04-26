package com.spandiar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		String[] words = new String[] {"cat","bat","hat","tree"};
		String chars = "eeacrt";
		int[] charCounts = new int[26];
		
		for(char ch : chars.toCharArray()) {
			charCounts[ch - 'a']++;
		}

		int result = countOfCharsMatchingWords(words, chars);
		int resultOther = countOfCharsMatchingWords(words, charCounts);
		System.out.println("Result is: " + result);

	}

	private static int countOfCharsMatchingWords(String[] words, int[] charCounts) {
		
		int result = 0;
		
		for(String word : words) {
			if(checkIfSubstring(word, Arrays.copyOf(charCounts, charCounts.length))) {
				result += word.length();
			}
		}
		
		return result;
	}

	private static boolean checkIfSubstring(String word, int[] charCounts) {
		
		for(char alphabet : word.toCharArray()) {
			if(charCounts[alphabet - 'a'] > 0) {
				charCounts[alphabet - 'a']--;
			} else {
				return false;
			}
		}
		
		return true;
	}

	private static int countOfCharsMatchingWords(String[] words, String chars) {

		int result = 0;
		char[] charArray = chars.toCharArray();
		Map<Character, Integer> charMap = new HashMap<>();

		populateMapWithCharDetails(charArray, charMap);

		for(String word : words) {

			if(isSubstring(word, deepCopyOfMap(charMap))) {
				result += word.length();
			}

		}

		return result;
	}
	
	private static Map<Character, Integer> deepCopyOfMap(Map<Character, Integer> original){
		
		Map<Character, Integer> copy = new HashMap<>();
		
		for(Entry<Character, Integer> entry : original.entrySet()) {
			copy.put(entry.getKey(), entry.getValue());
		}
		
		return copy;
	}

	private static void populateMapWithCharDetails(char[] charArray, Map<Character, Integer> charMap) {

		for(char character : charArray) {
			if(charMap.containsKey(character)) {
				Integer count = charMap.get(character);
				charMap.put(character, count+1);
			} else {
				charMap.put(character, 1);
			}
		}

	}

	private static boolean isSubstring(String word, Map<Character, Integer> charMap) {

		char[] wordArray = word.toCharArray();
		Arrays.sort(wordArray);

		for(char alphabet : wordArray) {
			if(charMap.containsKey(alphabet)) {
				if(charMap.get(alphabet) <= 0) {
					return false;
				} else {
					Integer count = charMap.get(alphabet);
					charMap.put(alphabet, count-1);
				}
			} else {
				return false;
			}
		}
		return true;
	}

}
