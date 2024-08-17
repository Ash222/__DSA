package com.dsa.recursion.problems.p7;

import java.util.Scanner;

public class Solve {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numberOfInput = sc.nextInt();
		sc.nextLine(); // Consume the remaining newline
		
		while (numberOfInput-- > 0) {
			
			String[] workArray = sc.nextLine().trim().split(" ");
			// int n = workArray.length;
			Node head = null;
			Node pre = null;
			
			for (String s : workArray) {
				
				int m = Integer.parseInt(s);
				int data = sc.nextInt();
				Node temp = new Node(data);
				
				if (head == null) {
					head = temp;
				} else {
					pre.next = temp;
				}
				
				pre = temp;
				Node preB = temp;
				
				for (int j = 0; j < m - 1; j++) {
					int tempData = sc.nextInt();
					Node tempB = new Node(tempData);
					preB.bottom = tempB;
					preB = tempB;
				}
			}
			
			// Consume the remaining newline if there's any
			if (sc.hasNextLine()) {
				sc.nextLine();
			}
			
			Node root = flatten(head);
			printList(root);
		}
		
		sc.close();
	}
	
	private static Node flatten(Node root) {
		// base case
		if (root == null) {
			return null;
		}
		
		Node head = flatten(root.next);
		return mergeSortedList(root, head);
	}
	
	private static Node mergeSortedList(Node list1, Node list2) {
		
		Node headNode = new Node(-1);
		Node tailNode = headNode;
		Node l1 = list1;
		Node l2 = list2;
		
		while (l1 != null && l2 != null) {
			
			if (l1.data <= l2.data) {
				tailNode.bottom = l1;
				l1 = l1.bottom;
			} else {
				tailNode.bottom = l2;
				l2 = l2.bottom;
			}
			
			tailNode = tailNode.bottom;
		}
		
		// merge remaining list
		if (l1 != null) {
			tailNode.bottom = l1;
		}
		if (l2 != null) {
			tailNode.bottom = l2;
		}
		
		return headNode.bottom;
	}
	
	private static void printList(Node node) {
		
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.bottom;
		}
		
		System.out.println();
	}
	
	private static class Node {
		
		int data;
		Node next;
		Node bottom;
		
		Node(int x) {
			data = x;
			next = null;
			bottom = null;
		}
	}
}
