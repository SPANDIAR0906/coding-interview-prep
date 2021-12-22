package com.spandiar;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// NOTE: The following input values are used for testing your solution.

		// mostFrequent(array1) should return 1.
		int[] array1 = { 1, 3, 1, 3, 2, 1 };
		// mostFrequent(array2) should return 3.
		int[] array2 = { 3, 3, 1, 3, 2, 1 };
		// mostFrequent(array3) should return null.
		int[] array3 = {};
		// mostFrequent(array4) should return 0.
		int[] array4 = { 0 };
		// mostFrequent(array5) should return -1.
		int[] array5 = { 0, -1, 10, 10, -1, 10, -1, -1, -1, 1, 3, 3, 3, 3};
		
		Integer mostFreqent = mostFreqent(array5);
		
		System.out.println(mostFreqent);
		
	}
	

	// Implement your solution below.
	public static Integer mostFreqent(int[] givenArray) {
	        Integer maxOccuranceItem = null;
	        Integer maxOccuringCount = 0;
	        Map<Integer, Integer> mostFrequentMap = new HashMap<Integer, Integer>();
	        
	        for(int i = 0; i< givenArray.length; i++) {
	           if(! mostFrequentMap.containsKey(givenArray[i])) {
	        	   mostFrequentMap.put(givenArray[i], 1);
	           } else {
	        	   int occurance = mostFrequentMap.get(givenArray[i]);
	        	   mostFrequentMap.put(givenArray[i], ++occurance);
	        	   if(occurance > maxOccuringCount) {
	        		   maxOccuranceItem = givenArray[i];
	        		   maxOccuringCount = occurance;
	        	   }
	           }
	        }
	        
	        return maxOccuranceItem;
	    }

}
