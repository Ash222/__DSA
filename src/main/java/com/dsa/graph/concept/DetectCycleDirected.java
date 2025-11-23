package com.dsa.graph.concept;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DetectCycleDirected {

	private DetectCycleDirected() {
	}

	private static List<List<Integer>> createAdjList(final int[][] edges,
			final int vertices) {
		final List<List<Integer>> adjacencyList = new ArrayList<>();

		for (int i = 0; i <= vertices; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for (final int[] edge : edges) {

			final int u = edge[0];
			final int v = edge[1];

			if (u >= 1 && v >= 1 && u <= vertices && v <= vertices) {
				adjacencyList.get(u).add(v);
			}
		}

		return adjacencyList;
	}

	private static boolean isCycleDFS(final List<List<Integer>> adjacencyList,
			final boolean[] visited, final boolean[] inRecursion,
			final int startingNode) {

		visited[startingNode] = true;
		inRecursion[startingNode] = true;

		for (final int adjacentNode : adjacencyList.get(startingNode)) {

			if ((!visited[adjacentNode] && isCycleDFS(adjacencyList, visited, inRecursion,
					adjacentNode)) || (visited[adjacentNode] &&
							                   inRecursion[adjacentNode])) {
				return true;
			}
		}

		inRecursion[startingNode] = false;
		return false;
	}

	// this is nothing but kahn algorithm tweak
	private static boolean isCycleBFS(final List<List<Integer>> adjacencyList,
			final int vertices) {

		final int[] inDegree = new int[vertices + 1];
		final Deque<Integer> q = new LinkedList<>();
		int countVisitedNode = 0;

		for (int u = 1; u <= vertices; u++) {
			for (final int v : adjacencyList.get(u)) {
				inDegree[v]++;
			}
		}

		for (int u = 1; u <= vertices; u++) {
			if (inDegree[u] == 0) {
				q.offer(u);
			}
		}

		while (!q.isEmpty()) {

			final int currentNode = q.poll();

			for (final int adjacentNode : adjacencyList.get(currentNode)) {

				inDegree[adjacentNode]--;
				if (inDegree[adjacentNode] == 0) {
					q.offer(adjacentNode);
					countVisitedNode++;
				}
			}
		}

		return countVisitedNode == vertices;
	}

	private static boolean isCycleDFS(final int[][] edges, final int vertices,
			final int numberOfEdges) {

		final List<List<Integer>> adjacencyList = createAdjList(edges, vertices);
		final boolean[] visited = new boolean[vertices + 1];
		final boolean[] inRecursion = new boolean[vertices + 1];

		for (int i = 1; i <= vertices; i++) {

			if (!visited[i] && isCycleDFS(adjacencyList, visited, inRecursion, i)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCycleBFS(final int[][] edges, final int vertices,
			final int numberOfEdges) {

		final List<List<Integer>> adjacencyList = createAdjList(edges, vertices);
		return isCycleBFS(adjacencyList, vertices);
	}

	static void main() {
		final int[][] edges = {{1, 2}, {2, 3}, {3, 1}};
		final int N = 3; // number of vertices
		final int M = 3; // number of edges
		final boolean isCycle = isCycleBFS(edges, N, M);
		System.out.println("DetectCycleDirected :: main :: isCycle ::: " + isCycle);
	}
}
