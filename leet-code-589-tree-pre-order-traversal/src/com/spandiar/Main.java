/*
 * Pre-Order Traversal of a Tree. Leet Code - 589
 * 
 * */
package com.spandiar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		TreeNode seven = new TreeNode(7, List.of(new TreeNode(11), new TreeNode(14)));
		TreeNode three = new TreeNode(3, List.of(new TreeNode(6), seven));
		TreeNode four = new TreeNode(4, List.of(new TreeNode(8), new TreeNode(12)));
		TreeNode nine = new TreeNode(9, List.of(new TreeNode(13)));
		TreeNode five = new TreeNode(5, List.of(nine, new TreeNode(10)));
		TreeNode head = new TreeNode(1, List.of(new TreeNode(2), three, four, five));

		System.out.println(head);

		preOrderTraversal(head);

	}




	private static List<Integer> preOrderTraversal(TreeNode node) {
		
		List<Integer> preOrder = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		if(node == null) {
			return preOrder;
		}
		
		stack.push(node);
		
		while(!stack.isEmpty()) {
			
			TreeNode currentNode = stack.pop();
			preOrder.add(currentNode.value);
			
			if(currentNode.children != null) {
				for(int i = (currentNode.children.size() - 1); i >= 0; i--) {
					stack.add(currentNode.children.get(i));
				}
			}
		}
		
		// Stack -> PreOrder is: [1, 5, 10, 9, 13, 4, 12, 8, 3, 7, 14, 11, 6, 2]
		// Queue -> PreOrder is: [1, 2, 3, 4, 5, 6, 7, 8, 12, 9, 10, 11, 14, 13]
		
		System.out.println("PreOrder is: " + preOrder);
		return preOrder;
		
	}


	public static class TreeNode {

		int value;
		List<TreeNode> children = new ArrayList<>();

		public TreeNode() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TreeNode(int value) {
			super();
			this.value = value;
		}

		public TreeNode(int value, List<TreeNode> children) {
			super();
			this.value = value;
			this.children = children;
		}

		@Override
		public String toString() {
			return "TreeNode [value=" + value + ", children=" + children + "]";
		}

	}

}
