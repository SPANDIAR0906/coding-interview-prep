package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		
		reverseList(head);

	}

	private static void reverseList(ListNode head) {
		
		ListNode reversedList = null;
		System.out.println("Head is: " + head.toString());
		
		while(head != null) {
			ListNode next = head.next;
			head.next = reversedList;
			reversedList = head;
			head = next;
		}

		System.out.println("Reversed List is: " + reversedList.toString());
		
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	}

}
