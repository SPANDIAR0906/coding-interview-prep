/*
 * Leet Code Problem 101
 * Check if a Binary Tree is symmetric
 * 
 * */
package com.spandiar;

import com.spandiar.Main.Node;

public class Main {

	public static void main(String[] args) {
		
		Node head = new Node(1,new Node(2, new Node(5), new Node(4, new Node(7), null)), new Node(2, new Node(4, null, new Node(7)), new Node(5)));
		printTreeWithIndend(head, 10);
		boolean result = isSymmetric(head);
		
		System.out.println("Result is: " + result);
	}
	
	private static boolean isSymmetric(Node head) {
		return isMirror(head, head);
	}

	private static boolean isMirror(Node head1, Node head2) {
		
		System.out.println("inside isMirror");
		
		if(head1 == null && head2 == null) return true;
		if(head1 == null || head2 == null) return false;
		
		System.out.println("Comparing values: " + head1.value + " - " +  head2.value);
		
		return (head1.value == head2.value) 
				&& isMirror(head1.left, head2.right) 
					&& isMirror(head1.right, head2.left);
	}

	private static void printTreeWithIndend(Node head, int depth) {
		
		if (head == null) return;
		
		printTreeWithIndend(head.right, depth + 3);
		System.out.println(new String(new char[depth]).replace("\0", " ") + head.value);
		printTreeWithIndend(head.left, depth + 3);
		
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
