package com.spandiar;

public class Main {

	public static void main(String[] args) {

		ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(0)))));
		System.out.println(head);

		ListNode sortedListNode = sortList(head);
		
		System.out.println("sorted list is: " + sortedListNode);

	}

	private static ListNode sortList(ListNode node) {
		
		if(node == null || node.next == null) return node;
		
		ListNode slow = node;
		ListNode fast = node;
		ListNode temp = slow;
		
		while(fast != null && fast.next != null) {
			temp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		temp.next = null;
		
		ListNode leftSide = sortList(node);
		ListNode rightSide = sortList(slow);
		
		return mergeLists(leftSide, rightSide);
		
	}
	
	

	private static ListNode mergeLists(ListNode leftSide, ListNode rightSide) {
		
		ListNode result = new ListNode(0);
		ListNode resultHead = result;
		
		while(leftSide != null && rightSide != null) {
			
			if(leftSide.value < rightSide.value) {
				result.next = leftSide;
				leftSide = leftSide.next;
			} else {
				result.next = rightSide;
				rightSide = rightSide.next;
			}
			result = result.next;
		}
		
		if(leftSide != null) {
			result.next = leftSide;
		}
		
		if(rightSide != null) {
			result.next = rightSide;
		}
		
		return resultHead.next;
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
