/*
 * 
 * Leet Code - 590
 * 
 * */
package com.spandiar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Node head = new Node(1);

		Node three = new Node(3);
		three.setChildren(List.of(new Node(5), new Node(6)));
		head.setChildren(List.of(three, new Node(2), new Node(4)));

		System.out.println("Pre Order Traversal is: ");
//		preOrderTraversal(head);

		System.out.println("Post Order Traversal is: ");
//		postOrderTraversal(head);

		postOrderTraversalAlternateWithStack(head);
	}

	private static void preOrderTraversal(Node node) {

		if (node == null) {
			return;
		}

		if (node.children != null) {
			for (Node child : node.children) {
				preOrderTraversal(child);
			}
		}

	}

	private static void postOrderTraversal(Node node) {

		if (node == null) {
			return;
		}

		if (node.children != null) {
			for (Node child : node.children) {
				preOrderTraversal(child);
			}
		}
		System.out.println(node);

	}

	private static List<Integer> postOrderTraversalAlternateWithStack(Node node) {

		LinkedList<Integer> result = new LinkedList<>();
		Stack<Node> stack = new Stack<>();

		if (node == null) {
			return result;
		}

		stack.push(node);

		while (!stack.isEmpty()) {

			Node current = stack.pop();
			for (Node child : current.children) {
				stack.push(child);
			}
			result.addFirst(current.val);
		}

		System.out.println(result);
		return result;
	}

	public static class Node {

		int val;
		List<Node> children;

		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Node(int val) {
			super();
			this.val = val;
		}

		public Node(int val, List<Node> children) {
			super();
			this.val = val;
			this.children = children;
		}

		public Node(int val, Node child) {
			super();
			this.val = val;
			this.children.add(child);
		}

		public void setChildren(List<Node> children) {
			this.children = children;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + "]";
		}

	}

}
