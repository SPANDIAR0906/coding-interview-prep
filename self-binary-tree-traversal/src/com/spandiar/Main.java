package com.spandiar;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		BinaryTree head = new BinaryTree(1, 
				new BinaryTree(2, new BinaryTree(4), new BinaryTree(5)), 
				new BinaryTree(3, new BinaryTree(6), new BinaryTree(7)));
		
		List<BinaryTree> preOrder = new ArrayList<>();
		List<BinaryTree> postOrder = new ArrayList<>();
		List<BinaryTree> inOrder = new ArrayList<>();
		
		printTreeWithIndent(head, 10);

		preOrderTraversal(head, preOrder);
		System.out.println("PreOrder is: " + preOrder);
		
		postOrderTraversal(head, postOrder);
		System.out.println("PostOrder is: " + postOrder);

		inOrderTraversal(head, inOrder);
		System.out.println("InOrder is: " + inOrder);


	}

	private static void preOrderTraversal(BinaryTree node, List preOrderList) {
		
		if(node == null) {
			return;
		}
		
		preOrderList.add(node.value);
		preOrderTraversal(node.left, preOrderList);
		preOrderTraversal(node.right, preOrderList);
		
	}
	
	private static void postOrderTraversal(BinaryTree node, List postOrderList) {
		
		if(node == null) {
			return;
		}
		
		postOrderTraversal(node.left, postOrderList);
		postOrderTraversal(node.right, postOrderList);
		postOrderList.add(node.value);
		
	}
	
	private static void inOrderTraversal(BinaryTree node, List inOrderList) {
		
		if(node == null) {
			return;
		}
		
		inOrderTraversal(node.left, inOrderList);
		inOrderList.add(node.value);
		inOrderTraversal(node.right, inOrderList);
		
	}

	private static void printTreeWithIndent(BinaryTree node, int depth) {
		
		if(node == null) {
			return;
		}
		
		printTreeWithIndent(node.right, depth + 3);
		System.out.println(new String(new char[depth]).replace("\0", " ") + node.value);
		printTreeWithIndent(node.left, depth + 3);
		
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
	
	public BinaryTree(int value, BinaryTree left, BinaryTree right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	
}