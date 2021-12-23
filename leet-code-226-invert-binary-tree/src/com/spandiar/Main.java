/*
 * Leet Code problem # 226 - Invert a Binary Tree
 * 
 * */
package com.spandiar;

import com.spandiar.Main.Node;

public class Main {

	public static void main(String[] args) {
		
		Node source = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(7, new Node(6), new Node(9)));
		System.out.println("Source Tree is: ");
		System.out.println();
		printTreeWithIndent(source, 10);
		
//		Node target = inverseTree(source, new Node());
		inverseTreeAlternate(source);
		System.out.println("Target Tree is: ");
		System.out.println();
		printTreeWithIndent(source, 10);
		
	}
	
	
	private static Node inverseTreeAlternate(Node source) {
		
		// this is the Nick White solution
		
		System.out.println("source is: " + source);
		
		if(source == null) {
			return source;
		}
		
		Node left = inverseTreeAlternate(source.left);
		System.out.println("left is: " + left);
		Node right = inverseTreeAlternate(source.right);
		System.out.println("right is: " + right);

		System.out.println("1st swap - source is: " + source + " right is: " + right + " left is: " + left);
		
		source.left = right;
		source.right = left;
		
		return source;
	}


	private static Node inverseTree(Node source, Node target) {
		
		// this is my solution
		
		if(source == null) {
			return null;
		}
		
		if(target == null) {
			target = new Node();
		}
		
		target.value = source.value;
		if(source.right != null) {
			target.left = inverseTree(source.right, target.left);
		}
		if(source.left != null) {
			target.right = inverseTree(source.left, target.right);
		}
		return target;
	}


	private static void printTreeWithIndent(Node source, int depth) {
		
		if(source == null) 
			return;
		
		printTreeWithIndent(source.right, depth + 3);
		System.out.println(new String(new char[depth]).replace("\0", " ") + source.value);
		printTreeWithIndent(source.left, depth + 3);
		
	}


	public static class Node {

		int value;
		Node left, right;
		
		public Node() {
			super();
		}
		
		public Node(int value) {
			super();
			this.value = value;
		}

		public Node(int value, Node left, Node right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [value=" + value  + "]";
		}

	}

}
