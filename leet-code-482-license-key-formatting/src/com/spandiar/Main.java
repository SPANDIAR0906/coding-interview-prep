package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		String original = "hf3eu-53h-dvdu-kjf6-5kr";
		int interval = 4;
		
		String key = keyFormatter(original, interval);

		System.out.println("Formatted Key is: " + key);
	}

	private static String keyFormatter(String original, int interval) {
		
		StringBuffer sb = new StringBuffer(original.replaceAll("-", ""));
		
		for(int i=sb.length() - interval; i>0; i=i-interval) {
			sb.insert(i, "-");
		}
		
		return sb.toString();
	}

}
