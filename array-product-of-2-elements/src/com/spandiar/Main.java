package com.spandiar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		
		int[] source = new int[] {5, 8, 2, 6, 4, 1, 9};
		final int result = 96;
		Map<Integer, Integer> resultMap;
		
//		resultMap = findProductOfTwoElements(source, result);
		resultMap = findProductOfThreeElements(source, result);
		
		for(Entry<Integer, Integer> entry : resultMap.entrySet()) {
			
			System.out.println("Value of " + entry.getKey() + " with index " + entry.getValue());
			
		}

	}
	
	private static Map<Integer, Integer> findProductOfThreeElements(int[] source, int result) {
		
		Map<Integer, Integer> resultMap = new HashMap<>();
		Map<Integer, Integer> correctedResultMap = new HashMap<>();

		
		for(int i=0; i< source.length; i++) {
			
			int elementOne = source[i];
			int newResult = Math.floorDiv(result, elementOne);
			int[] newSource = removeElementFromArray(source, i);
			
			resultMap = findProductOfTwoElements(newSource, newResult);
			
			if(! resultMap.isEmpty()) {
				int product = productOfMapKeys(resultMap);
				if(Math.multiplyExact(elementOne, product) == result) {
					correctedResultMap = adjustMapValuesWithCorrectIndex(resultMap, source);
					correctedResultMap.put(elementOne, i);
					return correctedResultMap;
				}
			}
		}
		return correctedResultMap;
	}
	
	private static Map<Integer, Integer> adjustMapValuesWithCorrectIndex(Map<Integer, Integer> resultMap, int[] source) {
		
		Map<Integer, Integer> correctedResultMap = new HashMap<>();
		
		Arrays.stream(source).forEach(System.out::println);
		Arrays.sort(source);
		
		for(Entry<Integer, Integer> entry : resultMap.entrySet()) {
			int index = Arrays.binarySearch(source, entry.getKey());
			System.out.println("Binary Search returned " + index);
			correctedResultMap.put(entry.getKey(), index);
		}
		
		return correctedResultMap;
		
	}

	private static int productOfMapKeys(Map<Integer, Integer> resultMap) {
		Optional<Integer> reduce = resultMap.keySet().stream().reduce((a, b) -> (a * b));
		if(reduce.isPresent()) {
			return reduce.get();
		}
		return 0;
	}

	private static int[] removeElementFromArray(int[] source, int index) {
		
		boolean indexMatched = false;
		int[] newSource = new int[source.length - 1];
		
		for(int i=0; i<source.length; i++) {
			if(i == index) {
				indexMatched = true;
				continue;
			}
			if(indexMatched)
				newSource[i-1] = source[i];
			else
				newSource[i] = source[i];
		}
		return newSource;
	}

	private static Map<Integer, Integer> findProductOfTwoElements(int[] source, int result) {
		
		Map<Integer, Integer> arrayElements = new HashMap<>();
		Map<Integer, Integer> resultMap = new HashMap<>();
		
		for(int i=0; i<source.length; i++) {
			int otherInt = Math.floorDiv(result,  source[i]);
			
			if(arrayElements.containsKey(otherInt)) {
				if(Math.multiplyExact(source[i], otherInt) == result) {
//					System.out.println("Found the elements");
//					System.out.println("Combination is " + source[i] + " and " + otherInt);
					resultMap.put(source[i], i);
					resultMap.put(otherInt, arrayElements.get(otherInt));
					return resultMap;
				}
			}
			arrayElements.put(source[i], i);
		}
		return resultMap;
	}
}
