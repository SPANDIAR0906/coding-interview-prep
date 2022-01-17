package com.spandiar;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

		int[] hand = { 1, 2, 3, 6, 2, 3, 4, 4, 5, 7, 8, 6, 7 };
		int groupSize = 3;

		boolean result = isNStraightHand(hand, groupSize);
		
		System.out.println("Final result is: " + result);

	}

	private static boolean isNStraightHand(int[] hand, int groupSize) {

		TreeMap<Integer, Integer> deck = new TreeMap<>();
		// Arrays.sort(hand);

		for (int card : hand) {
			if (!deck.containsKey(card)) {
				deck.put(card, 1);
			} else {
				deck.replace(card, deck.get(card) + 1);
			}
		}

		for (Entry<Integer, Integer> entry : deck.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}

		while (!deck.isEmpty()) {
			int key = deck.firstKey();
			for (int i = key; i < key + groupSize; i++) {
				if (deck.containsKey(i)) {
					if (deck.get(i) == 1) {
						deck.remove(i);
					} else {
						deck.replace(i, deck.get(i) - 1);
					}
				} else {
					return false;
				}
			}
		}

		return true;
	}

}
