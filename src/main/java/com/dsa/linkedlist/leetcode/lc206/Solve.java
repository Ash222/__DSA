package com.dsa.linkedlist.leetcode.lc206;

import com.dsa.common.linkedlist.lc.ListNode;

import java.util.Objects;

/* Given the head of a singly linked list, reverse the list, and return the reversed list.
 *  */
public class Solve {

	static void main() {
		final ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
				new ListNode(4, new ListNode(5, null)))));
		displayLL(head);
		final ListNode result = reverseList(head);
		displayLL(result);
	}

	private static void displayLL(final ListNode head) {
		System.out.println("LC206 :: Solve :: displayLL :: LinkedList ::: " + head);
	}

	private static ListNode reverseList(final ListNode head) {

		if (Objects.isNull(head) || Objects.isNull(head.next)) {
			return head;
		}

		ListNode current = head;
		ListNode previous = null;
		ListNode nextNode = null;

		while (!Objects.isNull(current)) {
			nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}

		return previous;
	}
}
