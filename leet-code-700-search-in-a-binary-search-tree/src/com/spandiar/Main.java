package com.spandiar;

public class Main {

	public static void main(String[] args) {

		TreeNode head = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
		printTreeWithIndent(head, 10);
		TreeNode result = searchBST(head, 7);
		System.out.println("After searching for value: ");
		printTreeWithIndent(result, 10);

	}
	
	

	private static TreeNode searchBST(TreeNode node, int searchVal) {
		
		if (node == null) return null;
		
		if(node.value == searchVal) {
			return node;
		} else if(node.value > searchVal){
			node = searchBST(node.left, searchVal);
		}  else if(node.value < searchVal){
			node = searchBST(node.right, searchVal);
		}  
		
		return node;
	}



	private static void printTreeWithIndent(TreeNode node, int depth) {
		
		if(node == null) return;
		
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
			return "TreeNode [value=" + value + "]";
		}

	}

}
