/*
 * 234. Palindrome Linked List
 * Given the head of a singly linked list, return true if it is a palindrome.
 * 
 * */

package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
//		ListNode head = new ListNode(6, new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));
		ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));
				
		boolean result = checkIfPalindrome(head);
		
		System.out.println("Result is: " + result);
	}
	
	
	private static boolean checkIfPalindrome(ListNode head) {
		
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		System.out.println("Head is " + head);
		System.out.println("Slow is " + slow);
		System.out.println("Fast is " + fast);
		
		slow = reverse(slow);
		fast = head;
		
		
		while(slow != null) {
			if(slow.val != fast.val) {
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}
		
		return true;
	}


	private static ListNode reverse(ListNode slow) {
		
		ListNode reversedNode = null;
		
		while(slow != null) {
			ListNode next = slow.next;
			slow.next = reversedNode;
			reversedNode = slow;
			slow = next;
		}
		
		return reversedNode;
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
