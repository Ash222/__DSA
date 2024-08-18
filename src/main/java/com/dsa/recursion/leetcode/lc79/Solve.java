package com.dsa.recursion.leetcode.lc79;

public class Solve {
	
	static int m;
	static int n;
	static int l;
	final static int[] deltaRow = {-1, 0, 1, 0}; // URDL
	final static int[] deltaColumn = {0, 1, 0, -1}; // URDL
	
	public static void main(String[] args) {
		
		final char[][] board = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'},
		};
		final String word = "ABCCED";
		n = board.length;
		m = board[0].length;
		l = word.length();
		final boolean doesWordExists = exists(board, word);
		
		System.out.println(doesWordExists);
	}
	
	private static boolean exists(final char[][] board, final String word) {
		
		for (int row = 0; row < n; row++) {
			
			for (int column = 0; column < m; column++) {
				
				if (board[row][column] == word.charAt(0) &&
						dfs(row, column, 0, word, board)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean dfs(final int row, final int column, final int index,
			final String word, final char[][] board) {
		
		// base case
		if (index >= l) {
			return true;
		}
		
		if (row < 0 || column < 0 || row >= n || column >= m || board[row][column] == '$'
				|| board[row][column] != word.charAt(index)) {
			return false;
		}
		
		// traverse in the four directions
		for (int i = 0; i < 4; i++) {
			
			final int _row = row + deltaRow[i];
			final int _column = column + deltaColumn[i];
			final char temp = board[row][column];
			board[row][column] = '$'; // mark visited
			
			if (dfs(_row, _column, index + 1, word, board)) {
				return true;
			}
			
			board[row][column] = temp; // unmark visited
		}
		
		return false;
	}
	
}
