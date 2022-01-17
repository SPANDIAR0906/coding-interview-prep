package com.spandiar;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		
		
		TreeNode head = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
		printWithIndent(head, 10);
		int sum = rangeSumBST(head, 7, 15);
		
		System.out.println("Result is: " + sum);

	}
	
	

	private static int rangeSumBST(TreeNode node, int min, int max) {
		
		if(node == null) return 0;
		int sum = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			node = queue.poll();
			
			if((node.value >= min) && (node.value <= max)) {
				sum += node.value;
			}
			
			if(node.left != null) {
				queue.add(node.left);
			}
			
			if(node.right != null) {
				queue.add(node.right);
			}
			
		}
		
		return sum;
	}



	private static void printWithIndent(TreeNode node, int depth) {
		
		if (node == null) return;
		
		printWithIndent(node.right, depth + 3);
		System.out.println(new String(new char[depth]).replace("\0", " ") + node.value);
		printWithIndent(node.left, depth + 3);

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
