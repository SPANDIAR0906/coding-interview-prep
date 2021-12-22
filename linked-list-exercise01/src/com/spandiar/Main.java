package com.spandiar;

/* 
 * 
 * Program to find the nth element from the end of a linked list
 * Solution - instantiate 2 nodes - left and right and point them to the head
 * move the right till the index from the end to search
 * then move both the left and right till right reaches null
 * 
 * */

public class Main {

	public static void main(String[] args) {
		
		Node HEAD = initialize();
		Node specificElement = getElementFromEnd(HEAD, 5);

		if(specificElement == null) {
			System.out.println("null");
		}
		else {
			System.out.println(specificElement.toString());
		}
	}


	private static Node getElementFromEnd(Node HEAD, int index) {

		Node left = HEAD;
		Node right = HEAD;

		if (right == null) return null;

		for(int i=0; i<index; i++) {
			right = right.getNext();
			if(right == null) return null;
		}

		while(!(right == null)) {
			System.out.println("Inside the while loop: " + right.toString());
			left = left.getNext();
			right = right.getNext();
		}

		return left;
	}

	private static Node initialize() {

		Node HEAD = new Node(5);

		Node child1 = new Node(4);
		HEAD.setNext(child1);

		Node child2 = new Node(3);
		child1.setNext(child2);

		Node child3 = new Node(2);
		child2.setNext(child3);

		Node child4 = new Node(1);
		child3.setNext(child4);

		Node child5 = new Node(0);
		child4.setNext(child5);

		return HEAD;
	}

	public static class Node {

		static int LENGTH=0;
		private int value;
		private Node next;

		public Node(int value) {
			super();
			this.value = value;
			if(Node.LENGTH == 0) {
				Node.LENGTH++; 
			}
		}

		public int getValue() {
			return value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
			Node.LENGTH++;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}

	}

}
