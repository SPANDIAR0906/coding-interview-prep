package com.spandiar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		int[] source = new int[] {-11, -8, -4, -1, 0, 3, 5, 7, 9, 10};
		int[] result = squaresOfList(source);
		
		System.out.println("Result is: " + Arrays.toString(result));

	}

	private static int[] squaresOfList(int[] source) {
		
		int positiveIndex = 0;
		int negativeIndex = 0;
		int index = 0;
		int[] result = new int[source.length];
		
		while(positiveIndex < source.length && source[positiveIndex] < 0) {
			positiveIndex += 1;
		}
		
		negativeIndex = positiveIndex - 1;
		
		while(negativeIndex >= 0 && positiveIndex < source.length) {
			
			if((Math.pow(source[negativeIndex], 2)) > (Math.pow(source[positiveIndex], 2))) {
				result[index] = (int) Math.pow(source[positiveIndex], 2);
				positiveIndex += 1;
				index += 1;
			} else {
				result[index] = (int) Math.pow(source[negativeIndex], 2);
				negativeIndex -= 1;
				index += 1;
			}
			
		}
		
		while(negativeIndex >= 0) {
			result[index] = (int) Math.pow(source[negativeIndex], 2);
			negativeIndex -= 1;
			index += 1;
		}
		
		while(positiveIndex < source.length) {
			result[index] = (int) Math.pow(source[positiveIndex], 2);
			positiveIndex += 1;
			index += 1;
		}
		
		return result;
	}

}
