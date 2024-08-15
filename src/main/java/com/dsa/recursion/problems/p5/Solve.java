package com.dsa.recursion.problems.p5;

import java.util.ArrayList;

public class Solve {
	
	public static void main(String[] args) {
		
		final int[][] matrix = {
				{1, 0, 0, 0},
				{1, 1, 0, 1},
				{1, 1, 0, 0},
				{0, 1, 1, 1}
		};
		// DDRDRR DRDDRR
		final ArrayList<String> result = findPath(matrix);
		System.out.println(result);
	}
	
	public static ArrayList<String> findPath(int[][] mat) {
		
		final int[] deltaRow = {-1, 1, 0, 0}; // Up, Down, Right, Left
		final int[] deltaColumn = {0, 0, 1, -1}; // // Up, Down, Right, Left
		final ArrayList<String> result = new ArrayList<>();
		final int n = mat.length - 1;
		final boolean[][] visited = new boolean[n + 1][n + 1];
		
		// No path possible if start or end is blocked
		if (mat[0][0] == 0 || mat[n][n] == 0) {
			return result;
		}
		
		dfs(0, 0, n, mat, deltaRow, deltaColumn, "", result, visited);
		return result;
	}
	
	private static void dfs(final int row, final int column,
			final int n, final int[][] mat, final int[] deltaRow,
			final int[] deltaColumn, final String moves, final ArrayList<String> result
			, final boolean[][] visited) {
		
		// base case
		if (row == n && column == n) {
			result.add(moves);
			return;
		}
		
		final String direction = "UDRL";
		
		// iterating in all the four directions
		for (int i = 0; i < 4; i++) {
			
			final int nextRow = row + deltaRow[i];
			final int nextColumn = column + deltaColumn[i];
			if (isValid(nextRow, nextColumn, n) && !visited[nextRow][nextColumn]
					&& mat[nextRow][nextColumn] == 1) {
				
				visited[row][column] = true;
				dfs(nextRow, nextColumn, n, mat, deltaRow, deltaColumn, moves +
						direction.charAt(i), result, visited);
				visited[row][column] = false;
			}
		}
	}
	
	private static boolean isValid(final int row, final int column, final int n) {
		return row >= 0 && row <= n && column >= 0 && column <= n;
	}
}
