package com.spandiar;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		reverseList(head);
//		reverseListAlternate(head);

	}

	private static void reverseListAlternate(ListNode head) {
		
		ListNode reversed = null;
		
		while(head != null) {
			ListNode next = head.next;
			head.next = reversed;
			reversed = head;
			head = next;
		}
		
		System.out.println(reversed);
	}

	private static void reverseList(ListNode head) {
		
		ListNode reversed = new ListNode();
		ListNode reversedStart = reversed;
		
		if(head == null) {
			return;
		}
		
		Stack<ListNode> stack = new Stack<>();
		
		while(head != null) {
			stack.push(head);
			head = head.next;
		}
		
		while(!stack.isEmpty()) {
			ListNode current = stack.pop();
			current.next = null;
			reversed.next = current;
			reversed = reversed.next;
		}
		
		System.out.println(reversedStart.next);
		
	}
	
	

	public static class ListNode {
		
		int val;
		ListNode next;
		
		public ListNode() {
			super();
		}
		
		public ListNode(int val) {
			super();
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			super();
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
		
	}

}
