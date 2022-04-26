package com.spandiar;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		int limit = 30;
		List<String> fizzBuzz = new ArrayList<>();
		populateFizzBuzz(limit, fizzBuzz);
		
		System.out.println(fizzBuzz);

	}

	private static void populateFizzBuzz(int limit, List<String> fizzBuzz) {
		
		for(int i=1, fizz=1, buzz=1; i<=limit; i++) {
			if(fizz==3 && buzz==5) {
				fizzBuzz.add("fizzbuzz");
				fizz=1;
				buzz=1;
			} else if(buzz==5) {
				fizzBuzz.add("buzz");
				buzz=1;
				fizz++;
			} else if(fizz==3) {
				fizzBuzz.add("fizz");
				fizz=1;
				buzz++;
			}  else {
				fizzBuzz.add(Integer.toString(i));
				fizz++;
				buzz++;
			}
		}
		
	}

}
