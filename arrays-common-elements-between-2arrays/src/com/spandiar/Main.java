package com.spandiar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] array2 = { 2, 4, 6, 8, 9, 10, 12 };

		List<Integer> commonElements = returnCommonElementsAlternate(array1, array2);
		System.out.println(commonElements.toString());

	}

	private static List<Integer> returnCommonElements(int[] array1, int[] array2) {

		List<Integer> commonElementsList = new ArrayList<>();

		for(int i=0; i< array1.length; i++) {
			if(Arrays.binarySearch(array2, array1[i]) >= 0 ) {
				commonElementsList.add(array1[i]);
			}
		}

		return commonElementsList;

	}

	private static List<Integer> returnCommonElementsAlternate(int[] array1, int[] array2) {

		List<Integer> commonElementsList = new ArrayList<>();
		int i=0;
		int j=0;
		int length1 = array1.length;
		int length2 = array2.length;

		while( i < length1 && j < length2) {
			if(array1[i] == array2[j]) {
				commonElementsList.add(array1[i]);
				i++;
				j++;
			} else if (array1[i] > array2[j]) {
				j++;
			} else {
				i++;
			}
		}

		return commonElementsList;
	}
}
