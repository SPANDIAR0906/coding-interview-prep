package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree(1, 
								new BinaryTree(2, new BinaryTree(3), new BinaryTree(4)), 
								new BinaryTree(2, new BinaryTree(4), new BinaryTree(3)));
		
		printTreeWithIndent(tree, 10);
		
		boolean result = checkForSymmetry(tree);
		System.out.println("Result is: " + result);

	}

	private static boolean checkForSymmetry(BinaryTree tree) {
		
		BinaryTree clonedTree = new BinaryTree();
		clonedTree = tree;
		
		return checkForSymmetry(tree, clonedTree);
	}

	private static boolean checkForSymmetry(BinaryTree tree, BinaryTree clonedTree) {
		
		if(tree == null && clonedTree == null) {
			return true;
		}
		
		if(tree == null || clonedTree == null) {
			return false;
		}
		
		return ((tree.value == clonedTree.value) && 
					(checkForSymmetry(tree.left, clonedTree.right)) &&
					      (checkForSymmetry(tree.right, clonedTree.left)));
	}
	

	private static void printTreeWithIndent(BinaryTree tree, int depth) {
		
		if(tree == null) {
			return;
		}
		
		printTreeWithIndent(tree.right, depth+3);
		System.out.println(new String(new char[depth]).replace("\0", " ") + tree.value);
		printTreeWithIndent(tree.left, depth+3);
		
	}
	
}

class BinaryTree {
	
	int value;
	BinaryTree left, right;
	
	
	public BinaryTree(int value, BinaryTree left, BinaryTree right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public BinaryTree(int value) {
		super();
		this.value = value;
	}

	public BinaryTree() {
		super();
	}


	@Override
	public String toString() {
		return "BinaryTree [value=" + value + ", left=" + left + ", right=" + right + "]";
	}
	
}
