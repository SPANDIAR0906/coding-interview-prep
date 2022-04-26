package com.spandiar;

public class Main {
	
	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		
		final int encryptOffsetValue = 3;
		String phraseToEncrypt = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"; 
//		String phraseToEncrypt = "DADDY"; 

		
		String encryptedPhrase = encryptPhrase(phraseToEncrypt, encryptOffsetValue);
		System.out.println("Encrypted Phrase is: " + encryptedPhrase);
	}

	private static String encryptPhrase(String phraseToEncrypt, int encryptOffsetValue) {
		
		char[] phraseToEncryptInArray = phraseToEncrypt.toCharArray();
		char[] encryptedPhraseInArray = new char[phraseToEncrypt.length()];
		
		for(int i=0; i<phraseToEncryptInArray.length; i++) {
			if(phraseToEncryptInArray[i] != ' ') {
				encryptedPhraseInArray[i] = replaceWithEncryptedWord(phraseToEncryptInArray[i], encryptOffsetValue);
			} else {
				encryptedPhraseInArray[i] = ' ';
			}
		}
		
		return new String(encryptedPhraseInArray);
	}

	private static char replaceWithEncryptedWord(char letter, int encryptOffsetValue) {
		
		int position = ALPHABET.indexOf(letter);
		char encryptedChar = ALPHABET.charAt((position - encryptOffsetValue + 26) % 26);
		System.out.println("Received letter " + letter + " position is " + position + " encrypted letter is " + encryptedChar);
		
		return encryptedChar;
	}

}
