package com.spandiar;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(6), new TreeNode(8)), new TreeNode(3, new TreeNode(5), new TreeNode(10)));
		printTree(head, 10);
		
		findMaxValPerLevel(head);
		

	}
	
	private static void findMaxValPerLevel(TreeNode node) {
		
		int level = 0;
		List<Integer> maxValPerLevel = new ArrayList<>();
		traverseLevels(node, maxValPerLevel, level);
		System.out.println(maxValPerLevel);
		
	}
	
	private static void traverseLevels(TreeNode node, List<Integer> maxValPerLevel, int level) {
		
		if(node == null) 
			return;
		
		if(maxValPerLevel.size() == level) {
			maxValPerLevel.add(node.value);
		} else {
			maxValPerLevel.set(level, Math.max(maxValPerLevel.get(level), node.value));
		}
		
		traverseLevels(node.left, maxValPerLevel, level+1);
		traverseLevels(node.right, maxValPerLevel, level+1);
		
	}

	public static void printTree(TreeNode node, int margin) {
		
		if(node == null) return;
		
		printTree(node.right, margin + 3);
		System.out.println(new String(new char[margin]).replace("\0", " ") + node.value);
		printTree(node.left, margin + 3);

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
