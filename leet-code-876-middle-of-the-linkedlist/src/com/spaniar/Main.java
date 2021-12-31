package com.spaniar;

public class Main {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode (4, new ListNode(5, new ListNode(6, null))))));
		System.out.println(head);
		
		getMiddleNode(head);

	}
	
	private static ListNode getMiddleNode(ListNode head) {
		
		if(head == null) return head;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;
				
		}
		
		System.out.println("Middle Node is: " + slow);
		return slow;
		
	}

	public static class ListNode {
		
		int val;
		ListNode next;
		
		
		public ListNode() {
			super();
			// TODO Auto-generated constructor stub
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
