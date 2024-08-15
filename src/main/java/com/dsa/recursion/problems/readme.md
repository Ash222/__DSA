## These are separate problems on recursion

___

1. Reverse a given stack using recursion.
2. Tower of Hanoi.
3. Mergesort.
4. Quicksort.
5. Consider a rat placed at (0, 0) in a square matrix mat of order n*n. It has to reach the destination at
   (n-1, n-1). Find all possible paths that the rat can take to reach from source to destination. The directions 
   in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix 
   represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that 
   rat can be travel through it.
   Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other
   cell. In case of no path, return an empty list. The driver will output "-1" automatically.
   
   ***Input*** : mat[][] = [
       [1, 0, 0, 0],
       [1, 1, 0, 1],
       [1, 1, 0, 0],
       [0, 1, 1, 1]
   ]

   ***Output*** : ["DDRDRR", "DRDDRR"]

6. You are given a Binary Search Tree (BST) with n nodes, each node has a distinct value assigned to it. The goal is 
   to flatten the tree such that, the left child of each element points to nothing (NULL), and the right child points 
   to the next element in the sorted list of elements of the BST (look at the examples for clarity). 
   You must accomplish this without using any extra storage, except for recursive calls, which are allowed.
   Note: If your BST does have a left child, then the system will print a -1 and will skip it, resulting in an 
   incorrect solution.

   ***Input*** : 5 3 7 2 4 6 8

   ***Output*** : 2 3 4 5 6 7 8