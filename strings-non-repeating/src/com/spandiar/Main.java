package com.spandiar;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		String input = "yhevyrtsrtavweqwe";

		char result = nonRepeatingChar(input);

		System.out.println("Non repeating char is: " + result);

	}

	private static char nonRepeatingChar(String input) {

		Map<Character, Integer> counterMap = new HashMap<>();
		char[] charArray = input.toCharArray();
		int counter = 0;
		char result = ' ';

		for (int i = 0; i < charArray.length; i++) {
			if (counterMap.containsKey(charArray[i])) {
				counter = counterMap.get(charArray[i]);
				counterMap.put(charArray[i], ++counter);
			} else {
				counterMap.put(charArray[i], 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : counterMap.entrySet()) {
			if (entry.getValue() == 1) {
				result = entry.getKey();
			}
		}

		return result;
	}
	
}
