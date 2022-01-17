package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(3)))))));

		System.out.println(head);
		
		ListNode result = deleteDuplicatesAlternate(head);
		System.out.println(head);
	}
	
	private static ListNode deleteDuplicatesAlternate(ListNode node) {
		
		ListNode pointer1 = node;
		ListNode pointer2 = pointer1.next;
		ListNode head = pointer1;
		
		while(pointer1 != null && pointer2 != null) {
			
			if(pointer1.value == pointer2.value) {
				pointer2 = pointer2.next;
				pointer1.next = pointer2;
			} else {
				pointer1 = pointer1.next;
				pointer2 = pointer2.next;
			}
			
		}
		
		return head;
	}

	private static ListNode deleteDuplicates(ListNode node) {
		
		ListNode begin = new ListNode(0);
		ListNode head = begin;
		begin.next = node;
		
		while(begin.next != null && begin.next.next != null) {
			
			if(begin.next.value == begin.next.next.value) {
				begin.next = begin.next.next;
			}
			begin = begin.next;
		}
		
		return head.next;
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
