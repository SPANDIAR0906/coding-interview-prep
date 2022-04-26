/*
 * Leet Code # 328 - Linked List
 * Spent close to 2.5 hrs before looking at Nick White solution
 * 
 * */
package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
//		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		
		stichAlternateNodes(head);
	}
	
	private static ListNode stichAlternateNodes(ListNode head) {
		
		ListNode oddList = head;
		ListNode oddListBegin = oddList;
		ListNode evenList = head.next;
		ListNode evenListBegin = evenList;
		
		while(oddList != null && oddList.next != null) {
			oddList.next = oddList.next.next;
			oddList = oddList.next;
		}
		
		while(evenList != null && evenList.next != null) {
			evenList.next = evenList.next.next;
			evenList = evenList.next;
		}
		
		System.out.println(oddListBegin);
//		oddList.next = evenListBegin;
		
		return oddListBegin;
		
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
