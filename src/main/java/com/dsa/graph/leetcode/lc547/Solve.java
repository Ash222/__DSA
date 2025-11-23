package com.dsa.graph.leetcode.lc547;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * There are n cities. Some of them are connected, while some are not. If city a is
 * connected directly with city b, and city b is connected directly with city c,
 * then city a is connected indirectly with city c. A province is a group of directly
 * or indirectly connected cities and no other cities outside the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city
 * and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 * */
public class Solve {

	private Solve() {
	}

	private static List<List<Integer>> createAdjList(final int[][] isConnected) {

		final int vertices = isConnected.length;
		final List<List<Integer>> adjacencyList = new ArrayList<>();

		for (int i = 0; i < vertices; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for (int u = 0; u < vertices; u++) {
			for (int v = 0; v < vertices; v++) {
				if (u != v && isConnected[u][v] == 1) {
					adjacencyList.get(u).add(v);
				}
			}
		}

		return adjacencyList;
	}

	private static void dfsAdj(final List<List<Integer>> adjacencyList,
			final boolean[] visited, final int startingNode) {

		visited[startingNode] = true;

		for (final int adjacentNode : adjacencyList.get(startingNode)) {

			if (!visited[adjacentNode]) {
				dfsAdj(adjacencyList, visited, adjacentNode);
			}
		}
	}

	private static int dfsAdj(final List<List<Integer>> adjacencyList,
			final int vertices) {

		final boolean[] visited = new boolean[vertices];
		int provinces = 0;

		for (int u = 0; u < vertices; u++) {

			if (!visited[u]) {
				dfsAdj(adjacencyList, visited, u);
				provinces++;
			}
		}

		return provinces;
	}

	private static int dfsAdj(final int[][] isConnected) {

		final List<List<Integer>> adjacencyList = createAdjList(isConnected);
		return dfsAdj(adjacencyList, isConnected.length);
	}

	private static void bfsAdj(final List<List<Integer>> adjacencyList,
			final boolean[] visited, final int startingNode) {

		final Deque<Integer> q = new LinkedList<>();
		q.offer(startingNode);
		visited[startingNode] = true;

		while (!q.isEmpty()) {

			final int currentNode = q.poll();

			for (final int adjacentNode : adjacencyList.get(currentNode)) {
				if (!visited[adjacentNode]) {
					q.offer(adjacentNode);
					visited[adjacentNode] = true;
				}
			}
		}
	}

	private static int bfsAdj(final int[][] isConnected) {

		final int vertices = isConnected.length;
		final boolean[] visited = new boolean[vertices];
		final List<List<Integer>> adjacencyList = createAdjList(isConnected);
		int provinces = 0;

		for (int u = 0; u < vertices; u++) {
			if (!visited[u]) {
				bfsAdj(adjacencyList, visited, u);
				provinces++;
			}
		}

		return provinces;
	}

	private static void dfs(final int[][] isConnected, final boolean[] visited,
			final int startingNode) {

		final int vertices = isConnected.length;
		visited[startingNode] = true;

		for (int adjacentNode = 0; adjacentNode < vertices; adjacentNode++) {
			if (!visited[adjacentNode] && isConnected[startingNode][adjacentNode] == 1) {
				dfs(isConnected, visited, adjacentNode);
			}
		}
	}

	private static int dfs(final int[][] isConnected) {

		final int vertices = isConnected.length;
		final boolean[] visited = new boolean[vertices];
		int provinces = 0;

		for (int u = 0; u < vertices; u++) {
			if (!visited[u]) {
				dfs(isConnected, visited, u);
				provinces++;
			}
		}

		return provinces;
	}

	private static void bfs(final int[][] isConnected, final boolean[] visited,
			final int startingNode) {

		final Deque<Integer> q = new LinkedList<>();
		final int vertices = isConnected.length;
		q.offer(startingNode);
		visited[startingNode] = true;

		while (!q.isEmpty()) {

			q.poll();

			for (int v = 0; v < vertices; v++) {
				if (!visited[v] && isConnected[startingNode][v] == 1) {
					q.offer(v);
					visited[v] = true;
				}
			}
		}
	}

	private static int bfs(final int[][] isConnected) {

		final int vertices = isConnected.length;
		final boolean[] visited = new boolean[vertices];
		int provinces = 0;

		for (int u = 0; u < vertices; u++) {
			if (!visited[u]) {
				bfs(isConnected, visited, u);
				provinces++;
			}
		}

		return provinces;
	}

	private static int findCircleNum(final int[][] isConnected) {
		return bfsAdj(isConnected);
	}

	static void main() {

		final int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		final int output = 2;
		final int result = findCircleNum(isConnected);
		System.out.println("LC547 :: Solve :: main :: result ::: " + (output == result));
	}
}
