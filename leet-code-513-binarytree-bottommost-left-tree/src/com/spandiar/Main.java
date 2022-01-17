package com.spandiar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		TreeNode head = new TreeNode(1, new TreeNode (2, new TreeNode(6, new TreeNode(8), null), new TreeNode(7)), new TreeNode (3, new TreeNode(4, new TreeNode(5, new TreeNode(9), new TreeNode(10)), null), null));
		printWithIndent(head, 10, 0);
//		int value = findBottomLeftValue(head);
//		System.out.println("value is: " + value);
//		System.out.println("head is: " + head);
		System.out.println("Breath first...");
		breathFirstPrint(head);
		System.out.println("Depth first...");
		depthFirstPrint(head);

	}
	
	private static void breathFirstPrint(TreeNode node) {
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(node); 
		
		while(!queue.isEmpty()) {
			
			node = queue.poll();
			System.out.println("node is: " + node.value);
			
			if(node.left != null) {
				queue.add(node.left);
			}
			
			if(node.right != null) {
				queue.add(node.right);
			}
			
		}
		
	}

	private static void depthFirstPrint(TreeNode node) {
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(node);
		
		while(!stack.isEmpty()) {
			
			node = stack.pop();
			System.out.println("node is: " + node.value);
			
			if(node.left != null) {
				stack.push(node.left);
			}
			
			if(node.right != null) {
				stack.push(node.right);
			}
			
		}
		
	}

	private static int findBottomLeftValue(TreeNode node) {
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			node = queue.poll();
			System.out.println("Popped : " + node.value);
			
			if(node.left != null) {
				queue.add(node.left);
			}
			
			if(node.right != null) {
				queue.add(node.right);
			}
		
		}
		
		return node.value;
	}

	private static void printWithIndent(TreeNode node, int depth, int level) {
		
		if(node == null) return;
		
		printWithIndent(node.right, depth+3, level+1);
		System.out.println(new String(new char[depth]).replace("\0", " ") + node.value);
		printWithIndent(node.left, depth+3, level+1);
		
	}

	public static class TreeNode {
		
		int value;
		TreeNode left;
		TreeNode right;
		
		
		public TreeNode() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TreeNode(int value) {
			super();
			this.value = value;
		}
		
		public TreeNode(int value, TreeNode left, TreeNode right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "TreeNode [value=" + value + "]";
		}
		
	}

}
