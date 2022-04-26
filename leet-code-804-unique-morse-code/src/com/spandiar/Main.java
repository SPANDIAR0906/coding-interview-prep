package com.spandiar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		String[] words = {"cat", "dog", "rat", "gin", "zen"};
	
		int result = uniqueMorseRepresentations(words);
		
		System.out.println("Result is: " + result);

	}

	private static int uniqueMorseRepresentations(String[] words) {
		
		Set<String> uniqueCodes = new HashSet<>();
		Map<Character, String> alphaMorseCodeMap = new HashMap<>();
		String[] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		
		populateAlphaMorseCodeMap(morseCodes, alphaMorseCodeMap);
		
		for(String word : words) {
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<word.length(); i++) {
				char character = word.charAt(i);
				sb.append(alphaMorseCodeMap.get(character));
			}
			
			uniqueCodes.add(sb.toString());
		}
		
		return uniqueCodes.size();
		
	}

	private static void populateAlphaMorseCodeMap(String[] morseCodes, Map<Character, String> alphaMorseCodeMap) {
		
		alphaMorseCodeMap.put('a', morseCodes[0]);
		alphaMorseCodeMap.put('b', morseCodes[1]);
		alphaMorseCodeMap.put('c', morseCodes[2]);
		alphaMorseCodeMap.put('d', morseCodes[3]);
		alphaMorseCodeMap.put('e', morseCodes[4]);
		alphaMorseCodeMap.put('f', morseCodes[5]);
		alphaMorseCodeMap.put('g', morseCodes[6]);
		alphaMorseCodeMap.put('h', morseCodes[7]);
		alphaMorseCodeMap.put('i', morseCodes[8]);
		alphaMorseCodeMap.put('j', morseCodes[9]);
		alphaMorseCodeMap.put('k', morseCodes[10]);
		alphaMorseCodeMap.put('l', morseCodes[11]);
		alphaMorseCodeMap.put('m', morseCodes[12]);
		alphaMorseCodeMap.put('n', morseCodes[13]);
		alphaMorseCodeMap.put('o', morseCodes[14]);
		alphaMorseCodeMap.put('p', morseCodes[15]);
		alphaMorseCodeMap.put('q', morseCodes[16]);
		alphaMorseCodeMap.put('r', morseCodes[17]);
		alphaMorseCodeMap.put('s', morseCodes[18]);
		alphaMorseCodeMap.put('t', morseCodes[19]);
		alphaMorseCodeMap.put('u', morseCodes[20]);
		alphaMorseCodeMap.put('v', morseCodes[21]);
		alphaMorseCodeMap.put('w', morseCodes[22]);
		alphaMorseCodeMap.put('x', morseCodes[23]);
		alphaMorseCodeMap.put('y', morseCodes[24]);
		alphaMorseCodeMap.put('z', morseCodes[25]);
		
	}

}
