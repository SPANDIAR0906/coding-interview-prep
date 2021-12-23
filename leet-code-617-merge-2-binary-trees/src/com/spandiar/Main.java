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
		
		Node bst1 = new Node(1, new Node(3, new Node(5, null, null), null), new Node(2, null, null));
		Node bst2 = new Node(2, new Node(1, null, new Node(4, null, null)), new Node(3, null, new Node(7, null, null)));
		
		System.out.println("Before merging");
		System.out.println("bst1 is: ");
		System.out.println();
		printTreeWithIndent(bst1, 10);
		System.out.println("bst2 is: ");
		System.out.println();
		printTreeWithIndent(bst2, 10);

		Node mergedTree = mergeTreesAlternate(new Node(), bst1, bst2);
//		mergeTrees(bst1, bst2);
		
		System.out.println("After merging");
		System.out.println(mergedTree);
		printTreeWithIndent(mergedTree, 10);
		
	}
	
	private static Node mergeTreesAlternate(Node bTree, Node bst1, Node bst2) {
		
		if(bst1 == null) {
			return bst2;
		}
		
		if(bst2 == null) {
			return bst1;
		}
		
		if(bTree == null) {
			bTree = new Node();
		}
		
		bTree.value = bst1.value + bst2.value;
		if(bst1.left != null || bst2.left != null) {
			bTree.left = mergeTreesAlternate(bTree.left, bst1.left, bst2.left);
		}
		
		if(bst1.right != null || bst2.right != null) {
			bTree.right = mergeTreesAlternate(bTree.right, bst1.right, bst2.right);
		}
		
		return bTree;

	}

	private static void printTreeWithIndent(Node node, int depth) {
		
		if(node == null) {
			return;
		}
		
		printTreeWithIndent(node.right, depth + 3);
		System.out.println(new String(new char[depth]).replace("\0", " ") + node.value);
		printTreeWithIndent(node.left, depth + 3);
		
	}
	

	private static Node mergeTrees(Node bst1, Node bst2) {
		
		if(bst1 == null) {
			return bst2;
		}
		
		if(bst2 == null) {
			return bst1;
		}
		
		bst1.value += bst2.value;
		bst1.left = mergeTrees(bst1.left, bst2.left);
		bst1.right = mergeTrees(bst1.right, bst2.right);
		
		return bst1;
		
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
