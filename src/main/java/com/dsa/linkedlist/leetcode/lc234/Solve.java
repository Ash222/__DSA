package com.dsa.linkedlist.leetcode.lc234;

import com.dsa.common.linkedlist.lc.ListNode;
import com.dsa.common.linkedlist.util.DisplayUtil;
import com.dsa.common.linkedlist.util.HelperUtil;

import java.util.Objects;

public class Solve {

	// TC :: O(n) & SC :: O(n); SC here depends on while reverse algo you're using, i.e.,
	// recursive or iterative one. Also, it is 3 pass solution
	private static boolean approach1(final ListNode ll) {
		if (Objects.isNull(ll) || Objects.isNull(ll.next)) {
			return true;
		}

		ListNode slow = ll;
		ListNode fast = ll;

		while (!Objects.isNull(fast) && !Objects.isNull(fast.next)) {
			slow = slow.next;
			fast = fast.next.next;
		}

		fast = ll;
		slow = HelperUtil.reverseLinkedListRecursively(slow);

		while (!Objects.isNull(slow)) {
			if (fast.val != slow.val) {
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}

		return true;
	}

	// TC :: O(n) & SC :: O(1) ; this is 2 pass solution
	private static boolean approach2(final ListNode head) {
		if (Objects.isNull(head) || Objects.isNull(head.next)) {
			return true;
		}

		ListNode slow = head;
		ListNode fast = head;
		ListNode previous = null;

		while (!Objects.isNull(fast) && !Objects.isNull(fast.next)) {
			fast = fast.next.next;
			ListNode nextNode = slow.next;
			slow.next = previous;
			previous = slow;
			slow = nextNode;
		}

		if (!Objects.isNull(fast)) {
			slow = slow.next;
		}

		while (!Objects.isNull(slow) && !Objects.isNull(previous)) {
			if (slow.val != previous.val) {
				return false;
			}
			slow = slow.next;
			previous = previous.next;
		}

		return true;
	}

	private static boolean isPalindrome(final ListNode head) {
		return approach2(head);
	}

	static void main() {
		final ListNode ll = new ListNode(1, new ListNode(2, new ListNode(2,
				new ListNode(1, null))));
		DisplayUtil.displayLinkedListLC(ll);
		final boolean result = isPalindrome(ll);
		System.out.println("LC234 :: Solve :: main :: result ::: " +
				                   (Boolean.TRUE.equals(result)));
	}
}
