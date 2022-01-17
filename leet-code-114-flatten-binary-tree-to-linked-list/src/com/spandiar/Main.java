package com.spandiar;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
				new TreeNode(5, null, new TreeNode(6)));

		printTreeWithIndent(head, 10);

		flattenToList(head);
		getRightSideView(head);
		miscellaneous();

		System.out.println("Reordered head is: " + head);
	}
	
	public static void miscellaneous() {
		
		String jewel = "aA";
		String stones = "aAABBAadde";
		int counter = 0;
		
		for(int i=0; i< stones.length(); i++) {
			System.out.println("char at " + i + " is " + stones.charAt(i));
			if(jewel.indexOf(stones.charAt(i)) >= 0) {
				counter++;
			}
		}
		
		System.out.println("Number od jewel stones is: " + counter);
	}

	private static List<Integer> getRightSideView(TreeNode head) {
		
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> rightSideTree = new ArrayList<>();
		stack.push(head);
		
		while(!stack.isEmpty()) {
			
			TreeNode currentNode = stack.pop();
			rightSideTree.add(currentNode.value);
			
			if(currentNode.right != null) {
				stack.push(currentNode.right);
			}
			
		}
		
		return rightSideTree;
		
	}

	private static void flattenToList(TreeNode head) {

		Stack<TreeNode> stack = new Stack<>();
		stack.add(head);
		
		while (!stack.isEmpty()) {

			TreeNode currentNode = stack.pop();

			if (currentNode.right != null) {
				stack.add(currentNode.right);
			}

			if (currentNode.left != null) {
				stack.add(currentNode.left);
			}
			
			if(!stack.isEmpty()) {
				currentNode.right = stack.peek();
			}
			
			currentNode.left = null;

		}

	}

	private static void printTreeWithIndent(TreeNode node, int depth) {

		if (node == null)
			return;

		printTreeWithIndent(node.right, depth + 3);
		System.out.println(new String(new char[depth]).replace("\0", " ") + node.value);
		printTreeWithIndent(node.left, depth + 3);

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
			return "TreeNode [value=" + value + ", left=" + left + ", right=" + right + "]";
		}

	}

}
