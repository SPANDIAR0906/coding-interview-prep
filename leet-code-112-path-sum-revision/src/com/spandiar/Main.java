package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		int targetSum = 18;
		
		BinaryTree tree = new BinaryTree(5, 
				new BinaryTree(4, new BinaryTree(11, new BinaryTree(7), new BinaryTree(2))), 
				new BinaryTree(8, new BinaryTree(13), new BinaryTree(4, new BinaryTree(1)))
				);
		
		printTreeWithIndent(tree, 10);
		
		boolean result = hasPathSum(tree, targetSum);
		System.out.println("Result is: " + result);
	}

	private static boolean hasPathSum(BinaryTree node, int targetSum) {
		
		if(node == null) {
			return (targetSum == 0) ? true : false;
		}
		
		targetSum = (targetSum - node.value);

		return (hasPathSum(node.left, targetSum) || 
						 hasPathSum(node.right, targetSum));
	}

	private static void printTreeWithIndent(BinaryTree tree, int depth) {
		
		if(tree == null) {
			return;
		}
		
		printTreeWithIndent(tree.right, depth + 3);
		System.out.println(new String(new char[depth]).replace("\0", " ") + tree.value);
		printTreeWithIndent(tree.left, depth + 3);
		
	}

}

class BinaryTree {
	
	int value;
	BinaryTree left, right;
	
	public BinaryTree() {
		super();
	}

	public BinaryTree(int value) {
		super();
		this.value = value;
	}
	
	public BinaryTree(int value, BinaryTree left) {
		super();
		this.value = value;
		this.left = left;
	}
	
	public BinaryTree(int value, BinaryTree left, BinaryTree right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "BinaryTree [value=" + value + ", left=" + left + ", right=" + right + "]";
	}
	
}