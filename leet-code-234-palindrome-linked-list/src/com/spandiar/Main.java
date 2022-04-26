/*
 * 234. Palindrome Linked List
 * Given the head of a singly linked list, return true if it is a palindrome.
 * 
 * */

package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(7, new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));
//		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
				
		boolean result = checkIfPalindrome(head);
		
		System.out.println("Result is: " + result);
	}
	
	
	private static boolean checkIfPalindrome(ListNode head) {
		
		if(head == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode reversed = reverseRemainingNodes(slow);
		
		return evaluatePalindrome(head, reversed);
		
	}

	private static ListNode reverseRemainingNodes(ListNode middle) {
		
		ListNode reversed = null;
//		ListNode reversed = newHead;
		
		while(middle != null) {
			ListNode nextNode = middle.next;
			middle.next = reversed;
			reversed = middle;
			middle = nextNode;
		}
		
		return reversed;
	}


	private static boolean evaluatePalindrome(ListNode head, ListNode reversed) {
		
		while(reversed != null) {
			if(head.val != reversed.val) {
				return false;
			}
			reversed = reversed.next;
			head = head.next;
		}
		
		return true;
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
