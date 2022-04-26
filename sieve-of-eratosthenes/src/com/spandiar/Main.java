package com.spandiar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	
	static final int UPPERBOUND = 100;

	public static void main(String[] args) {
		
		boolean[] isComposite = new boolean[UPPERBOUND+1];
		isComposite[0] = true;
		isComposite[1] = true;
		
		for(int i=2; i<=Math.sqrt(UPPERBOUND); i++) {
			System.out.println("Looping for " + i);
			if(!isComposite[i]) {
				isComposite[i] = false;
				for(int j = i*i; j<=UPPERBOUND; j = j+i) {
					// set all multiples of i as true
					isComposite[j] = true;
				}
			}
		}
		
		System.out.println("Printing all primes");
		for(int k=2; k<isComposite.length; k++) {
			if(isComposite[k] == false) {
				System.out.println(k + " is Prime");
			}
		}
	}

}
