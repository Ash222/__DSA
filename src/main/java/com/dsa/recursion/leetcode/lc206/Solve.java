package com.dsa.recursion.leetcode.lc206;

public class Solve {
	
	public ListNode reverseList(ListNode head) {
		
		// base case
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode last = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		
		return last;
	}
	
	public static class ListNode {
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
}
