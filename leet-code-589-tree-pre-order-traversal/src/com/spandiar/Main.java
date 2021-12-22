/*
 * Pre-Order Traversal of a Tree. Leet Code - 589
 * 
 * */
package com.spandiar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		TreeNode seven = new TreeNode(7, List.of(new TreeNode(11), new TreeNode(14)));
		TreeNode three = new TreeNode(3, List.of(new TreeNode(6), seven));
		TreeNode four = new TreeNode(4, List.of(new TreeNode(8), new TreeNode(12)));
		TreeNode nine = new TreeNode(9, List.of(new TreeNode(13)));
		TreeNode five = new TreeNode(5, List.of(nine, new TreeNode(10)));
		TreeNode head = new TreeNode(1, List.of(new TreeNode(2), three, four, five));

		System.out.println(head);

//		preOrderTraversal(head);

		preOrderTraversalAlternate(head);

	}

	private static List<Integer> preOrderTraversalAlternate(TreeNode node) {

		List<Integer> result = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();

		if (node == null) {
			return result;
		}

		stack.add(node);

		while (!stack.isEmpty()) {

			node = stack.poll();
			result.add(node.value);

			if (node.children != null) {
//				Collections.reverse(node.children);
				for (int i = (node.children.size() - 1); i>= 0; i--) {
					stack.addFirst(node.children.get(i));
				}
			}
		}
		System.out.println(result);
		return result;
	}

	private static List<Integer> preOrderTraversal(TreeNode node) {

		List<Integer> result = new ArrayList<>();

		preOrderTraversalHelper(node, result);

		System.out.println(result);
		return result;
	}

	private static void preOrderTraversalHelper(TreeNode node, List<Integer> result) {
		if (node != null) {
			result.add(node.value);
			if (node.children != null) {
				for (TreeNode child : node.children) {
					preOrderTraversalHelper(child, result);
				}
			}
		}
	}

	public static class TreeNode {

		int value;
		List<TreeNode> children;

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
