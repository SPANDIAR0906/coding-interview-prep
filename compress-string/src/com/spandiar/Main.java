package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		String source = "ttyyrrru";
		String result = compressString(source);
		System.out.println("Result of the compressed string is: " + result);

	}

	private static String compressString(String source) {
		
		StringBuilder sb = new StringBuilder();
		int sourceLengthCheck = 0;
		int innerCharLengthCounter = 0;
		int counter = 0;

		
		for(int i=0; i<source.length(); i++) {
			counter++;
			if((i + 1 >= source.length()) || (source.charAt(i) != source.charAt(i + 1))) {
				sb = sb.append(source.charAt(i));
				sb = sb.append(counter);
				counter = 0;
			} 
		}
		
		return (sb.length() >=  source.length()) ? source : sb.toString();
	}

}