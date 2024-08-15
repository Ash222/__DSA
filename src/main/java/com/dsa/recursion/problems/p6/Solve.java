package com.dsa.recursion.problems.p6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solve {
	
	private static Node previousNode;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numberOfInput = sc.nextInt();
		sc.nextLine(); // Consume newline
		
		while (numberOfInput-- > 0) {
			// next line contains the elements in level order (for BST)
			String str = sc.nextLine();
			Node root = buildTree(str);
			Node ans = flattenBST(root);
			printList(ans);
		}
		
		sc.close();
	}
	
	// flattening the bst
	private static Node flattenBST(Node root) {
		
		Node tempNode = new Node(-1);
		previousNode = tempNode;
		
		inorder(root);
		
		previousNode.left = null;
		previousNode.right = null;
		
		return tempNode.right;
	}
	
	// inorder traversal on the binary tree
	private static void inorder(Node currentNode){
		
		// base case
		if(currentNode==null){
			return;
		}
		
		inorder(currentNode.left);
		previousNode.right = currentNode;
		previousNode.left = null;
		previousNode = currentNode;
		inorder(currentNode.right);
	}
	
	// converts the level order input to binary tree
	private static Node buildTree(String str) {
		
		if (str.isEmpty() || str.charAt(0) == 'N') {
			return null;
		}
		
		String[] ip = str.split("\\s+");
		int index = 0;
		
		Node root = new Node(Integer.parseInt(ip[index++]));
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty() && index < ip.length) {
			
			Node currNode = queue.poll();
			String currVal = ip[index++];
			
			if (!currVal.equals("N")) {
				currNode.left = new Node(Integer.parseInt(currVal));
				queue.add(currNode.left);
			}
			
			if (index >= ip.length) {
				break;
			}
			
			currVal = ip[index++];
			
			if (!currVal.equals("N")) {
				currNode.right = new Node(Integer.parseInt(currVal));
				queue.add(currNode.right);
			}
		}
		
		return root;
	}
	
	private static void printList(Node head) {
		
		while (head != null) {
			
			if (head.left != null) {
				System.out.print("-1 ");
			}
			
			System.out.print(head.data + " ");
			head = head.right;
		}
		
		System.out.println();
	}
	
	private static class Node {
		int data;
		Node left, right;
		
		Node(int val) {
			data = val;
			left = right = null;
		}
	}
}
