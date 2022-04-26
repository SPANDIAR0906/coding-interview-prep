package com.spandiar;

public class Main {

	public static void main(String[] args) {

		int[] fruits = {0,1,1,2,2};
		int maxFruits = totalFruits(fruits);
		System.out.println("Max fruits is: " + maxFruits);

	}

	private static int totalFruits(int[] fruits) {
		
		int maxFruits = 0;
		int currentMaxFruits = 0;
		int previousFruit1 = -1;
		int previousFruit2 = -1;
		int previousFruitCounter = 0;
		
		for(int i=0; i<fruits.length;i++) {
			
			if(previousFruit1 == -1) {
				previousFruit1 = fruits[i];
			} else if(previousFruit1 != -1 && previousFruit2 == -1) {
				previousFruit2 = fruits[i];
			}
			
			if(fruits[i] == previousFruit1 || fruits[i] == previousFruit2) {
				currentMaxFruits++;
			} else {
				maxFruits = Math.max(maxFruits, currentMaxFruits);
				currentMaxFruits = previousFruitCounter;
				if(i > 0 && (fruits[i-1] == previousFruit1)) {
					previousFruit2 = fruits[i];
				} else if(i > 0 && (fruits[i-1] == previousFruit2)){
					previousFruit1 = fruits[i];
				}
			}
			
			if(i > 0 && (fruits[i] == fruits[i-1])) {
				previousFruitCounter++;
			} else {
				previousFruitCounter = 1;
			}
			maxFruits = Math.max(maxFruits, currentMaxFruits);
		}
		
		return Math.max(maxFruits, currentMaxFruits);
		
	}

}
