package com.dsa.linkedlist.leetcode.lc138;

import com.dsa.common.linkedlist.lc.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solve {

	private static Node makeHeaderNode() {
		final Node A = new Node(7, null, null);
		final Node B = new Node(13, null, null);
		final Node C = new Node(11, null, null);
		final Node D = new Node(10, null, null);
		final Node E = new Node(1, null, null);
		A.next = B;
		B.next = C;
		B.random = A;
		C.next = D;
		C.random = E;
		D.next = E;
		D.random = C;
		E.random = A;
		return A;
	}

	private static void displayNode(final Node head) {
		System.out.println("LC138 :: Solve :: displayNode :: Node ::: " + head);
	}

	static void main() {
		final Node head = makeHeaderNode();
		displayNode(head);
		final Node result = copyRandomList(head);
		displayNode(result);
	}

	// TC :: O(n) & SC :: O(1)
	private static Node copyRandomList(final Node head) {

		if (Objects.isNull(head)) {
			return head;
		}

		// insert the new nodes in between the original list
		Node current = head;
		while (!Objects.isNull(current)) {
			Node newNode = new Node(current.val, null, null);
			newNode.next = current.next;
			current.next = newNode;
			current = newNode.next;
		}

		// deep copy of the random pointers
		current = head;
		while (!Objects.isNull(current) && !Objects.isNull(current.next)) {
			if (Objects.isNull(current.random)) {
				current.next.random = null;
			} else {
				current.next.random = current.random.next;
			}
			current = current.next.next;
		}

		// now separate out the new nodes
		current = head;
		Node newCurrent = current.next;
		Node newHead = newCurrent;
		while (!Objects.isNull(current) && !Objects.isNull(newCurrent)) {
			current.next = Objects.isNull(current.next) ? null : current.next.next;
			newCurrent.next = Objects.isNull(newCurrent.next) ?
					                  null : newCurrent.next.next;
			current = current.next;
			newCurrent = newCurrent.next;
		}

		return newHead;
	}

	// TC :: O(n) & SC :: O(n)
	private static Node deepCopyRandomList(final Node head) {

		if (Objects.isNull(head)) {
			return head;
		}

		Node current = head;
		Node previous = new Node(Integer.MIN_VALUE, null, null);
		Node tail = previous;
		Map<Node, Node> currentVsNewNodeRandomMap = new HashMap<>();

		// create new nodes
		while (!Objects.isNull(current)) {

			Node newNode = new Node(current.val, null, null);
			currentVsNewNodeRandomMap.put(current, newNode);
			previous.next = newNode;
			previous = newNode;
			current = current.next;
		}

		// fill the random pointers
		current = head;
		Node temp = tail;
		while (!Objects.isNull(current)) {
			tail.next.random = Objects.isNull(current.random) ? null :
					                   currentVsNewNodeRandomMap.get(
							                   current.random);
			tail = tail.next;
			current = current.next;
		}

		return temp.next;
	}
}
