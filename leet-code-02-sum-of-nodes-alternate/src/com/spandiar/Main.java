package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		LinkedListNode l1 = new LinkedListNode(8, new LinkedListNode(2, new LinkedListNode(5, null)));
		LinkedListNode l2 = new LinkedListNode(4, new LinkedListNode(9, new LinkedListNode(2, null)));
		
		int sum = addLinkedListValues(l1, l2);
		
		System.out.println("Sum is: " + sum);

	}
	

	private static int addLinkedListValues(LinkedListNode l1, LinkedListNode l2) {
		
		int value1 = getValueFromNode(l1);
		int value2 = getValueFromNode(l2);
		
		return value1 + value2;
	}


	private static int getValueFromNode(LinkedListNode list) {
		
		int value = 0;
		int multiplyFactor = 1;
		
		while(list != null) {
			value += list.value * multiplyFactor;
			multiplyFactor *= 10;
			list = list.next;
		}
		
		System.out.println("Returning value " + value);
		
		return value;
	}


	static class LinkedListNode {
		
		int value;
		LinkedListNode next;
		
		public LinkedListNode() {
			super();
		}

		public LinkedListNode(int value, LinkedListNode next) {
			super();
			this.value = value;
			this.next = next;
		}
		
	}

}
