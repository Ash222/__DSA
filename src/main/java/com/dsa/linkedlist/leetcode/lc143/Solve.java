package com.dsa.linkedlist.leetcode.lc143;

import com.dsa.common.linkedlist.lc.ListNode;
import com.dsa.common.linkedlist.util.DisplayUtil;

import java.util.Objects;

public class Solve {

	private static ListNode reverseRecursively(final ListNode head) {
		if (Objects.isNull(head) || Objects.isNull(head.next)) {
			return head;
		}

		final ListNode last = reverseRecursively(head.next);
		head.next.next = head;
		head.next = null;
		return last;
	}

	private static void approach1(final ListNode head) {
		if (Objects.isNull(head) || Objects.isNull(head.next)) {
			return;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (!Objects.isNull(fast) && !Objects.isNull(fast.next)) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode reverse = reverseRecursively(slow);
		slow = head;

		while (!Objects.isNull(reverse) && !Objects.isNull(reverse.next)) {
			ListNode slowNextNode = slow.next;
			ListNode reverseNextNode = reverse.next;
			slow.next = reverse;
			reverse.next = slowNextNode;
			slow = slowNextNode;
			reverse = reverseNextNode;
		}
	}

	private static void approach2(final ListNode head, final ListNode[] currentNodeArr) {
		if (Objects.isNull(head)) {
			return;
		}
		approach2(head.next, currentNodeArr);
		if (Objects.isNull(currentNodeArr[0].next)) {
			return;
		} else if (currentNodeArr[0] == head) {
			currentNodeArr[0].next = null;
			return;
		}
		ListNode currentNextNode = currentNodeArr[0].next;
		currentNodeArr[0].next = head;
		head.next = currentNextNode == head ? null : currentNextNode;
		currentNodeArr[0] = currentNextNode;
	}

	private static void reorderList(final ListNode ll) {
		approach2(ll, new ListNode[]{ll});
	}

	static void main() {
		final ListNode ll = new ListNode(1, new ListNode(2, new ListNode(3,
				new ListNode(4, null))));
		DisplayUtil.displayLinkedListLC(ll);
		reorderList(ll);
		DisplayUtil.displayLinkedListLC(ll);
	}
}
