package com.spandiar;

public class Main {

	public static void main(String[] args) {

		int[][] island = new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };

		int perimeter = findPerimeter(island);
		System.out.println("Perimeter is: " + perimeter);

	}

	private static int findPerimeter(int[][] island) {

		int perimeter = 0;

		for (int i = 0; i < island.length; i++) {
			for (int j = 0; j < island[i].length; j++) {
				if (island[i][j] == 1) {
					perimeter += 4;

					if (hasLeftPlot(island, i, j)) {
						perimeter -= 2;
					}

					if (hasPlotAbove(island, i, j)) {
						perimeter -= 2;
					}
				}
			}
		}

		return perimeter;
	}

	private static boolean hasPlotAbove(int[][] island, int i, int j) {

		if (i - 1 >= 0) {
			return (island[i - 1][j] == 1) ? true : false;
		}

		return false;
	}

	private static boolean hasLeftPlot(int[][] island, int i, int j) {

		if (j - 1 >= 0) {
			return (island[i][j - 1] == 1) ? true : false;
		}

		return false;
	}

}
