/*
 * Leet Code 112
 * 
 * Given the root of a binary tree and an integer targetSum, return true if the tree has 
 * a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 * 
 * */

package com.spandiar;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		int pathSum = 51;
		
		Node head = new Node(5, new Node(4, new Node(11, new Node(7), new Node(2)), null), 
					new Node(8, new Node(13, new Node(24), null), new Node(4, null, new Node(1))));
		
//		Node head = new Node();
		printWithIndent(head, 10);
//		boolean result = doesPathSumExist(head, pathSum);
		boolean result = doesPathSumExistAlternate(head, pathSum);
		
		System.out.println("Path Sum response is: " + result);
	}
	
	private static boolean doesPathSumExistAlternate(Node node, int pathSum) {
		
		if(node == null) {
			return false;
		}
		
		Stack<Node> nodeStack = new Stack<>();
		Stack<Integer> sumStack = new Stack<>();
		
		
		nodeStack.add(node);
		sumStack.add(pathSum);
		
		while(!nodeStack.isEmpty()) {
			
			Node currentNode = nodeStack.pop();

			int currentSum = sumStack.pop();
			currentSum = (currentSum - currentNode.value);
			
			System.out.println("Current Node: " + currentNode + " Current Sum: " + currentSum);
			
			if(currentNode.left == null && currentNode.right == null && currentSum == 0) {
				return true;
			} 
			
			if(currentNode.left != null) {
				nodeStack.add(currentNode.left);
				sumStack.add(currentSum);
			}
			
			if(currentNode.right != null) {
				nodeStack.add(currentNode.right);
				sumStack.add(currentSum);
			}
			
		}
		
		
		return false;
	}

	private static boolean doesPathSumExist(Node node, int sum){
		
		if(node == null) {
			return false;
		}
		
		sum = (sum - node.value);
		
		if(node.left == null && node.right == null) {
			return (sum == 0) ? true : false;
		}
		
		return (doesPathSumExist(node.left, sum) || doesPathSumExist(node.right, sum));
	}
	
	private static void printWithIndent(Node head, int depth) {
		
		if(head == null) return;
		printWithIndent(head.right, depth + 3);
		System.out.println(new String(new char[depth]).replace("\0", " ") + head.value);
		printWithIndent(head.left, depth + 3);
		
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
