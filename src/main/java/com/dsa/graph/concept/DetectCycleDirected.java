package com.dsa.graph.concept;

import java.util.ArrayList;
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

	private static boolean isCycle(final int[][] edges, final int vertices,
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

	static void main() {
		final int[][] edges = {{1, 2}, {2, 3}, {3, 1}};
		final int N = 3; // number of vertices
		final int M = 3; // number of edges
		final boolean isCycle = isCycle(edges, N, M);
		System.out.println("DetectCycleDirected :: main :: isCycle ::: " + isCycle);
	}
}
