package com.dsa.linkedlist.leetcode.lc1669;

import com.dsa.common.linkedlist.lc.ListNode;
import com.dsa.common.linkedlist.util.DisplayUtil;

import java.util.Objects;

public class Solve {

	static void main() {
		final ListNode list1 = new ListNode(0, new ListNode(1, new ListNode(2,
				new ListNode(3, new ListNode(4, new ListNode(5,
						new ListNode(6, null)))))));
		final ListNode list2 = new ListNode(10000, new ListNode(10001,
				new ListNode(10002, new ListNode(10003,
						new ListNode(10004, null)))));
		final int a = 2;
		final int b = 5;
		DisplayUtil.displayLinkedListLC(list1);
		DisplayUtil.displayLinkedListLC(list2);
		final ListNode result = mergeInBetween(list1, a, b, list2);
		DisplayUtil.displayLinkedListLC(result);
	}

	private static ListNode mergeInBetween(final ListNode list1, final int a, final int b,
			final ListNode list2) {

		ListNode left = null;
		ListNode right = list1;

		for (int i = 0; i <= b; i++) {
			if (i==a - 1) {
				left = right;
			}
			right = right.next;
		}

		if (!Objects.isNull(left)) {
			left.next = list2;
		}

		while (!Objects.isNull(left) && !Objects.isNull(left.next)) {
			left = left.next;
		}

		if (!Objects.isNull(left)) {
			left.next = right;
		}

		return list1;
	}
}
