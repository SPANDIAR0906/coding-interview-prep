package com.spandiar;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {

//		TreeNode head = new TreeNode(3, new TreeNode(9, null, new TreeNode(4)), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		TreeNode head = new TreeNode(-9, new TreeNode(-3, null, new TreeNode(4, new TreeNode(-6), null)), new TreeNode(2, new TreeNode(4, new TreeNode(-5), null), new TreeNode(0)));

		
		int sumOfLeft = sumOfLeftLeaves(head);
		System.out.println("Result is: " + sumOfLeft);

	}

	private static int sumOfLeftLeaves(TreeNode node) {
		
		if(node == null) return 0;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		int sumOfLeftLeaves = 0;

		while(!queue.isEmpty()) {
			
			TreeNode currentNode = queue.poll();
			
			if(currentNode.left != null && 
					currentNode.left.left == null && 
						currentNode.left.right == null) {
				sumOfLeftLeaves += currentNode.left.value;
			} 
			
			if(currentNode.left != null) {
				queue.offer(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.offer(currentNode.right);
			}
			
		}
		
		return sumOfLeftLeaves;
		
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
