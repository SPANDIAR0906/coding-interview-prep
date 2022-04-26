package com.spandiar;

// inverting a binary tree - leetcode - 226

public class Main {

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree(4, new BinaryTree(2, new BinaryTree(1), new BinaryTree(3)), 
											new BinaryTree(7, new BinaryTree(6, new BinaryTree(8)), new BinaryTree(9)));
		
		System.out.println("Before inverting...");
		printWithIndent(tree, 10);
		
		System.out.println("After inverting...");
//		BinaryTree invertedTree = invertTree(tree, new BinaryTree());
//		BinaryTree invertedTree = invertTreeAlternate(tree);
//		printWithIndent(invertedTree, 10);
		
		int depth = findDepthOfTree(tree);
		System.out.println("Depth of tree is: " + depth);

	}

	private static int findDepthOfTree(BinaryTree tree) {
		
		return findDepthHelper(tree);
	}

	private static int findDepthHelper(BinaryTree node) {
		
		if(node == null) {
			return 0;
		}
		
		int leftDepth = findDepthHelper(node.left);
		int rightDepth = findDepthHelper(node.right);
		
		return Math.max(leftDepth, rightDepth) + 1;
	}

	private static BinaryTree invertTree(BinaryTree tree, BinaryTree invertedTree) {
		
		if(tree == null) {
			return invertedTree;
		}
		
		if(invertedTree == null) {
			invertedTree = new BinaryTree();
		}
		
		invertedTree.left = invertTree(tree.right, invertedTree.left);
		invertedTree.right = invertTree(tree.left, invertedTree.right);
		invertedTree.value = tree.value;
		
		return invertedTree;
	}
	
	private static BinaryTree invertTreeAlternate(BinaryTree tree) {
		
		if(tree == null) {
			return tree;
		}
		
		BinaryTree left = invertTreeAlternate(tree.left);
		BinaryTree right = invertTreeAlternate(tree.right);
		
		tree.left = right;
		tree.right = left;
		
		return tree;
	}

	private static void printWithIndent(BinaryTree tree, int depth) {
		
		if(tree == null) {
			return;
		}
		
		printWithIndent(tree.right, depth+3);
		System.out.println(new String(new char[depth]).replace("\0", " ") + tree.value);
		printWithIndent(tree.left, depth+3);
		
	}
	
}

class BinaryTree {
	
	int value;
	BinaryTree left;
	BinaryTree right;
	
	
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
