/*
 * Leet Code 617
 * My solution contains an alternate approach where the original tree is not mutated
 * I've created a new tree which sums the 2 given trees
 * 
 * */

package com.spandiar;

import com.spandiar.Main.Node;

public class Main {

	public static void main(String[] args) {
		
		Node tree1 = new Node(1, new Node(3, new Node(5, null, null), null), new Node(2, null, null));
		Node tree2 = new Node(2, new Node(1, null, new Node(4, null, null)), new Node(3, null, new Node(7, null, null)));
		
		System.out.println("Before merging");
		System.out.println("tree1 is: ");
		System.out.println();
		printTreeWithIndent(tree1, 10);
		System.out.println("tree2 is: ");
		System.out.println();
		printTreeWithIndent(tree2, 10);

		Node mergedTree = mergeTrees(tree1, tree2);
		
		System.out.println("After merging");
		printTreeWithIndent(mergedTree, 10);
		
	}
	

	private static Node mergeTrees(Node tree1, Node tree2) {
		
		if(tree1 == null) {
			return tree2;
		}
		
		if(tree2 == null) {
			return tree1;
		}
		
		Node mergedTree = new Node();
		return mergeTreeHelper(tree1, tree2, mergedTree);
	}


	private static Node mergeTreeHelper(Node tree1, Node tree2, Node mergedTree) {
		
		if(tree1 == null) {
			return tree2;
		}
		
		if(tree2 == null) {
			return tree1;
		}
		
		if(mergedTree == null) {
			mergedTree = new Node();
		}
		
		mergedTree.value = tree1.value + tree2.value;
		mergedTree.left = mergeTreeHelper(tree1.left, tree2.left, mergedTree.left);
		mergedTree.right = mergeTreeHelper(tree1.right, tree2.right, mergedTree.right);
		
		return mergedTree;
	}


	private static void printTreeWithIndent(Node node, int depth) {
		
		if(node == null) {
			return;
		}
		
		printTreeWithIndent(node.right, depth + 3);
		System.out.println(new String(new char[depth]).replace("\0", " ") + node.value);
		printTreeWithIndent(node.left, depth + 3);
		
	}
	




	public static class Node {

		int value;
		Node left, right;
		
		public Node() {
			super();
		}
		
		public Node(int value) {
			super();
			this.value = value;
		}

		public Node(int value, Node left, Node right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
		}

	}
}
