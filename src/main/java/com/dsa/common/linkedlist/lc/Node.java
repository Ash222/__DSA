package com.dsa.common.linkedlist.lc;

import java.util.Objects;

public class Node {

	public int val;
	public Node next;
	public Node random;

	public Node(final int val, final Node next, final Node random) {
		this.val = val;
		this.next = next;
		this.random = random;
	}

	@Override
	public String toString() {
		return "Node{val=" + val + ", next=" + next + ", randomNodeVal=" +
				       (Objects.isNull(random) ? -1 : random.val) + '}';
	}
}
