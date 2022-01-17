package com.spandiar;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		int[] source = new int[] {9,9,9,9};
		
		int[] result = plusOne(source);
		System.out.println(Arrays.toString(result));

	}

	private static int[] plusOne(int[] source) {
		
		for(int i = source.length - 1; i >= 0; i--) {
			if(source[i] != 9) {
				source[i]++;
				return source;
			} else if (source[i] == 9) {
				source[i] = 0;
			}
		}
		System.out.println("Im before the return statement");
		int[] newSource = new int[source.length + 1];
		newSource[0] = 1;
		return newSource;
	}


}
