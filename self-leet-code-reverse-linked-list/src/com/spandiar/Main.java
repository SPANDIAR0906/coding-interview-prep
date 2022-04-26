package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		LinkedList root = new LinkedList(1, 
											new LinkedList(2, 
											new LinkedList(3,
											new LinkedList(4,
											new LinkedList(5, null)))));
		
		reverseLinkedList(root);
		
		
	}

	private static LinkedList reverseLinkedList(LinkedList node) {
		
		System.out.println("Original Node is: " + node);
		
		if(node == null) {
			return node;
		}
		
		LinkedList reversed = null;
		
		while(node != null) {
			LinkedList next = node.next;
			node.next = reversed;
			reversed = node;
			node = next;
		}
		
		System.out.println("Reversed Node is: " + reversed);
		return node;
		
	}

}

class LinkedList {
	
	int value;
	LinkedList next;
	
	public LinkedList() {
		super();
	}

	public LinkedList(int value, LinkedList next) {
		super();
		this.value = value;
		this.next = next;
	}

	@Override
	public String toString() {
		return "LinkedList [value=" + value + ", next=" + next + "]";
	}
	
}
