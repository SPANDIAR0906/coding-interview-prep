package com.spandiar;

public class Main {

	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		
		ListNode.addNode(5, l1);
		ListNode.addNode(7, l1);
		ListNode.addNode(9, l1);
		
		ListNode.addNode(4, l2);
		ListNode.addNode(6, l2);
		ListNode.addNode(8, l2);
		
		ListNode.printNodeElements(l1);
		ListNode.printNodeElements(l2);
		
		ListNode summedListNode = ListNode.addTwoListValues(l1, l2);
		
		System.out.println("Final Result Is: ");
		ListNode.printNodeElements(summedListNode);

	}

	public static class ListNode {

		int value;
		ListNode next;

		public ListNode() {
			super();
			// TODO Auto-generated constructor stub
		}

		public static ListNode addTwoListValues(ListNode l1, ListNode l2) {
			
			int l1TotalValue = getListNodeValue(l1, 1, 0);
			int l2TotalValue = getListNodeValue(l2, 1, 0);
			
			int sumOfListNodes = l1TotalValue + l2TotalValue;
			
			return addValueToListNode(sumOfListNodes);
			
		}

		public static ListNode addValueToListNode(int sumOfListNodes) {
			
			ListNode result = null;
			
			while(sumOfListNodes % 10 > 0) {
				
				int valueToAdd = sumOfListNodes % 10;
				result = ListNode.addNode(valueToAdd, result);
				sumOfListNodes = sumOfListNodes/10;
				
			}
			
			return result;
		}

		public ListNode(int value) {
			super();
			this.value = value;
		}
		
		public static ListNode addNode(int value, ListNode node) {
			
			if(node == null) {
				node = new ListNode(value);
				return node;
			}
			
			if(node != null) {
				node.next = addNode(value, node.next);
			}
			
			return node;
		}
		
		public static void printNodeElements(ListNode node) {
			
			if(node != null) {
				System.out.println(node.toString());
				printNodeElements(node.next);
			}
			
		}
		
		public static int getListNodeValue(ListNode node, int multiplyFactor, int totalValue) {
			
			if(node != null) {
				totalValue += node.value * multiplyFactor;
				multiplyFactor *= 10;
				totalValue = getListNodeValue(node.next, multiplyFactor, totalValue);
			}
			
			return totalValue;
		}

		@Override
		public String toString() {
			return "ListNode [value=" + value + "]";
		}
		
	}

}
