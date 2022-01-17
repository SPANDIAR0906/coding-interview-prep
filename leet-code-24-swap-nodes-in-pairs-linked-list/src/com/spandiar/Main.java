package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
		
		System.out.println(head);
		
		ListNode swappedHead = swapPairs(head);
		
		System.out.println(swappedHead);

	}
	
	private static ListNode swapPairs(ListNode node) {
		
		ListNode tempNode = new ListNode(0);
		tempNode.next = node;
		
		ListNode currentNode = tempNode;
		
		while(currentNode.next != null && currentNode.next.next != null) {
			
			ListNode firstNode = currentNode.next;
			ListNode secondNode = currentNode.next.next;
			firstNode.next = secondNode.next;
			currentNode.next = secondNode;
			currentNode.next.next = firstNode;
			currentNode = currentNode.next.next;
		}
		
		return tempNode.next;
		
	}


	public static class ListNode {
		
		int value;
		ListNode next;
		
		public ListNode() {
			super();
		}
		
		public ListNode(int value) {
			super();
			this.value = value;
		}
		
		public ListNode(int value, ListNode next) {
			super();
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString() {
			return "ListNode [value=" + value + ", next=" + next + "]";
		}
		
	}

}
