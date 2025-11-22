package com.dsa.graph.concept;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DetectCycle {

	private static List<List<Integer>> createAdjList(final int[][] edges,
			final int vertices) {
		final List<List<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i <= vertices; i++) {
			adjList.add(new ArrayList<>());
		}

		for (final int[] edge : edges) {
			final int u = edge[0];
			final int v = edge[1];

			if (u >= 1 && u <= vertices && v >= 1 && v <= vertices) {
				adjList.get(u).add(v);
				adjList.get(v).add(u);
			}
		}

		return adjList;
	}

	private static boolean dfsCycle(final List<List<Integer>> adjacencyList,
			final boolean[] visited, final int currentNode, final int parentNode) {

		visited[currentNode] = true;

		for (final int adjacentNode : adjacencyList.get(currentNode)) {

			if (!visited[adjacentNode]) {
				if (dfsCycle(adjacencyList, visited, adjacentNode, currentNode)) {
					return true;
				}
			} else if (parentNode != adjacentNode) {
				// this condition means that we're visiting this node again, but it
				// will only be cyclic if the above conditions satisfies
				return true;
			}
		}

		return false;
	}

	private static boolean bfsCycle(final List<List<Integer>> adjacencyList,
			final boolean[] visited, final int startingNode) {

		final Deque<Pair> queue = new LinkedList<>(); // this is queue
		queue.offer(new Pair(startingNode, -1));
		visited[startingNode] = true;

		while (!queue.isEmpty()) {
			final Pair pair = queue.poll();
			final int parentNode = pair.parentNode;
			final int node = pair.node;

			for (final int adjacentNode : adjacencyList.get(node)) {

				if (!visited[adjacentNode]) {
					queue.offer(new Pair(adjacentNode, node));
					visited[adjacentNode] = true;
				} else if (adjacentNode != parentNode) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean cycleDetection(final int[][] edges, final int vertices,
			final int numberOfEdges) {

		if (numberOfEdges == 0) {
			return false;
		}

		final List<List<Integer>> adjacencyList = createAdjList(edges, vertices);
		final boolean[] visited = new boolean[vertices + 1]; // because the vertices
		// starts from 1 not from 0. So, we'll skip the 0 index.

		for (int i = 1; i <= vertices; i++) {
			if (!visited[i] && bfsCycle(adjacencyList, visited, i)) {
				return true;
			}
		}

		return false;
	}

	static void main() {

		final int[][] edges = {{1, 2}, {2, 3}}; // UDG; vertices starts from 1
		final int N = 3; // number of vertices
		final int M = 2; // number of edges
		final boolean isCycle = cycleDetection(edges, N, M);
		System.out.println("DetectCycle :: main :: isCycle ::: " + isCycle);
	}

	private static final class Pair {
		int node;
		int parentNode;

		Pair() {
		}

		Pair(final int node, final int parentNode) {
			this.node = node;
			this.parentNode = parentNode;
		}
	}
}
