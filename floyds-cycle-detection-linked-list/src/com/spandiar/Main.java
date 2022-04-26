package com.spandiar;

import com.spandiar.Main.LinkedListNode;

public class Main {

	public static void main(String[] args) {
		
		LinkedListNode l4 = new LinkedListNode(4);
		LinkedListNode l3 = new LinkedListNode(5, l4);
		LinkedListNode l2 = new LinkedListNode(6, l3);
		LinkedListNode l1 = new LinkedListNode(7, l2);
		LinkedListNode root = new LinkedListNode(8, l1);
		
		l4.next = l1;

		boolean result = checkCircularReference(root);
		
		System.out.println("Has circular reference is: " + result);

	}
	

	private static boolean checkCircularReference(LinkedListNode root) {
		
		LinkedListNode slow = root;
		LinkedListNode fast = root;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			System.out.println("Slow is " + slow.value);
			System.out.println("Fast is " + fast.value);
			
			if(slow == fast) {
				System.out.println("Tortoise and Hare have met");
				return true;
			}
		}
		return false;
	}


	static class LinkedListNode {
		
		int value;
		LinkedListNode next;
		
		public LinkedListNode() {
			super();
		}
		
		public LinkedListNode(int value) {
			super();
			this.value = value;
		}

		public LinkedListNode(int value, LinkedListNode next) {
			super();
			this.value = value;
			this.next = next;
		}

		public void setNext(LinkedListNode next) {
			this.next = next;
		}
		
	}

}
