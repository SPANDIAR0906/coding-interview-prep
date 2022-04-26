package com.spandiar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	static boolean skipRight;
	static int gymRight, gymLeft;
	static int schoolRight, schoolLeft;
	static int storelRight, storeLeft;

	public static void main(String[] args) {

		List<Location> blocks = new ArrayList<>();
		blocks.add(new Location(false, true, false));
		blocks.add(new Location(true, false, false));
		blocks.add(new Location(true, true, false));
		blocks.add(new Location(false, true, false));
		blocks.add(new Location(false, true, true));

		String[] request = new String[] {"gym", "school", "store"};

		int result = findBestLocation(blocks, request);

	}

	private static int findBestLocation(List<Location> blocks, String[] request) {

		Map<Integer, List<Integer>> score = new HashMap<>();
		getMapOfNearestLocations(blocks, request, score);

		return 0;
	}

	private static void getMapOfNearestLocations(List<Location> blocks, String[] request,
			Map<Integer, List<Integer>> score) {

		for (int i = 0; i < blocks.size(); i++) {

			int gym = 0;
			int school = 0;
			int store = 0;

			for (String locationType : request) {

				switch (locationType) {

				case "gym":
					gym = getNextNearestLocation(blocks, i, "gym", gym, school, store, false);
					break;

				case "school":
					school = getNextNearestLocation(blocks, i, "school", gym, school, store, false);
					break;

				case "store":
					store = getNextNearestLocation(blocks, i, "store", gym, school, store, false);
					break;

				}
			}

			score.put(i, List.of(gym, school, store));
		}

		System.out.println(score);
	}

	private static int getNextNearestLocation(List<Location> blocks, int currentIndex, String locationType, int gym,
			int school, int store, boolean skipRight) {

		if (currentIndex >= blocks.size() || currentIndex < 0) {
			return blocks.size();
		}

		Location currentLocation = blocks.get(currentIndex);

		switch (locationType) {
		
		case "gym":
			
			if (currentLocation.gym == true) {
				return gym;
			}

			if(!skipRight) {
				gymRight = getNextNearestLocation(blocks, currentIndex + 1, "gym", gym + 1, school, store, skipRight);
			}
			skipRight = true;
			gymLeft = getNextNearestLocation(blocks, currentIndex - 1, "gym", gym + 1, school, store, skipRight);
			return Math.min(gymRight, gymLeft);

		case "school":

			if (currentLocation.school == true) {
				return school;
			} else {
				if(!skipRight) {
					schoolRight = getNextNearestLocation(blocks, currentIndex + 1, "school", gym, school + 1, store, skipRight);
				}
				skipRight = true;
				schoolLeft = getNextNearestLocation(blocks, currentIndex - 1, "school", gym, school + 1, store, skipRight);
				return Math.min(schoolRight, schoolLeft);
			}

		case "store":

			if (currentLocation.store == true) {
				return store;
			} else {
				if(!skipRight) {
					storelRight = getNextNearestLocation(blocks, currentIndex + 1, "store", gym, school, store + 1, skipRight);
				}
				skipRight = true;
				storeLeft = getNextNearestLocation(blocks, currentIndex - 1, "store", gym, school, store + 1, skipRight);
				return Math.min(storelRight, storeLeft);
			}

		}

		return 0;
	}

}

class Location {

	boolean gym;
	boolean school;
	boolean store;

	public Location(boolean gym, boolean school, boolean store) {
		super();
		this.gym = gym;
		this.school = school;
		this.store = store;
	}

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

}
