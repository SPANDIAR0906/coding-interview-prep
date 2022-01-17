package com.spandiar;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
//		int[][] source = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int[][] source = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printSpiral(source);
	}

	private static List<Integer> printSpiral(int[][] source) {
		
		List<Integer> result = new ArrayList<>();
		
		int beginRow = 0;
		int beginCol = 0;
		int endRow = source.length - 1;
		int endCol = source[0].length - 1;
		
		
		while(beginRow <= endRow && beginCol <= endCol) {
			
			for(int i=beginCol; i <= endCol; i++) {
				result.add(source[beginRow][i]);
			}
			
			beginRow++;
			
			for(int i = beginRow; i <= endRow; i++) {
				result.add(source[i][endCol]);
			}
			
			endCol--;
			
			for(int i=endCol; i>=beginCol; i--) {
				result.add(source[endRow][i]);
			}
			
			endRow --;
			
			for(int i = endRow; i >= beginRow; i--) {
				result.add(source[i][beginCol]);
			}
			
			beginCol++;
		}
		
		System.out.println(result);
		return result;
	}

}
