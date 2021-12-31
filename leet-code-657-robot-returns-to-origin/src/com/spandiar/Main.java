package com.spandiar;

import java.awt.Point;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		String path = "RRURLLUUDDDDUL";
		
		boolean result = judgeIfBackToOrigin(path);
		System.out.println("Is robot in Origin: " + result);

	}

	private static boolean judgeIfBackToOrigin(String path) {
		
		String[] pathArray = path.split("");
		Point point = new Point(0, 0);
		
		for(int i=0; i< pathArray.length; i++) {
			
			switch(pathArray[i]) {
			
			case "R":
				point.setLocation(point.getX() + 1, point.getY());
				break;
			case "L":
				point.setLocation(point.getX() - 1, point.getY());
				break;
			case "U":
				point.setLocation(point.getX(), point.getY() + 1);
				break;
			case "D":
				point.setLocation(point.getX(), point.getY() - 1);
				break;
			
			}
		}
		
		System.out.println("Counter is: " + point);
		return (point.getX() == 0  && point.getY() == 0);
	}

}
