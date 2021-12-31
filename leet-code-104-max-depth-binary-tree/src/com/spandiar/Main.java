/*
 * Leet Code # 104
 * Challenging for me. Check the solution.
 * */
package com.spandiar;

import com.spandiar.Main.Node;

public class Main {

	public static void main(String[] args) {
		
		int maxDepth = 0;
		Node head = new Node(3, new Node(9), new Node(20, new Node(15, new Node(12), null), new Node(7)));
		maxDepth = traverseTree(head);
		
		System.out.println("Max depth is: " + maxDepth);

	}
	
	
	private static int traverseTree(Node node) {
		
		if(node == null) {
			return 0;
		}
		
		int leftDepth = traverseTree(node.left);
		int rightDepth = traverseTree(node.right);

		System.out.println("Node is: " + node.value);
		System.out.println("Depth is: " + Math.max(leftDepth, rightDepth));
		
		return Math.max(leftDepth, rightDepth) + 1;
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
