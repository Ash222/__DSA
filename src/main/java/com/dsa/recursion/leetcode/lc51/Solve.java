package com.dsa.recursion.leetcode.lc51;

import java.util.ArrayList;
import java.util.List;

// N-Queens
public class Solve {
	
	public static void main(String[] args) {
		
		final int n = 4;
		final List<List<String>> result = solveNQueens(n);
		System.out.println(result);
	}
	
	private static List<List<String>> solveNQueens(final int n) {
		
		List<List<String>> result = new ArrayList<>();
		List<String> board = new ArrayList<>();
		
		if (n == 0) {
			return result;
		}
		
		// filling the board of (n*n) with "." (empty)
		for (int i = 0; i < n; i++) {
			board.add(".".repeat(n));
		}
		
		dfs(0, board, result);
		
		return result;
	}
	
	private static void dfs(final int row, final List<String> board,
			final List<List<String>> result) {
		
		// base case
		final int n = board.size();
		if (row >= n) {
			result.add(new ArrayList<>(board));
			return;
		}
		
		// trying to place queens in all the columns of the row
		for (int column = 0; column < n; column++) {
			
			// place the queen in the next row only when it is not under attack
			if (!isQueenUnderAttack(row, column, board)) {
				
				StringBuilder currentRow = new StringBuilder(board.get(row));
				currentRow.setCharAt(column, 'Q');
				board.set(row, currentRow.toString());
				
				dfs(row + 1, board, result);
				
				currentRow.setCharAt(column, '.');
				board.set(row, currentRow.toString());
			}
		}
	}
	
	/* Steps to check if the queen is under attack :
	 * 1. If queen is already present directly upwards.
	 * 2. If queen is already present in right diagonal.
	 * 3. If queen is already present in anti-diagonal. */
	private static boolean isQueenUnderAttack(final int row, final int column,
			final List<String> board) {
		
		final int n = board.size();
		// is the queen under attack from the upwards
		for (int i = row - 1; i >= 0; i--) {
			
			if (board.get(i).charAt(column) == 'Q') {
				return true;
			}
		}
		
		// is the queen under attack from diagonal (upward-right)
		for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
			
			if (board.get(i).charAt(j) == 'Q') {
				return true;
			}
		}
		
		// is the queen under attack from anti-diagonal (upward-left)
		for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
			
			if (board.get(i).charAt(j) == 'Q') {
				return true;
			}
		}
		
		return false;
	}
}
