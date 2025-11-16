package com.dsa.linkedlist.leetcode.lc92;

import com.dsa.common.linkedlist.lc.ListNode;
import com.dsa.common.linkedlist.util.DisplayUtil;

import java.util.Objects;

public class Solve {

	private static ListNode reverseLL(final ListNode head) {

		if (Objects.isNull(head) || Objects.isNull(head.next)) {
			return head;
		}

		ListNode current = head;
		ListNode previous = null;

		while (!Objects.isNull(current)) {
			ListNode nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}

		return previous;
	}

	private static ListNode recursiveReverseLL(final ListNode head) {

		if (Objects.isNull(head) || Objects.isNull(head.next)) {
			return head;
		}
		ListNode last = recursiveReverseLL(head.next);
		head.next.next = head;
		head.next = null;
		return last;
	}

	private static ListNode approach1(final ListNode head, final int left,
			final int right) {

		if (Objects.isNull(head) || Objects.isNull(head.next)) {
			return head;
		}

		ListNode dummyNode = new ListNode(Integer.MIN_VALUE, head);
		ListNode previous = dummyNode;

		for (int i = 1; i < left; i++) {
			previous = previous.next;
		}

		ListNode current = previous.next;

		for (int i = 1; i <= right - left; i++) {
			ListNode previousNext = previous.next;
			ListNode nextNode = current.next;
			previous.next = nextNode;
			current.next = nextNode.next;
			nextNode.next = previousNext;
		}

		return dummyNode.next;
	}

	private static ListNode approach2(final ListNode head, final int left,
			final int right) {

		if (Objects.isNull(head) || Objects.isNull(head.next)) {
			return head;
		}

		final ListNode dummyNode = new ListNode(Integer.MIN_VALUE, head);
		ListNode current = dummyNode.next;
		ListNode leftPointer = null;

		for (int i = 1; i < right; i++) {
			if (i < left) {
				leftPointer = current;
			}
			current = current.next;
		}

		ListNode rightPointer = current.next;
		current.next = null;

		ListNode reverseList = recursiveReverseLL(leftPointer.next);
		leftPointer.next = reverseList;
		current = reverseList;

		while (!Objects.isNull(current) && !Objects.isNull(current.next)) {
			current = current.next;
		}

		if (Objects.isNull(current)) {
			leftPointer.next = rightPointer;
		} else {
			current.next = rightPointer;
		}

		return dummyNode.next;
	}

	private static ListNode reverseBetween(final ListNode head, final int left,
			final int right) {
		return approach2(head, left, right);
	}

	static void main() {

		final ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
				new ListNode(4, new ListNode(5, null)))));
		final int left = 2;
		final int right = 4;
		DisplayUtil.displayLinkedListLC(head);

		final ListNode result = reverseBetween(head, left, right);
		DisplayUtil.displayLinkedListLC(result);
	}
}
