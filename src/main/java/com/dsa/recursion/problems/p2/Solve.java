package com.dsa.recursion.problems.p2;

public class Solve {
	
	public static void main(String[] args) {
		
		final int numberOfDisks = 3;
		final char fromRod = 'A';
		final char toRod = 'B';
		final char auxiliaryRod = 'C';
		final long minimumNumberOfSteps = towerOfHanoi(numberOfDisks, fromRod, toRod,
				auxiliaryRod);
		System.out.println("minimum number of steps required to " +
				"solve for disks n(" + numberOfDisks + ") tower of hanoi is " +
				minimumNumberOfSteps);
	}
	
	// this will send the minimum number of step taken to solve the
	// tower of hanoi problem
	private static long towerOfHanoi(final int n, final char fromRod, final char toRod,
	                                 final char auxiliaryRod) {
		
		// base case
		if (n == 1) {
			System.out.println("move disk " + n + " from " + fromRod + " to " + toRod);
			return 1;
		}
		
		// minimum steps taken to move (n-1) disks from fromRod to auxiliaryRod
		// with the help of toRod.
		long minimumSteps = towerOfHanoi(n - 1, fromRod, auxiliaryRod, toRod);
		System.out.println("move disk " + n + " from " + fromRod + " to " + toRod);
		// now we will move the n-th disk from fromRod to toRod. This will take
		// exactly 1 step.
		minimumSteps = minimumSteps + 1;
		// now we will move (n-1) disks from auxiliaryRod to toRod with the help
		// of fromRod. This will take some step, which will be added to "minimumSteps"
		// and then returned.
		return minimumSteps + towerOfHanoi(n - 1, auxiliaryRod, toRod, fromRod);
	}
}
