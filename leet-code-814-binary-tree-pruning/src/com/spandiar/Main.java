package com.spandiar;

import com.spandiar.Main.TreeNode;

public class Main {
	
	public static void main(String[] args) {
		
		TreeNode head = new TreeNode(1, new TreeNode(1, new TreeNode(1, new TreeNode(0), null), new TreeNode(1)),
							new TreeNode(0, new TreeNode(0), new TreeNode(1)));
		
		
		System.out.println("Before processing");
		printWithIntend(head, 10);
		
		boolean result = containsOne(head);
		if(!result) {
			head = null;
		}
		
		System.out.println("result is : " + result);
		
		System.out.println("After processing");
		printWithIntend(head, 10);

	}
	
	private static boolean containsOne(TreeNode node) {
		
		if(node == null) 
			return false;
		
		boolean leftContains = containsOne(node.left);
		boolean rightContains = containsOne(node.right);
		

		if(!leftContains) {
			node.left = null;
		}
		
		
		if(!rightContains) {
			node.right = null;
		}
		
		return (node.value == 1 || leftContains || rightContains);
		
	}

	private static void printWithIntend(TreeNode node, int depth) {
		
		if(node == null) return;
		
		printWithIntend(node.right, depth + 3);
		System.out.println(new String(new char[depth]).replace("\0", " ") + node.value);
		printWithIntend(node.left, depth + 3);
		
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

	
	
	
