/*
 * 
 * Leet Code 94 - Spent almost 4 hrs on this. Debug this to see how this works
 * 
 * */

package com.spandiar;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Node two = new Node(2, new Node(4), new Node(5));
		Node three = new Node(3, new Node(6), null);
		Node head = new Node(1, two, three);
		
		System.out.println("Result using recursion");
		inOrderTraversalResursion(head);
		
		System.out.println("Result using stacks");
		inOrderTraversalAlternate(head);

	}
	
	private static List<Integer> inOrderTraversalAlternate(Node node) {
		
		List<Integer> result = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		
		if(node == null) {
			return result;
		}
		
		while(!stack.isEmpty() || node != null) {
			
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
			
			node = stack.pop();
			result.add(node.val);
			node = node.right;
		}
		
		System.out.println(result);
		return result;
		
	}

	private static List<Integer> inOrderTraversalResursion(Node node) {
		
		List<Integer> result = new LinkedList<>();
		
		if(node == null) {
			return result;
		}
		
		inOrderHelper(node, result);
		System.out.println(result);
		return result;
	}
	
	private static void inOrderHelper(Node node, List<Integer> result){
		
		if(node != null) {
			inOrderHelper(node.left, result);
			result.add(node.val);
			inOrderHelper(node.right, result);
		}
	}

	public static class Node {
		
		int val;
		Node left, right;
		
		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Node(int val) {
			super();
			this.val = val;
		}

		public Node(int val, Node left, Node right) {
			super();
			this.val = val;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
		
	}
	

}
