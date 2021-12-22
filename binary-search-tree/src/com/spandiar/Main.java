package com.spandiar;
/*
 * 
 * Program to find if a Binary Tree is a Binary Search Tree
 * BST will have all elements on the left as lower than all elements on top of it till the head
 * Similarly on the right too, all elements will be greater than the elements on top till the head
 * 
 *        0
 *    1       2         => this is not a binary tree, as left of 0 has bigger items to 0
 *  3   4   5   6
 * 
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

	static final int COUNT = 3;

	public static void main(String[] args) {
		
		boolean isBST;
		boolean isPathFound = false;  
		List<Node> path = new ArrayList<>();

		Node head = addItem(null, 5, "e");
		addItem(head, 3, "c");
		addItem(head, 7, "g");
		addItem(head, 4, "d");
		addItem(head, 2, "b");
		addItem(head, 9, "i");
		addItem(head, 6, "f");
		addItem(head, 1, "a");
		addItem(head, 8, "h");

		
		insertItemRight(head.min(), 18, "Out of Place");
		printElement(head, 3);
		
		System.out.println("\n\n\n");
		
		isBST = isBST(head, null, null);
		System.out.println("Result of BST check is: " + isBST);
		
		isPathFound = findPath(head, 8, isPathFound, path);
		System.out.println("Path is: " + path);
		isPathFound = findPath(head, 4, isPathFound, path);
		System.out.println("Path is: " + path);
		
		Node result = findLeastCommonAncestor(head, 6, 8);
		System.out.println("Leasr Common Ancestor is: " + result);
		

	}

	private static Node addItem(Node node, int key, String value) {

		if (node == null) {
			node = new Node(key, value, null, null);
		} else if (key > node.key) {
			node.right = addItem(node.right, key, value);
		} else if (key < node.key) {
			node.left = addItem(node.left, key, value);
		}

		return node;
	}

	private static Node removeItem(Node node, int key) {

		if (node == null) {
			return node;
		} else if (key < node.key) {
			node.left = removeItem(node.left, key);
		} else if (key > node.key) {
			node.right = removeItem(node.right, key);
		} else {
			// Found the Key
			if (node.left == null && node.right == null) {
				node = null;
				return node;
			} else if (node.left == null || node.right == null) {
				if (node.left == null) {
					// copy the elements in the right
					node = node.right;
//					node.right = null;
				} else {
					// copy the elements in the left
					node = node.left;
//					node.left = null;
				}
			} else {
				// there are 2 children to this node
				// rotate before deleting the node
				Node minNode = node.right.min();
				node.key = minNode.key;
				node.value = minNode.value;
				node.right = removeItem(node.right, minNode.key);
			}
		}
		return node;
	}

	private static Node insertItemRight(Node node, int key, String value) {

		if (node == null) {
			return null;
		} else if (node.right == null) {
			node.right = new Node(key, value, null, null);
		}

		return node;
	}

	private static boolean isBST(Node node, Integer lowerLimit, Integer upperLimit) {
		
//		System.out.println("Checking Node " + node + " lowerLimit is: " + lowerLimit + " upperLimit is " + upperLimit);
		
		if(lowerLimit != null && node.key < lowerLimit) return false;
		if(upperLimit != null && node.key > upperLimit) return false;
		
		boolean isLeftBst = true;
		boolean isRightBst = true;
		Integer levelUpUpperLimit = upperLimit;

		if(node.left != null) {
			upperLimit = node.key;
			isLeftBst = isBST(node.left, lowerLimit, upperLimit);
		}
		
//		System.out.println("Node when transitioning to right: " + node);
		// reset upper limit
		
		if(isLeftBst && node.right != null) {
			lowerLimit = node.key;
			isRightBst = isBST(node.right, lowerLimit, levelUpUpperLimit);
		}
		
//		System.out.println("Before return " + node + " - isLeftBst: " +  isLeftBst + " isRightBst " + isRightBst);
		
		return isLeftBst && isRightBst;
	}
	
	private static Node findLeastCommonAncestor(Node node, int key1, int key2) {
		
		boolean isPathFound1 = false;  
		boolean isPathFound2 = false;
		List<Node> path1 = new ArrayList<>();
		List<Node> path2 = new ArrayList<>();
		Node result = null;
		
		isPathFound1 = findPath(node, key1, isPathFound1, path1);
		isPathFound2 = findPath(node, key2, isPathFound2, path2);

		System.out.println(path1);
		System.out.println(path2);
		
		
		Optional<Node> findFirst = path1.stream()
						.filter(path1Node -> path2.contains(path1Node))
							.findFirst();
		
		if(findFirst.isPresent()) {
			return findFirst.get();
		}
		
		return result;
	}
	
	private static boolean findPath(Node node, int key, boolean isPathFound, List<Node> path) {
		
		if (node.key == key) {
			path.add(node);
			return true;
		}
		
		if(node.left != null && !isPathFound) {
			isPathFound = findPath(node.left, key, isPathFound, path);
		}
		
		if(node.right != null && !isPathFound) {
			isPathFound = findPath(node.right, key, isPathFound, path);
		} 
		
		if(isPathFound) {
			path.add(node);
		}
		
		return isPathFound;
	}

	private static void printElement(Node node, int space) {

		space += COUNT;

		if (node != null) {
			printElement(node.right, space);
			System.out.println(new String(new char[space]).replace("\0", " ") + node.key + " - " + node.value
					+ new String(new char[space]).replace("\0", "`"));
			printElement(node.left, space);
		}

	}

	public static class Node {

		int key;
		String value;
		Node left;
		Node right;

		public Node(int key, String value, Node left, Node right) {
			super();
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}
		

		public int getKey() {
			return key;
		}

		public Node min() {
			if (left == null) {
				return this;
			} else {
				return left.min();
			}
		}

		@Override
		public String toString() {
//			return "Node [key=" + key + ", value=" + value + ", left=" + left + ", right=" + right + "]";
			return "Node [key=" + key + ", value=" + value + "]";

		}

	}

}
