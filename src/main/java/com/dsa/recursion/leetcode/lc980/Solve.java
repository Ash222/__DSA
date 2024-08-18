package com.dsa.recursion.leetcode.lc980;

public class Solve {
	
	private final static int[] deltaRow = {-1, 0, 1, 0}; // URDL
	private final static int[] deltaColumn = {0, 1, 0, -1}; // URDL
	private static int n, m, numberOfNonObstacles, numberOfPaths;
	
	public static void main(String[] args) {
		
		final int[][] grid = {
				{1, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 2, -1}
		};
		int startingRow = 0;
		int startingColumn = 0;
		n = grid.length;
		m = grid[0].length;
		
		// getting starting row,column and numberOfNonObstacles
		for (int row = 0; row < n; row++) {
			for (int column = 0; column < m; column++) {
				
				if (grid[row][column] != -1) {
					numberOfNonObstacles++;
				}
				if (grid[row][column] == 1) {
					startingRow = row;
					startingColumn = column;
				}
			}
		}
		
		dfs(startingRow, startingColumn, 1, grid);
		
		System.out.println(numberOfPaths);
	}
	
	private static void dfs(final int row, final int column,
			final int countNonObstacle, final int[][] grid) {
		
		// base case
		if (row < 0 || column < 0 || row >= n || column >= m ||
				grid[row][column] == 3 || grid[row][column] == -1) {
			return;
		}
		
		if (grid[row][column] == 2) {
			
			if (numberOfNonObstacles == countNonObstacle) {
				numberOfPaths++;
			}
			
			return;
		}
		
		// traversing in all the 4 directions
		for (int i = 0; i < 4; i++) {
			
			final int _row = row + deltaRow[i];
			final int _column = column + deltaColumn[i];
			final int visited = grid[row][column];
			grid[row][column] = 3; // mark visited
			
			dfs(_row, _column, countNonObstacle + 1, grid);
			
			grid[row][column] = visited; // unmark the visited
		}
	}
}
