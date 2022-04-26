/*
 * 
 * Leet Code 94 - Spent almost 4 hrs on this. Debug this to see how this works
 * 
 * */

package com.spandiar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.spandiar.Main.Node;

public class Main {

	public static void main(String[] args) {

		Node two = new Node(2, new Node(4), new Node(5));
		Node three = new Node(3, new Node(6), null);
		Node head = new Node(1, two, three);

		printTree(head, 5);
		List<Integer> preOrder = preOrderTraversal(head);
		List<Integer> postOrder = postOrderTraversal(head);
		List<Integer> inOrder = inOrderTraversal(head);

	}

	private static List<Integer> inOrderTraversal(Node node) {
		
		List<Integer> inOrder = new ArrayList<>();
		
		if(node == null) {
			return inOrder;
		}
		
		inOrderHelper(node, inOrder);
		System.out.println("In-Order is: " + inOrder);
		return inOrder;
	}

	private static void inOrderHelper(Node node, List<Integer> inOrder) {
		
		if(node == null) {
			return;
		}
		
		inOrderHelper(node.left, inOrder);
		inOrder.add(node.val);
		inOrderHelper(node.right, inOrder);
		
	}

	private static List<Integer> preOrderTraversal(Node node) {

		List<Integer> preOrder = new ArrayList<>();
		Stack<Node> stack = new Stack<>();

		if (node == null) {
			return preOrder;
		}

		stack.push(node);

		while (!stack.isEmpty()) {

			Node current = stack.pop();
			preOrder.add(current.val);

			if (current.right != null) {
				stack.push(current.right);
			}

			if (current.left != null) {
				stack.push(current.left);
			}

		}

		System.out.println("Preorder is: " + preOrder);
		return preOrder;
	}

	private static List<Integer> postOrderTraversal(Node node) {

		List<Integer> postOrder = new ArrayList<>();
		
		if(node == null) {
			return postOrder;
		}

		postOrderHelper(node, postOrder);
		System.out.println("Post Order is: " + postOrder);
		return postOrder;

	}

	private static void postOrderHelper(Node node, List<Integer> postOrder) {
		
		if(node == null) {
			return;
		}
		
		postOrderHelper(node.left, postOrder);
		postOrderHelper(node.right, postOrder);
		postOrder.add(node.val);
	}

	private static void printTree(Node node, int margin) {

		if (node == null) {
			return;
		}

		printTree(node.right, margin + 3);
		System.out.println(new String(new char[margin]).replace("", " ") + node.val);
		printTree(node.left, margin + 3);

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
