package com.dsa.common.linkedlist.util;

import com.dsa.common.linkedlist.lc.ListNode;

import java.util.Objects;

public class HelperUtil {

	private HelperUtil() {
	}

	public static ListNode reverseLinkedListRecursively(final ListNode linkedList) {
		if (Objects.isNull(linkedList) || Objects.isNull(linkedList.next)) {
			return linkedList;
		}

		final ListNode lastNode = reverseLinkedListRecursively(linkedList.next);
		linkedList.next.next = linkedList;
		linkedList.next = null;
		return lastNode;
	}

	public static ListNode reverseLinkedList(final ListNode linkedList) {
		if (Objects.isNull(linkedList) || Objects.isNull(linkedList.next)) {
			return linkedList;
		}

		ListNode previous = null;
		ListNode current = linkedList;

		while (!Objects.isNull(current)) {
			ListNode nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}

		return previous;
	}
}
