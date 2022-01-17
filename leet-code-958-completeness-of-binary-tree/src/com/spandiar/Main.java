package com.spandiar;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		
		TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, null, new TreeNode(6)));
		
		boolean result = isCompleteTree(head);
		System.out.println("Result is: " + result);

	}
	
	private static boolean isCompleteTree(TreeNode node) {
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		boolean hasNullNode = false;
		
		while(!queue.isEmpty()) {
			
			TreeNode currentNode = queue.poll();
			
			if(currentNode == null) {
				hasNullNode = true;
			} else {
				if(hasNullNode) return false;
				queue.offer(currentNode.left);
				queue.offer(currentNode.right);
			}

		}
		
		return true;
		
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
