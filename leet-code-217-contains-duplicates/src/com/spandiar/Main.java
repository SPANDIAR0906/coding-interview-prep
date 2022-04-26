package com.spandiar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		int[] source = new int[] {1, 4, 6, 7, 8, 3, 5, 11, 14, 9};
		Arrays.sort(source);
		boolean result = containsDuplicates(source);
		
		System.out.println("Result is: " + result);

	}

	private static boolean containsDuplicates(int[] source) {
		
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<source.length; i++) {
			if(set.contains(source[i])) {
				return true;
			}
			
			set.add(source[i]);
		}
		
		return false;
	}

}
