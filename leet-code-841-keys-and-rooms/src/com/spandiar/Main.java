/*
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
 * Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 * When you visit a room, you may find a set of distinct keys in it. 
 * Each key has a number on it, denoting which room it unlocks, and you can take all of 
 * them with you to unlock the other rooms.
 * 
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you 
 * visited room i, return true if you can visit all the rooms, or false otherwise.
 * 
 * */
package com.spandiar;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		List<List<Integer>> source = new ArrayList<>();
		source.add(List.of(6,7,8));
		source.add(List.of(5,4,9));
		source.add(List.of());
		source.add(List.of(8));
		source.add(List.of(4));
		source.add(List.of());
		source.add(List.of(1,9,2,3));
		source.add(List.of(7));
		source.add(List.of(6,5));
		source.add(List.of(2,3,1));
		
		
		
		boolean result = canOpenAllRooms(source);
		System.out.println("Result is: " + result);

	}

	private static boolean canOpenAllRooms(List<List<Integer>> source) {
		
		boolean[] visited = new boolean[source.size()];
		Stack<Integer> availableKeys = new Stack<>();
		int currentKey = 0;
		
		availableKeys.push(currentKey);
		visited[currentKey] = true;
		
		while(!availableKeys.isEmpty()) {
			
			currentKey = availableKeys.pop();
			
			for(int newKey : source.get(currentKey)) {
				if(!visited[newKey]) {
					visited[newKey] = true;
					availableKeys.push(newKey);
				}
			}
		}
		
		for(boolean visitedAll : visited) {
			if(!visitedAll) {
				return false;
			}
		}
		
		return true;
		
	}

}
