package com.dsa.collections.leetcode.lc2225;

import java.util.HashMap;
import java.util.Map;

public class Solve {
	
	public static void main(String[] args) {
		
		final int[][] input = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
				{4, 8}, {4, 9}, {10, 4}, {10, 9}};
		solve(input);
	}
	
	private static void solve(final int[][] input) {
		
		final Map<Integer, Integer> lossNumberMap = new HashMap<>();
		
		for (final int[] playerArr : input) {
			final int winningPlayer = playerArr[0];
			final int losingPlayer = playerArr[1];
			lossNumberMap.put(winningPlayer, lossNumberMap.getOrDefault(winningPlayer, 0));
			lossNumberMap.put(losingPlayer, lossNumberMap.getOrDefault(losingPlayer, 0) + 1);
		}
		
		System.out.println("lossNumberMap ::: " + lossNumberMap);
	}
}
