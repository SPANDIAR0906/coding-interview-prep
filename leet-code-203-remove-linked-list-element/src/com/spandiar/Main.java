package com.spandiar;

import com.spandiar.Main.ListNode;

public class Main {

	public static void main(String[] args) {
		
//		ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
//		ListNode head = new ListNode(7, new ListNode(3, new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(2)))))));
		ListNode head = new ListNode(1);
		System.out.println(head);
		
		ListNode result = removeElements(head, 1);
		System.out.println(result);
		
	}
	

	private static ListNode removeElements(ListNode node, int deleteValue) {
		
		if(node != null && node.value == deleteValue) {
			node = node.next;
		}
		
		ListNode currentNode = node;
		
		while(currentNode != null && currentNode.next != null) {
			if(currentNode.next.value == deleteValue) {
				currentNode.next = currentNode.next.next;
			} else {
				currentNode = currentNode.next;
			}
		}
		
		return node;
	}


	public static class ListNode {
		
		int value;
		ListNode next;
		
		
		public ListNode() {
			super();
			// TODO Auto-generated constructor stub
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
