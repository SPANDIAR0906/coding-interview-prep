package com.spandiar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		int[] iceCreamMenu = {3, 6, 5, 7, 8, 2, 9, 4};
		int totalMoney = 11;
		
		int[] result = getIndexAddingToTotal(iceCreamMenu, totalMoney);
		
		System.out.println("Result is: " + Arrays.toString(result));

	}

	private static int[] getIndexAddingToTotal(int[] iceCreamMenu, int totalMoney) {
		
		int[] clonedMenu = iceCreamMenu.clone();
		Arrays.sort(clonedMenu);
		Map<Integer, Integer> menuIndexMap = new HashMap<>();
		int itemA = 0;
		int itemB = 0;
		
		for(int i = 0; i < iceCreamMenu.length; i++) {
			menuIndexMap.put(iceCreamMenu[i], i);
		}
		
		System.out.println(Arrays.toString(clonedMenu));
		
		for(int i=0; i < clonedMenu.length; i++) {
			
			itemA = clonedMenu[i];
			int delta = totalMoney - clonedMenu[i];
			int deltaIndex = Arrays.binarySearch(clonedMenu, Math.min(i+1, clonedMenu.length - 1), clonedMenu.length, delta);
//			int deltaIndex = Arrays.binarySearch(clonedMenu, delta);
			System.out.println("Item A is: " + itemA + " delta is: " + delta + " deltaIndex is: " + deltaIndex);
			if(clonedMenu[deltaIndex] == delta) {
				itemB = delta;
				break;
			}
			
		}
		
		int indexItemA = menuIndexMap.get(itemA);
		int indexItemB = menuIndexMap.get(itemB);
		
		return new int[] {Math.min(indexItemA, indexItemB), Math.max(indexItemA, indexItemB)};
	}

}
