package com.spandiar;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
//		String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
		String[] emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
		
		int result = numUniqueEmails(emails);
		
		System.out.println("Result is: " + result);
	
	}

	private static int numUniqueEmails(String[] emails) {
		
		if(emails.length <= 0) return 0;
		
		Set<String> uniqueEmails = new HashSet<>();
		String localName = "";
		
		for(String email: emails) {
			
			String[] split = email.split("@");
			if(split[0].contains("+")) {
				localName = split[0].substring(0, split[0].indexOf("+")).replace(".", "");
			} else {
				localName = split[0].replace(".", "");
			}

			System.out.println(split[0] + " - " + localName + " - " + split[1]);
			uniqueEmails.add(localName + "-" + split[1]); 
			
		}
		
		return uniqueEmails.size();
	}

}
