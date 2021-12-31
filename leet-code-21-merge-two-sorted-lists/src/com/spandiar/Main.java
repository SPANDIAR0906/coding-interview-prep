package com.spandiar;


public class Main {

	public static void main(String[] args) {

		ListNode head1 = new ListNode(1, new ListNode(4, new ListNode(5, new ListNode(6, null))));
		ListNode head2 = new ListNode(2, new ListNode(3, new ListNode(6, null)));
		
		mergeList(head1, head2);
	}


	private static ListNode mergeList(ListNode head1, ListNode head2) {
		
		if(head1 == null && head2 == null) {
			return null;
		}
		

		if(head1 == null) {
			return head2;
		}
		

		if(head2 == null) {
			return head1;
		}
		
		ListNode mergedList = new ListNode();
		ListNode mergedListHead =  mergedList;
		
		while(head1 != null && head2 != null) {
			
			if (head1.val < head2.val) {
				mergedList.next = head1;
				head1 = head1.next;
				mergedList = mergedList.next;
			} else if(head1.val > head2.val) {
				mergedList.next = head2;
				head2 = head2.next;
				mergedList = mergedList.next;
			} else {
				mergedList.next = head1;
				mergedList = mergedList.next;
				mergedList.next = head2;
				head1 = head1.next;
				head2 = head2.next;
			}
			
			if(head1 == null) {
				mergedList.next = head2;
			}
			
			if(head2 == null) {
				mergedList.next = head1;
			}
			
		}
		
		System.out.println(mergedListHead.next);
		return mergedListHead.next;
		
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
