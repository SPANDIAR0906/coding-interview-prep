package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		String sample = "azxxzy";
//		String result = removeAdjacentDuplicates(sample, false);
		String result = removeAdjacentDuplicatesAlternate(sample);
		System.out.println("Result is: " + result);

	}

	private static String removeAdjacentDuplicatesAlternate(String sample) {
		
		char[] stack = new char[sample.length()];
		char[] sourceChar = sample.toCharArray();
		int stackLength = 0;
		
		for(int i=0; i<sourceChar.length; i++) {
			if(stackLength > 0 && stack[stackLength-1] == sourceChar[i]) {
				stackLength = stackLength-1;
			} else {
				stack[stackLength] = sourceChar[i];
				stackLength++;
			}
		}
		
		sample = new String(stack, 0, stackLength);
		return sample;
	}

	private static String removeAdjacentDuplicates(String sample, boolean recursionNeeded) {
	
		recursionNeeded = false;
		char[] charArray = sample.toCharArray();
		
		for(int i=0; i < charArray.length - 1; i++) {
			if(charArray[i] == charArray[i+1]) {
				sample = cleanUpString(sample, i, i+1);
				recursionNeeded = true;
				break;
			}
		}
		
		if(recursionNeeded) {
			sample = removeAdjacentDuplicates(sample, recursionNeeded);
		}
		
		return sample;
	}

	private static String cleanUpString(String sample, int i, int j) {
		
		StringBuilder sb = new StringBuilder();
		
		char[] charArray = sample.toCharArray();
		String regex = sb.append(charArray[i]).append(charArray[j]).toString();
		sample = sample.replaceFirst(regex, "");
		return sample;
	}

}
