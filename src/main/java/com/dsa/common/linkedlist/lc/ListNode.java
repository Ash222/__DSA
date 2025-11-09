package com.dsa.common.linkedlist.lc;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(final int val) {
		this.val = val;
	}

	public ListNode(final int val, final ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode{val=" + val + ", next=" + next + '}';
	}
}
