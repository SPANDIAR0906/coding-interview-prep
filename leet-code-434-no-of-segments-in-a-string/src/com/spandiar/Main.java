/*
 * 
 * Remember, we are counting the number of segments here, not the number of white spaces
 * 
 * */
package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		String source = "Hello there my name is Shankee P";
//		String source = " ";

		
		int segments = countSegments(source);
		System.out.println(segments);

	}

	private static int countSegments(String source) {
		
		int segmentsCounter = 0;
		
		for(int i=0; i< source.length(); i++) {
			if((i == 0 || source.charAt(i - 1) == ' ') && (source.charAt(i) != ' ')) {
				segmentsCounter++;
			}
		}
		
		return segmentsCounter;
	}

}
