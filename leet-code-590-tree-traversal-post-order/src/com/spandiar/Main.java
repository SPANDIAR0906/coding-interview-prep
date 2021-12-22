/*
 * 
 * Leet Code - 590
 * 
 * */
package com.spandiar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Node head = new Node(1);
		
		Node three = new Node(3);
		three.setChildren(List.of(new Node(5), new Node(6)));
		head.setChildren( List.of(three, new Node(2), new Node(4)));
		
//		System.out.println("Pre Order Traversal is: ");
//		preOrderTraversal(head);
		
		System.out.println("Post Order Traversal is: ");

//		postOrderTraversal(head);
		postOrderTraversalAlternateWithStack(head);
		
	}
	
	private static void preOrderTraversal(Node node) {
		
		if(node != null && node.children != null) {
			
			System.out.println(node.val);

			Node next = null;
			Iterator<Node> iterator = node.children.iterator();
			
			while(iterator.hasNext()) {
				next = iterator.next();
				preOrderTraversal(next);
			}
			
		} else {
			System.out.println(node.val);
		}
		
	
		
	}
	
	private static void postOrderTraversal(Node node) {
		
		if(node.children != null) {
			
			Node next = null;
			Iterator<Node> iterator = node.children.iterator();
			
			while(iterator.hasNext()) {
				next = iterator.next();
				postOrderTraversal(next);
			}
			System.out.println(node.val);
			
		} else {
			System.out.println(node.val);
		}
		
	}
	
	
	private static List<Integer> postOrderTraversalAlternateWithStack(Node node) {
		
		LinkedList<Integer> result = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		
		if (node == null) return result;
		
		stack.add(node);
		
		while(!stack.isEmpty()) {
			
			Node next = stack.pop();
			result.addFirst(next.val);
			if(next.children != null) {
				for(Node child: next.children) {
					stack.add(child);
				}
			}
			
		}
		System.out.println(result);
		return result;
	}
	
	public static class Node{
		
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
