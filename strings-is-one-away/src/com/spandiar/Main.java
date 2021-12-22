package com.spandiar;

public class Main {

	public static void main(String[] args) {

		String s1 = "abde";
		String s2 = "abcde";


		boolean result = false;

		if(s1.length() == s2.length()) {
			result = is_one_off_equal_length(s1, s2);
		} else {
			result = is_one_off_different_lengths(s1, s2);
		}

		System.out.println(result);

	}

	private static boolean is_one_off_different_lengths(String s1, String s2) {

		int l1 = s1.length();
		int l2 = s2.length();

		if(l1 > l2) {
			if(l1 - l2 > 1) return false;
			return is_one_off_diff_length(s1, s2);
		} else {
			if(l2 - l1 > 1) return false;
			return is_one_off_diff_length(s2, s1);
		}
	}


	private static boolean is_one_off_diff_length(String s1, String s2) {

		char[] charArray1 = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();
		int i=0;
		int j=0;
		int mismatchCounter = 0;

		while(i < charArray1.length && j < charArray2.length) {

			if(charArray1[i] == charArray2[j]) {
				++i;
				++j;
			} else {
				++mismatchCounter;
				++i;
			}

		}

		return (mismatchCounter == 0 || mismatchCounter == 1) ? true : false;
	}

	private static boolean is_one_off_equal_length(String s1, String s2) {

		char[] charArray1 = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();
		int i = 0;
		int j=0;
		int mismatchCounter = 0;

		while(i < charArray1.length && j < charArray2.length) {

			if(charArray1[i] == charArray2[j]) {
				++i;
				++j;
			} else {
				++mismatchCounter;
				++i;
				++j;
			}
		}

		return (mismatchCounter == 1) ? true : false;
	}

}
