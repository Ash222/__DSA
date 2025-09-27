package com.dsa.linkedlist.leetcode.lc92;

public class Solve {
	
	private static class ListNode {
		int val;
		ListNode next;
		
		ListNode() {
		}
		
		ListNode(int val) {
			this.val = val;
		}
		
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		
		final int left = 2;
		final int right = 4;
		final ListNode head =
				new ListNode(1,
				             new ListNode(2,
				                          new ListNode(3,
				                                       new ListNode(4,
				                                                    new ListNode(
						                                                    5,
						                                                    null
				                                                    )
				                                       )
				                          )
				             )
				);
		
		displayList(head);
		
		final ListNode result = reverseBetween(head, left, right);
		
		displayList(result);
	}
	
	private static ListNode reverseBetween(final ListNode head, final int left,
			final int right) {
		
		ListNode leftPointer = null;
		ListNode rightPointer = null;
		ListNode leftPrevious = null;
		ListNode rightNext = null;
		ListNode current = head;
		
		// get the left pointer
		for (int i = 1; i < left; i++) {
			leftPrevious = current;
			current = current.next;
		}
		
		leftPointer = current;
		
		// get right pointer
		for (int i = 0; i < right - left; i++) {
			current = current.next;
		}
		
		rightPointer = current;
		rightNext = rightPointer.next;
		current = leftPointer;
		ListNode previous = rightNext;
		ListNode nextNode = null;
		
		// now we'll reverse the list between leftPointer and rightPointer
		while (current != rightNext) {
			nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}
		
		if (leftPrevious != null) {
			leftPrevious.next = previous;
		} else {
			return previous;
		}
		
		return head;
	}
	
	private static void displayList(final ListNode current) {
		ListNode head = current;
		while (head != null) {
			System.out.printf(head.val + "\t");
			head = head.next;
		}
		System.out.println();
	}
}
