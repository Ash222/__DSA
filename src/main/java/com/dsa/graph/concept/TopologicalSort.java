package com.dsa.graph.concept;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Topological sorting is a linear ordering of vertices in a Directed Acyclic Graph
 * (DAG) such that for every directed edge from vertex (u) to vertex (v), vertex (u)
 * comes before vertex (v) in the sequence. There can be multiple topological sorting
 * results.
 *  */
public class TopologicalSort {

	private TopologicalSort() {
	}

	private static List<List<Integer>> createAdjList(final int[][] edges,
			final int vertices) {

		final List<List<Integer>> adjacencyList = new ArrayList<>();

		for (int i = 0; i < vertices; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for (final int[] edge : edges) {

			final int u = edge[0];
			final int v = edge[1];

			if (u >= 0 && v >= 0 && u < vertices && v < vertices) {
				adjacencyList.get(u).add(v);
			}
		}

		return adjacencyList;
	}

	private static void dfs(final List<List<Integer>> adjacencyList,
			final boolean[] visited, final Deque<Integer> stack, final int startingNode) {

		visited[startingNode] = true;

		for (final int adjacentNode : adjacencyList.get(startingNode)) {

			if (!visited[adjacentNode]) {
				dfs(adjacencyList, visited, stack, adjacentNode);
			}
		}

		stack.push(startingNode);
	}

	private static List<Integer> topologicalSort(
			final List<List<Integer>> adjacencyList, final boolean[] visited,
			final int vertices) {

		final List<Integer> topologicalSort = new ArrayList<>();
		final Deque<Integer> stack = new LinkedList<>();

		for (int i = 0; i < vertices; i++) {

			if (!visited[i]) {
				dfs(adjacencyList, visited, stack, i);
			}
		}

		while (!stack.isEmpty()) {
			topologicalSort.add(stack.pop());
		}

		return topologicalSort;
	}

	private static List<Integer> topologicalSortDFS(
			final List<List<Integer>> adjacencyList, final int vertices) {

		final boolean[] visited = new boolean[vertices];
		return topologicalSort(adjacencyList, visited, vertices);
	}

	private static List<Integer> kahnAlgorithm(final List<List<Integer>> adjacencyList,
			final int vertices) {

		final int[] inDegree = new int[vertices];
		final Deque<Integer> q = new LinkedList<>();
		final List<Integer> result = new ArrayList<>();

		// populate the indegree of all the nodes
		for (int u = 0; u < vertices; u++) {
			for (final int v : adjacencyList.get(u)) {
				inDegree[v]++;
			}
		}

		// fill the 0 indegree nodes in the queue
		for (int i = 0; i < vertices; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}

		// now only push the nodes in queue if the indegree is 0 and in each visit keep
		// subtracting the indegree by 1 and once it 0 push it in the queue. And for
		// each pop from the queue push it into the result.
		while (!q.isEmpty()) {

			final int currentNode = q.poll();
			result.add(currentNode);

			for (final int adjacentNode : adjacencyList.get(currentNode)) {

				inDegree[adjacentNode]--;
				if (inDegree[adjacentNode] == 0) {
					q.offer(adjacentNode);
				}
			}
		}

		return result;
	}

	private static List<Integer> topologicalSortBFS(
			final List<List<Integer>> adjacencyList, final int vertices) {

		return kahnAlgorithm(adjacencyList, vertices);
	}

	static void main() {

		final int[][] edges = {
				{0, 2}, {0, 3}, {2, 3}, {2, 1}, {3, 1}, {1, 4}, {5, 1}, {5, 4}
		};
		final int vertices = 6;
		final int numberOfEdges = 8;
		final List<List<Integer>> adjacencyList = createAdjList(edges, vertices);
		final List<Integer> topologicalSortDFS = topologicalSortDFS(adjacencyList,
				vertices);
		final List<Integer> topologicalSortBFS = topologicalSortBFS(adjacencyList,
				vertices);
		System.out.println("TopologicalSort :: main :: topological sort \n :: dfs ::: " +
				                   topologicalSortDFS + "\n :: bfs ::: " +
				                   topologicalSortBFS);
	}
}
